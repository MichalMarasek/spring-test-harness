Feature: RestAPI test using restassured

  Scenario: Check status code for specific customer

    Given using this url "http://demo.guru99.com/V4/sinkministatement.php"
    When Customer ID is "68195" password is "1234!" and account no is "1"
    Then Status code is 200
    And Print response time


  Scenario: Check response content type

    Given using this url "http://demo.guru99.com/V4/sinkministatement.php"
    Then Response content type is "text/html; charset=UTF-8"
    And Print response time

  Scenario: Check total value amount for specific customer

    Given using this url "http://demo.guru99.com/V4/sinkministatement.php"
    When Customer ID is "68195" password is "1234!" and account no is "1"
    Then Total value amount is 1015
    And Print response time
