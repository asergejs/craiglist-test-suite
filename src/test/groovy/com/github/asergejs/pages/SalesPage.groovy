package com.github.asergejs.pages

import com.codeborne.selenide.SelenideElement
import com.github.asergejs.model.Price
import com.github.asergejs.model.enums.SearchSortOption

import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$

class SalesPage extends Page {

    private def searchSortDropdown = $('.search-sort .dropdown-list')
    private def searchSortDropdownValues = $$('.dropdown-list.dropdown-show .dropdown-item.mode')
    private def searchResultPrices = $$('.result-row .result-price')
    private def searchTextfield = $('input[type="text"]')
    private def searchButton = $('button[type="submit"]')

    @Override
    void expectPageElements() {
        searchSortDropdown.shouldBe(visible)
        searchTextfield.shouldBe(visible)
        searchButton.shouldBe(visible)
    }

    void clickOnSearchSortDropdown() {
        searchSortDropdown.click()
    }

    void enterTextInSearchField(String text) {
        searchTextfield.sendKeys(text)
    }

    void clickSearchButton() {
        searchButton.click()
    }

    void chooseSearchSortDropdownOption(SearchSortOption option) {
        searchSortDropdownValues.find { value -> value.getText().equals(option.value) }.click()
    }

    List getSearchSortDropdownValues() {
        searchSortDropdownValues.collect { element -> element.getText() }
    }

    List getSeparatedCurrencyPricesList() {
        List separatedCurrencyPricesList = []
        List allPricesList = priceListForAllCurrencies
        List currenciesList = getListOfPresentCurrencies(allPricesList)

        currenciesList.each { currency ->
            separatedCurrencyPricesList << getPriceListByCurrency(currency, allPricesList)
        }
        separatedCurrencyPricesList
    }

    private List getPriceListForAllCurrencies() {
        searchResultPrices.collect { element ->
            new Price(currency: fetchPriceCurrency(element), amount: fetchPriceAmount(element))
        }
    }

    private List getListOfPresentCurrencies(List<Price> priceList) {
        priceList.unique(false) { it.currency }.collect { it.currency }
    }

    private List getPriceListByCurrency(String currency, List<Price> unsortedList) {
        unsortedList.findAll { price ->
            price.currency.equals(currency)
        }
    }

    private long fetchPriceAmount(SelenideElement element) {
        element.getText().replaceAll("[^0-9]", "") as long
    }

    private String fetchPriceCurrency(SelenideElement element) {
        element.getText().split("\\d+").first()
    }
}
