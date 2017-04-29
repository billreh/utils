package net.tralfamadore;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by wreh on 4/28/2017.
 * Properties file access through a singleton.
 */
@SuppressWarnings("WeakerAccess")
public class ApplicationProperties {
    /** The default properties file.  It will be projectName.properties */
    private String defaultProps;
    /** A Cache of properties objects */
    private LoadingCache<String, Properties> propertiesCache;

    private static class AppPropsHelper {
        private static final ApplicationProperties INSTANCE = new ApplicationProperties();
    }

    private ApplicationProperties() {
        /* The default properties file key.  Name of the project base directory */
        defaultProps = new File("").getAbsoluteFile().getName();
        /* Refresh the cache every 5 minutes */
        propertiesCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build(
                new CacheLoader<String, Properties>() {
                    @Override
                    public Properties load(String propsFile) throws Exception {
                        return readProps(propsFile);
                    }
                }
        );
    }

    public static ApplicationProperties getInstance() {
        return AppPropsHelper.INSTANCE;
    }

    /**
     * Get a property as a string from the default properties file.
     * @param name The property name to look up.
     * @return The property value, or Optional.empty if not found.
     */
    public Optional<String> getProperty(String name) {
        return getProperty(defaultProps, name);
    }

    /**
     * Get a property as a string from the specified properties file.
     * @param propsFile The name of the properties file to use, without the .properties extension.
     * @param name The property name to look up.
     * @return The property value, or Optional.empty if not found.
     */
    public Optional<String> getProperty(String propsFile, String name) {
        String prop = propertiesCache.getUnchecked(propsFile).getProperty(name);
        if(prop == null || trim(prop).isEmpty())
            return Optional.empty();
        return Optional.of(prop);
    }

    /**
     * Get a properties object from the default properties file.
     * @return The property value, or Optional.empty if not found.
     */
    public Properties getProperties() {
        return getProperties(defaultProps);
    }

    /**
     * Get a properties object from the specified properties file.
     * @param propertiesFile The name of the properties file to use, without the .properties extension.
     * @return The property value, or Optional.empty if not found.
     */
    public Properties getProperties(String propertiesFile) {
        return propertiesCache.getUnchecked(propertiesFile);
    }

    /**
     * Get a property as a boolean from the default properties file.
     * @param name The property name to look up.
     * @return True if the property is found and is equal to "true" (case insensitive).  False otherwise.
     */
    public boolean getPropertyBoolean(String name) {
        return getPropertyBoolean(defaultProps, name);
    }


    /**
     * Get a property as a boolean from the default properties file.
     * @param propsFile The name of the properties file to use, without the .properties extension.
     * @param name The property name to look up.
     * @return True if the property is found and is equal to "true" (case insensitive).  False otherwise.
     */
    public boolean getPropertyBoolean(String propsFile, String name) {
        Optional<String> prop = getProperty(propsFile, name);
        return prop.isPresent() && "true".equals(prop.get().toLowerCase());
    }

    /**
     * Read in all of the properties from a properties file.
     * @param baseName The name of the properties file, without the .properties extension.
     * @return A Properties object with properties read from the given properties file.
     */
    private Properties readProps(String baseName) {
        final String propertiesFileName = baseName + ".properties";
        final ClassLoader classLoader = getClass().getClassLoader();
        final URL resource = classLoader.getResource(propertiesFileName);

        if(resource == null)
            throw new RuntimeException("Can't find " + propertiesFileName);

        File propertiesFile = new File(resource.getFile());

        if(!propertiesFile.exists())
            throw new RuntimeException("Can't find " + propertiesFileName);

        Properties props = new Properties();

        try {
            Files.lines(propertiesFile.toPath()).forEach(line -> {
                if(trim(line).startsWith("#"))
                    return;

                if(!line.contains("="))
                    return;

                final String[] kv = line.split("=");
                final String key = trim(kv[0]);
                final String value = trim(kv[1]);

                props.put(key, value);
            });
        } catch (IOException e) {
            throw new RuntimeException("Error reading " + propertiesFileName, e);
        }

        return props;
    }

    /**
     * Trim leading and trailing space.
     * @param str The string to trim.
     * @return The trimmed string.
     */
    private static String trim(String str) {
        if(str == null)
            return null;
        return str.replaceFirst("\\s+", "").trim();
    }
}