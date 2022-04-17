Feature: Mortgage Calculator

  @calculateApr
  Scenario: Calculate Real Apr rate
    Given a user is in mortgage calculator home page
    And user navigate to Real Apr page
    When user clicks on calculate button upon entering the data
    |HomePrice|DownPayment|InterestRate|
    |200000   |15000      |3           |
    Then the real apr rate is "3.130%"