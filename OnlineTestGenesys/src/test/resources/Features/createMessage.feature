Feature: CreateMessages

  Scenario Outline: verify the user is able to create messages
    Given input data to create messages "<sourcePayload>"
    When user make a post call
    Then user should receive the <statusCode>
    And user should receive the "<attributeId>" in the response body

    Examples:
    |sourcePayload|statusCode|attributeId|
    |createPayload.json|200  |id         |

    Scenario: Verify the user is able to get the message details by using the ID
      When user make a get request to get the message details by using id
      Then user should receive the <200>
      And user should receive the "id" in the response body

    Scenario Outline: Verify the user is able to get the message details by using the from and to name
      When user make a get request to get the list of message details "<from>" "<to>"
      Then user should receive the <statusCode>

      Examples:
      |from|to|statusCode|
      |testfrom|testto|200|

  Scenario: Verify the user is able to delete the message details by using the ID
    When user make a delete request to delete the message details by using id
    Then user should receive the <204>
