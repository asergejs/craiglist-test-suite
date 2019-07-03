package com.github.asergejs.config

import com.codeborne.selenide.Configuration
import com.google.inject.AbstractModule

class ConfigModule extends AbstractModule {

    @Override
    protected void configure() {
        Configuration.browser = "config.ChromeWebDriver"
    }

}
