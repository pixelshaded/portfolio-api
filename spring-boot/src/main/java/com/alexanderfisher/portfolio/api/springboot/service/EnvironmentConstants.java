package com.alexanderfisher.portfolio.api.springboot.service;

public class EnvironmentConstants {
    public static final String PREFIX = "PORTFOLIO_API_SPRING_BOOT_";
    public static final String DATABASE_URL = PREFIX + "DATABASE_URL";
    public static final String DATABASE_USER = PREFIX + "DATABASE_USER";
    public static final String DATABASE_PASSWORD = PREFIX + "DATABASE_PASSWORD";

    public static String getRequiredEnvironmentVariable(String environmentVariable) throws Exception {
        String value = System.getenv(environmentVariable);
        if (value == null) {
            throw new Exception("Required environment variable " + environmentVariable + " is not defined.");
        }
        return value;
    }

    public static String getEnvironmentVariable(String environmentVariable) {
        return System.getenv(environmentVariable);
    }
}
