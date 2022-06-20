@Vehicle
Feature: Add a Vehicle

  Scenario: Add a Vehicle
    Given Open browser and navigate to "https://shop.advanceautoparts.com"
    When User Add Vehicle Year "2022" and Make "Audi" and Model "A4" and Engine "DMSA"
    Then Close browsers