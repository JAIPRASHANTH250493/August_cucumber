Feature: Login page for admin-demo application

@Login
Scenario: Loging into the admin-demoapplication
Given User launching the chromedriver and enters the url
When user enters the emailid & password "admin@yourstore.com" & "admin"
Then User clicks on the Signinbutton
And User could see the loggedin page and checks the title 

@login,@datadriven
Scenario Outline: Loging into the admin-demoapplication
Given User launching the chromedriver and enters the url
When user enters the emailid & password "<email>" & "<pxd>"
Then User clicks on the Signinbutton
And User could see the loggedin page and checks the title

Examples:
| email | pwd |
	| JJIB  | KKNX |
	|  KAJJJD    | test456  |
| admin@yourstore.com| admin |