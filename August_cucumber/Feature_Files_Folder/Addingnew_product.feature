Feature: Adding new product 
Scenario: adding newproduct feature
Given User launching the chromedriver and enters the url
When user enters the emailid & password "admin@yourstore.com" & "admin"
Then User clicks on the Signinbutton
And User could see the loggedin page and checks the title
Then User selects catalog from the list and clicks on the product button
And User clicks on the add new product button
Then User gives the product details and description ,product price and clicks on savebutton 
And User asserts now


