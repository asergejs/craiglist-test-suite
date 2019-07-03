package com.github.asergejs.steps

import com.github.asergejs.model.enums.SearchSortOption
import com.github.asergejs.pages.SalesPage
import com.google.inject.Inject
import cucumber.api.java.en.And
import com.google.common.collect.Ordering

import static com.github.asergejs.model.enums.SearchSortOption.*
import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

class SalesPageSteps {

    @Inject
    SalesPage salesPage

    @And("user clicks on search sort dropdown menu")
    void changeLanguageToEnglish() {
        salesPage.clickOnSearchSortDropdown()
    }

    @And("user searches for (.*)")
    void enterTextInSearchField(String text) {
        salesPage.enterTextInSearchField(text)
        salesPage.clickSearchButton()
    }

    @And("user chooses (.*) sorting option")
    void enterTextInSearchField(SearchSortOption searchSortOption) {
        salesPage.chooseSearchSortDropdownOption(searchSortOption)
    }

    @And("available search sort dropdown menu options are:")
    void checkAvailableSearchSortOptions(List expectedValues) {
        List actualValues = salesPage.getSearchSortDropdownValues()
        assertThat("Search sort dropdown values doesn't match",
                expectedValues, equalTo(actualValues))
    }

    @And("prices are not being sorted")
    void checkThatPricesAreNotSorted() {
        List listOfPricesDividedByCurrency = salesPage.getSeparatedCurrencyPricesList()
        listOfPricesDividedByCurrency.each { eachCurrencyPriceList ->
            assertThat("Price for ${eachCurrencyPriceList.first().currency} currency is sorted by price up",
                    Ordering.natural().isOrdered(eachCurrencyPriceList), is(false))
            assertThat("Price for ${eachCurrencyPriceList.first().currency} currency is sorted by price down",
                    Ordering.natural().reverse().isOrdered(eachCurrencyPriceList), is(false))
        }
    }

    @And("prices are being sorted by (.*)")
    void checkThatPricesAreSorted(SearchSortOption option) {
        List listOfPricesDividedByCurrency = salesPage.getSeparatedCurrencyPricesList()
        listOfPricesDividedByCurrency.each { eachCurrencyPriceList ->
            if(option == PRICE_UP) {
                assertThat("Price for ${eachCurrencyPriceList.first().currency} currency is not sorted by price up",
                        Ordering.natural().isOrdered(eachCurrencyPriceList), is(true))
            } else {
                assertThat("Price for ${eachCurrencyPriceList.first().currency} currency is not sorted by price down",
                        Ordering.natural().reverse().isOrdered(eachCurrencyPriceList), is(true))
            }

        }
    }

}
