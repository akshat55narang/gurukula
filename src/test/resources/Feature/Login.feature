Feature: Login 

#Background: User Login
#Given User opens Application in Browser
#And ser enters valid username and password

@Login
Scenario Outline: Verify whether user is able to login with Valid Username and Password
Given User opens Application in Browser
And User clicks on Login Button
When User enters valid "<username>" and "<password>"
Then User should be able to Login
Examples:
          | username  | password  |
          | admin     | admin     |

@InvalidLogin     
Scenario Outline:: Verify whether user is able to login with Invalid Username or Password
Given User opens Application in Browser
And User clicks on Login Button
When User enters invalid "<username>" or invalid "<password>"
Then User should not be able to Login 
Examples:
		| username  | password  |
        | invaliduser     | admin     |
        | admin     | invalidpassword     | 

@Logout
Scenario: Verify whether user is able to logout of the application 
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
		| username  | password  |
        | admin     | admin     |   
And User is able to login to the Application  
When User opens Account Menu
And User clicks on logout button
Then User should be able to logout of the application

@Entitylist
Scenario: Verify whether user is able to view Branch and Staff in the Entities Menu
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
		| username  | password  |
        | admin     | admin     | 
And User is able to login to the Application 
When User clicks on Entities Menu 
Then User should be able to view Branch and Staff values in the Entity list

@CreateStaff
Scenario: Verify whether user is able to create new staff entry 
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
		| username  | password  |
        | admin     | admin     | 
And User is able to login to the Application 
And User opens Entities Menu
And User selects Staffs Menu
When User creates a new staff entry 
Then User should be able to see the created entry in the Staff list

Scenario: Verify whether user is able to view Branches list from the Entities Menu
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
And User enters valid credentials
		| username  | password  |
        | admin     | admin     | 
And User is able to login to the Application 
When User clicks on Entities Menu 
And User clicks on Branches Menu
Then User should be able to see a list of all the Branches

Scenario: Verify whether user is able to view Staffs list from the Entities Menu
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
When User clicks on Entities Menu 
And User clicks on Staffs Menu
Then User should be able to see a list of all the staff information

Scenario: Verify whether user is able to edit the logged in account information 
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
When User opens Settings from Account menu
Then User should be able to edit the logged in account information













