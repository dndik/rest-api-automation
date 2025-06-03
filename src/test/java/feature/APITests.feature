Feature: Manage Objects via RESTful API

  Scenario: Add a new object
    Given I create an object with:
      | name  | Apple MacBook Pro 16 |
      | CPU   | Intel Core i9        |
      | price | 1849.99              |
    When I send a POST request to add the object
    Then the response status code should be 200
    And the response should contain the object name "Apple MacBook Pro 16"
    And I store the object ID

  Scenario: Retrieve the object created in the first scenario by ID
    When I send a GET request for the object by ID
    Then the response status code should be 200
    And the response should contain the object name "Apple MacBook Pro 16"

  Scenario: List all objects
    When I send a GET request to list all objects
    Then the response status code should be 200
    And the response should contain a non-empty list of objects

  Scenario: Delete the object created in the first scenario by ID
    When I send a DELETE request for the object by ID
    Then the response status code should be 200
    And the object should no longer exist
