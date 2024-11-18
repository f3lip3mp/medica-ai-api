package com.medicaai.medicaai.util;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvUtil {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getEnvVariable(String key) {
        return dotenv.get(key);
    }
}