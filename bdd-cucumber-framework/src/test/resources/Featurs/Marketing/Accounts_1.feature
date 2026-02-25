
Feature: Vtiger Marketing Accounts Created Functionality.

  Scenario: TS001 - Verify That User Is Able To Create Vtiger Marketing Accounts Or Not
    #Given user is already logged vtiger application with userName and password
      #| UserName | Password |
      #| admin    | admin    |
    When user click on Vtiger marketing Accounts link
    And user click on create new account button
    When enter all information and click on save button 
      | Rahul  | google.com   | Evs | 8735676786 | Hii | rahul1@gmail.com  | Hi I Am Creating New Marketing Accounts |
      | Rakesh | flipkart.com | Evs | 8735676786 | Hii | Rakesh2@gmail.com | Hi I Am Creating New Marketing Accounts |
      | Rajesh | amazon.com   | Evs | 8735676786 | Hii | rajesh3@gmail.com | Hi I Am Creating New Marketing Accounts |
    Then user accounts Should Be created 
