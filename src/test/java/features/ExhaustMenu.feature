@ExhaustMenu
Feature: Exhaust Menu

  Scenario: Get Exhaust Menu list
    Given Open browser and navigate app "https://shop.advanceautoparts.com"
    When Navigate form ShopAll to Exhaust menu
    Then Click on more and get The Exhaust Menu list
    Then Close the browser