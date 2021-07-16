package com.codegym.service;

import com.codegym.model.ConfigurationEmail;

public interface ConfigurationEmailService {
    void updateConfigurationEmail(ConfigurationEmail configurationEmail);

    ConfigurationEmail getConfiguration();
}
