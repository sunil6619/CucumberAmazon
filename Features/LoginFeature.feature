Feature: Login
@Sanity
Scenario: Successful login with valid credentials
Given User launch chrome browser
When User opens  URL "https://www.amazon.in/"
And User Clicks on Sign in
Then User should get sign in box
When User enters Email as "ssunilkumar619@gmail.com"
And User click on continue
Then User should get box to enter password
When User enters Password as "Password@258"
And Click on Login
Then Page Title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
And Close browser
@Regression
Scenario Outline:Successful login with valid credentials Data Driven Testing
Given User launch chrome browser
When User opens  URL "https://www.amazon.in/"
And User Clicks on Sign in
Then User should get sign in box
When User enters Email as "<email>"
And User click on continue
Then User should get box to enter password
When User enters Password as "<password>"
And Click on Login
Then Page Title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
And Close browser

Examples:
|email|password|
|ssunilkumar619@gmail.com|Password@258|
|test@gmail.com|Password@258|
