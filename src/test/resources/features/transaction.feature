Feature: Testing Transaction API

  Scenario:
    When try "individual" do a transaction to a "legal"
    Then status code should be 201

  Scenario:
    When try "individual" do a transaction to a "individual"
    Then status code should be 201

  Scenario:
    When try "legal" do a transaction to a "individual"
    Then status code should be 400
    And message should be "this payer is not authorized to do a transaction"

  Scenario:
    When try do a transaction where value exceed wallet
    Then status code should be 400
    And message should be "this transactions is not valid"

  Scenario:
    When transaction attempt person is not found
    Then status code should be 400
    And message should content "there is no person with id"
