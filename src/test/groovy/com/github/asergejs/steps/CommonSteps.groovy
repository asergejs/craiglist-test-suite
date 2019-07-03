package com.github.asergejs.steps

import com.github.asergejs.pages.MainPage
import com.google.inject.Inject
import cucumber.api.java.en.Given

import static com.codeborne.selenide.Selenide.open

class CommonSteps {

    @Inject
    MainPage mainPage

    @Given("user opens main page")
    void userOpensPage() {
        open(mainPage.pageUrl)
    }

}
