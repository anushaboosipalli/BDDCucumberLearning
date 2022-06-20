@TopSeller
Feature: Add a Vehicle

  Scenario: Add a Vehicle
    Given Open browser and navigate to the aap "https://shop.advanceautoparts.com"
    When Scroll down to Top Sellers
    And Get the Top Sellers
    Then Close all the opened browsers