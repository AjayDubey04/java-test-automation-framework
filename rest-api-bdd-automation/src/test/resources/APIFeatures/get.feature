Feature: Get All contact from Application

  Scenario: verify that user is able to get all list contact or not
    Given user is already entered url with endpoint and userName and passord
    When user perform get http requriest
    Then status code should be 200-ok


#Feature: User Management
#
  #Scenario: Retrieving User Information
    #Given a valid user ID
    #When the user sends a GET request to the endpoint /users/{id}
    #Then the response status code should be 200 (OK)
    #And the response body should contain the details of the user with ID {id}



#Feature: User Management
#
  #Scenario: Attempting to Retrieve Information for a Non-Existent User
    #Given an invalid user ID
    #When the user sends a GET request to the endpoint /users/{id}
    #Then the response status code should be 404 (Not Found)
    #And the response body should contain an error message indicating the user was not found

    
    