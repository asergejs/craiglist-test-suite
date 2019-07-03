Feature: Advertisements sorting feature

  Background:
    Given user opens main page
    And user changes language to english
    And user clicks on housing page

  Scenario: User should be able to sort results by price
    And prices are not being sorted
    And user clicks on search sort dropdown menu
    And user chooses PRICE_UP sorting option
    And prices are being sorted by PRICE_UP
    Then user clicks on search sort dropdown menu
    And user chooses PRICE_DOWN sorting option
    And prices are being sorted by PRICE_DOWN


  Scenario: User should be able to sort search results by relevantly
    And user clicks on search sort dropdown menu
    Then available search sort dropdown menu options are:
      | upcoming |
      | newest   |
      | price ↑  |
      | price ↓  |
    And user searches for studio
    And user clicks on search sort dropdown menu
    Then available search sort dropdown menu options are:
      | upcoming |
      | newest   |
      | relevant |
      | price ↑  |
      | price ↓  |






