@Marketing
Feature: Vtiger Marketing Accounts Functionality.

  Background: 
    #Given user is already logged vtiger application with userName as admin and password as admin
    When user performed mouse over on marketing module link and click on accounts sub module link

  @Smoke @Retesting
  Scenario: TS001 - Verify That User Is Able To Create Marketing Accounts Or Not
    Then user should be navigate marketing accounts landing page
    When user click on create new account option
    And enter all information  like unique accounts as vtiger , firtsName lastName etc and click on save button
    Then user accounts Should Be created with valid information
    #And browser is closed

  @Retesting
  Scenario: TS002 -  Verify That User Is Able To Delete Marketing Accounts Or Not
    And user search accounts by  accounts name as vtiger and click on delete button
    Then user accounts should be deleted by accepting popup
    #And browser is closed
  
  
  
  
  #Scenario: TS001 - Verify That User Is Able To Create Marketing Accounts Or Not
    #Given user is already logged vtiger application with userName as admin and password as admin
    #When user performed mouse over on marketing module link and click on accounts sub module link
    #Then user should be navigate marketing accounts landing page
    #When user click on create new account option
    #And enter all information  like unique accounts as Abhi , firtsName lastName etc and click on save button
    #Then user accounts Should Be created with valid information
#
  #Scenario: TS002 -  Verify That User Is Able To Delete Marketing Accounts Or Not
    #Given user is already logged vtiger application with userName as admin and password as admin
    #When user performed mouse over on marketing module link and click on accounts sub module link
    #And user search accounts by  accounts name as "Abhi" and click on delete button
    #Then user accounts should be deleted by accepting popup
