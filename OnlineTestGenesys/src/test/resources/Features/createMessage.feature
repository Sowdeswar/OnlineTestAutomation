Feature: CreateMessages

  @CreateUser
  Scenario Outline: Creating the users
    Given input data to create users "<sourcePayload>"
    When user make a post call
    Then user should receive the <statusCode>
    And user should receive the user id "<attributeId>" in the response body

    Examples:
      |sourcePayload|statusCode|attributeId|
      |createUser.json|200  |id       |
      |createUser.json|200  |id         |

  @CreateMessage
  Scenario Outline: verify the user is able to create messages
    Given input data to create messages "<sourcePayload>" and "<attributeType>"
    When user make a create message post call
    Then user should receive the <statusCode>
    And user should receive the "<attributeId>" in the response body

    Examples:
    |sourcePayload|attributeType|statusCode|attributeId|
    |createPayload.json| createMessage  |200  |id         |

#  Scenario: Verify the user is able to get the message details by using the ID
#    When user make a get request to get the message details by using id
#    Then user should receive the <200>
#    And user should receive the "id" in the response body

  @CreateMessage
  Scenario Outline: Verify the user is able to get the message details by using the ID
    When user make a get request to get the message details by using "<idType>"
    Then user should receive the <statusCode>

    Examples:
    |idType|statusCode|
    |Valid |200       |
    |Invalid|404      |

  @CreateMessage
  Scenario: Verify the user is able to get the message details by using the from and to name
      When user make a get request to get the list of message details using fromuserid and touserid
      Then user should receive the <200>

  @CreateMessage
  Scenario Outline: verify the user is able to update messages
    Given input data to create messages "<sourcePayload>" and "<attributeType>"
    When user make a update message put call
    Then user should receive the <statusCode>

    Examples:
      |sourcePayload|attributeType|statusCode|
      |messageUpdate.json| Valid  |200  |
      |messageUpdate.json| InValid  |400  |

  @CreateMessage
  Scenario: Verify the user is able to delete the message details by using the ID
    When user make a delete request to delete the message details by using id
    Then user should receive the <204>
