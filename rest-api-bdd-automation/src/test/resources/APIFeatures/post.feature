@tag
Feature: Create User Management functionality

  @tag1
  Scenario: verify that user is able to create contact in api
    Given user is already logged in application with username and password
    And   user provide requriest payload info
    When  user perform post requriest with endpoint
    Then  user should get 200-ok status code from api
    And   user contact should be created
    
 
 
  
  #@tag2
  #Scenario Outline: verify that user is able to create contact in api
    #Given user is already logged in application with username as "<UserName>" and password as "<Password>"
    #And user provide requriest payload info with firstname as "<FirstName>" and lastname as "<LastName>" and email as "<Email>"
    #When user perform post requriest with endpoint
    #Then user should get 200-ok status code from api
    #And user contact should be created
#
    #Examples: 
      #|        UserName          | Password    | FirstName  | LastName |  Email              |
      #| createrajay229@btech.com | "<Ajay@66#>"| rahul sir  | Yadav    | rahul_sir@gimal.com | 
     
     
     

 #Scenario: Creating a New User Account
    #Given valid user data (name, email, password)
    #When the user sends a POST request to the endpoint /users with the data
    #Then the response status code should be 201 (Created)
    #And the response body should contain the ID of the newly created user
  
  
  
 #Scenario: Attempting to Create a User Account with Invalid Data
    #Given invalid user data (missing name)
    #When the user sends a POST request to the endpoint /users with the data
    #Then the response status code should be 400 (Bad Request)
    #And the response body should contain detailed error messages indicating the validation errors
    
    
