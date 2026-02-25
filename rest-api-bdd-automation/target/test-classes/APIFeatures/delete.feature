#Feature: User Management
#
  #Scenario: Deleting a User Account
    #Given a valid user ID
    #When the user sends a DELETE request to the endpoint /users/{id}
    #Then the response status code should be 204 (No Content)
    #And the user account with ID {id} should be deleted from the system
   
   
   
   
   
 #Feature: User Management
#
  #Scenario: Attempting to Delete a Non-Existent User Account
    #Given an invalid user ID
    #When the user sends a DELETE request to the endpoint /users/{id}
    #Then the response status code should be 404 (Not Found)
    #And the response body should contain an error message indicating the user was not found
    