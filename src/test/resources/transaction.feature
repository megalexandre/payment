Feature: Testing Transaction API

  Scenario: making a transactions
    When I send a POST with body
    """
    {
      "payerId" : "01HQ34HPVKXYCGG8MYE2QCZ98G",
      "payeeId" : "01HQ34HPVK0RRA7CA2E2MNK37H",
      "value": 5
    }
    """
    Then status code should be 200