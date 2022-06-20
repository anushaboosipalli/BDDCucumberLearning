Feature:Amazon Cart

  Scenario: Amazon  Cart  section
    Given Open browser and enter amazon url "https://www.amazon.in"
    When Search for product "iPhone" and add to cart and proceed to checkout
    Then Close all opened browsers