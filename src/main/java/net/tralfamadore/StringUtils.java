package net.tralfamadore;

/**
 * Class: StringUtils
 * Created by billreh on 4/28/17.
 */
public class StringUtils {
    public static String trim(String str) {
        if(str == null)
            return null;
        return str.replaceFirst("^\\s+", "").trim();
    }

    public static String capitalize(String str) {
        if(str == null)
            return null;
        return str.toUpperCase().substring(0,1) + str.substring(1);
    }

    public static String uncapitalize(String str) {
        if(str == null)
            return null;
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

    public static boolean isEmpty(String str) {
        return str == null || trim(str).isEmpty();
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    public static String toCamelCase(String str) {
        if(str == null)
            return null;
        if(str.contains("_")) {
            String[] parts = str.split("_");
            StringBuilder stringBuilder = new StringBuilder(parts[0].toLowerCase());
            for(int i = 1; i < parts.length; i++) {
                stringBuilder.append(capitalize(parts[i].toLowerCase()));
            }
            return stringBuilder.toString();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String toUpperCamelCase(String str) {
        if(str == null)
            return null;
        return str.substring(0,1).toUpperCase() + toCamelCase(str).substring(1);
    }

    public static String toDbCase(String str) {
        if(str == null)
            return null;
        if(str.contains("_"))
            return str.toUpperCase();
        int idx;
        String s = str.substring(0,1).toLowerCase() + str.substring(1);
        while((idx = indexOfFirstCapitalLetter(s)) != -1) {
            s = s.substring(0, idx) + "_" + s.substring(idx, idx + 1).toLowerCase() + s.substring(idx + 1);
        }
        return s.toUpperCase();
    }

    private static int indexOfFirstCapitalLetter(String str) {
        for(int i = 0; i < str.length(); i ++) {
            if(Character.isUpperCase(str.charAt(i)))
                return i;
        }
        return -1;
    }
}
