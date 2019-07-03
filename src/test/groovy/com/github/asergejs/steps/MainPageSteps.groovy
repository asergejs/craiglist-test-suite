package com.github.asergejs.steps

import com.github.asergejs.pages.MainPage
import com.github.asergejs.pages.SalesPage
import com.google.inject.Inject
import cucumber.api.java.en.And

class MainPageSteps {

    @Inject
    MainPage mainPage
    @Inject
    SalesPage salesPage


    @And("user changes language to english")
    void changeLanguageToEnglish() {
        mainPage.changeLanguageToEnglish()
    }

    @And("user clicks on housing page")
    void clicksOnHousingPage() {
        mainPage.clickOnHousingSectionLink()
        salesPage.expectPageElements()
    }

}
