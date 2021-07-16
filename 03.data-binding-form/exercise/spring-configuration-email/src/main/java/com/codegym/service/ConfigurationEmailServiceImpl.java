package com.codegym.service;

import com.codegym.model.ConfigurationEmail;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationEmailServiceImpl implements ConfigurationEmailService {
    private static ConfigurationEmail oldConfigurationEmail = new ConfigurationEmail("English",10,true,"thor");
    @Override
    public void updateConfigurationEmail(ConfigurationEmail configurationEmail) {
        oldConfigurationEmail.setLanguage(configurationEmail.getLanguage());
        oldConfigurationEmail.setPageSize(configurationEmail.getPageSize());
        oldConfigurationEmail.setSpamsFilter(configurationEmail.isSpamsFilter());
        oldConfigurationEmail.setSignature(configurationEmail.getSignature());
    }

    @Override
    public ConfigurationEmail getConfiguration() {
        return oldConfigurationEmail;
    }
}
