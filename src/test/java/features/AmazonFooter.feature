@Footer
Feature:Amazon Footer

  Scenario: Amazon  footer  section
    Given Open browser and enter url "https://www.amazon.com"
    When Get all the footer list
    Then Close The Browser
