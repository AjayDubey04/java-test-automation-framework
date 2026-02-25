@Home
Feature: Vtiger CRM Marketing Accounts Created Functionality.
 
  Scenario Outline: Verify That User Is Able To Create Vtiger Marketing Accounts Or Not By Multiple Data
    #Given user is already logged vtiger CRM application with userName as "<UserName>" and password as "<Password>"
    When user click on Vtiger marketing Accounts tabLink
    And user click on create new account buttonImg
    When enter all information accountName as "<AccountName>" website as "<Website>" ticker as <Ticker> phone as "<Phone>" fax as "<Fax>"  email as "<Email>" descreption as "<Descreption>"and click on save button
    Then user accounts Should Be created and browser is closed

    Examples: 
      | UserName | Password | AccountName | Website      | Ticker  |  Phone     | Fax       |   Email           |  Descreption                            |
      | admin    | admin    | Ram         | google.com   | Evs1    | 8735676786 | Hello Fax | rahul1@gmail.com  | Hi I Am Creating New Marketing Accounts |
      | admin    | admin    | shyam       | flipkart.com | Evs2    | 9835676786 | Hello Fax | Rakesh2@gmail.com | Hi I Am Creating New Marketing Accounts |
      | admin    | admin    | Radha       | amazon.com   | Evs2    | 7335676786 | Hello Fax | rajesh3@gmail.com | Hi I Am Creating New Marketing Accounts |

      
      
      
      
      
#Scenario Outline: TS001 - Verify That User Is Able To Create Vtiger Marketing Accounts Or Not
    #Given user is already logged vtiger application with userName as "<UserName>" and password as "<Password>"
    #When user click on Vtiger marketing Accounts link
    #And user click on create new account button
    #When enter all information and click on save button
    #| Rahul       | google.com   | Evs    | 8735676786 | Hii | rahul1@gmail.com  | Hi I Am Creating New Marketing Accounts |
    #| Rakesh      | flipkart.com | Evs    | 8735676786 | Hii | Rakesh2@gmail.com | Hi I Am Creating New Marketing Accounts |
    #| Rajesh      | amazon.com   | Evs    | 8735676786 | Hii | rajesh3@gmail.com | Hi I Am Creating New Marketing Accounts |
    #Then user accounts Should Be created
#
    #Examples: 
      #| UserName | Password |
      #| admin    | admin    | 
      #| admin    | admin    | 
      #| admin    | admin    |
      
      
      
      
      
 #Scenario Outline: TS001 - Verify That User Is Able To Create Vtiger Marketing Accounts Or Not
    #Given user is already logged vtiger application with userName and password 
    #| UserName | Password |
    #| admin    | admin    |
    #When user click on Vtiger marketing Accounts link
    #And user click on create new account button
    #When enter all information accountName as "<AccountName>" website as "<Website>" ticker as <Ticker> phone as "<Phone>" fax as "<Fax>"  email as "<Email>" descreption as "<Descreption>"and click on save button
    #Then user accounts Should Be created
#
    #Examples: 
      #| AccountName | Website      | Ticker |  Phone     | Fax |   Email           |  Descreption                            |
      #|  Rahul      | google.com   | Evs    | 8735676786 | Hii | rahul1@gmail.com  | Hi I Am Creating New Marketing Accounts |
      #| Rakesh      | flipkart.com | Evs    | 8735676786 | Hii | Rakesh2@gmail.com | Hi I Am Creating New Marketing Accounts |
      #| Rajesh      | amazon.com   | Evs    | 8735676786 | Hii | rajesh3@gmail.com | Hi I Am Creating New Marketing Accounts |
      #
      
     