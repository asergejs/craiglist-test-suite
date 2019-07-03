package com.github.asergejs

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(Cucumber.class)
@CucumberOptions(features = 'classpath:features',
        glue = ['classpath:com.github.asergejs'],
        plugin = [
                "pretty",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:build/cucumber-report/cucumber.json",
                "html:build/cucumber-report/cucumber.html",
                "junit:build/cucumber-report/cucumber.xml"])
class CukesRunner {
}
