package br.com.card.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParse {

    private static Gson gson = new GsonBuilder().create();

    public static Object fromJson(String json, Class<?> clazz) throws IllegalAccessException {
        Object result = gson.fromJson(json, clazz);
        return result;
    }

    public static String toJson(Object object) throws IllegalAccessException {
        String jsonValue = gson.toJson(object);
        return jsonValue;
    }

}
