package com.alexanderfisher.portfolio.api.springboot.service;

public interface AppConfigProvider {
    String getDatabaseUrl() throws Exception;
    String getDatabaseUser() throws Exception;
    String getDatabasePassword() throws Exception;
}
