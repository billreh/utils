package net.tralfamadore;

import com.google.gson.Gson;

/**
 * Class: JsonUtils
 * Created by billreh on 4/30/17.
 */
@SuppressWarnings("WeakerAccess")
public class JsonUtils {
    private static final Gson gson = new Gson();

    public static String toJson(Object o) {
        return gson.toJson(o);
    }
}
