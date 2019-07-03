package com.github.asergejs.pages


import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Selenide.$

class MainPage extends Page {

    private static final PAGE_URL = "http://helsinki.craiglist.com"

    private def englishLanguageBtn = $('a[href*="lang=en"]')
    private def linkToHousing = $('[data-alltitle="all housing"]')

    @Override
    void expectPageElements() {
        englishLanguageBtn.shouldBe(visible)
        linkToHousing.shouldBe(visible)
    }

    void changeLanguageToEnglish() {
        englishLanguageBtn.click()
    }

    void clickOnHousingSectionLink() {
        linkToHousing.click()
    }

    String getPageUrl() {
        PAGE_URL
    }


}
