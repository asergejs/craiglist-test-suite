package com.github.asergejs.config

import com.codeborne.selenide.WebDriverProvider
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities

class ChromeWebDriver implements WebDriverProvider {


    @Override
    WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        WebDriverManager.chromedriver().setup()
        return new ChromeDriver()
    }


}
