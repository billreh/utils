package net.tralfamadore;

import java.io.File;
import java.util.function.Consumer;

/**
 * Class: DirectoryMonitor
 * Created by billreh on 4/29/17.
 */
public class DirectoryMonitor {
    private File directory;

    /**
     * Create a new DirectoryMonitor that monitors the given directory.
     * @param directoryName The directory to monitor.
     */
    public DirectoryMonitor(String directoryName) {
        this.directory = new File(directoryName);
    }

    /**
     * Monitors the configured directory for appearance of new files.  When a new file appears, reads all lines
     * and feeds them to <code>callback</code>.
     * @param callback The callback to process the contents of the file, given as a list of lines.
     * @throws InterruptedException
     */
    public void monitor(Consumer<File> callback) throws InterruptedException {
        while(true) {
            File[] files = directory.listFiles();
            if(files != null && files.length > 0) {
                for (File file : files) {
                    callback.accept(file);
                    file.delete();
                }
            }
            Thread.sleep(100);
        }
    }
}
