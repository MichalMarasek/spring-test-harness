Feature: Google text search

  Scenario: user can search any keyword 2

    Given an open browser with google.com
    When a keyword "selenide" is entered in input field
    Then at least top 1 matches should be shown
    Then the first one should contain "selenide.org"

  Scenario: user search for price 2

    Given an open browser with google.com
    When a keyword "selenide price" is entered in input field
    Then at least top 1 matches should be shown
    Then the first one should contain "price"