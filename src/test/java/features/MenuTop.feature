Feature: Top Menu

  Scenario: Get Top Menu Items
    Given Open browser and navigate to the "https://shop.advanceautoparts.com"
    When Get all the Top MenuItems
    Then Close the browsers