Feature: SearchProduct

Background: Steps common for all scenarios

Given User launch chrome browser
When User opens  URL "https://www.amazon.in/"
And User Clicks on Sign in
When User enters Email as "ssunilkumar619@gmail.com"
And User click on continue
When User enters Password as "Password@258"
And Click on Login
Then Page Title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"

@Regression
Scenario: Search product from dropdown

And Search Product "iphone"
And From suggestions click iphone 13
Then Page Title should be "Amazon.in : iphone 13"
When Click on Apple iPhone 13 (128GB) - Starlight and verify
And Click on Add to Cart
Then Added to cart box should appear
And Close browser

#Scenario : Search product ,apply filters and add to wish list
#
#And Search Product "one plus nord"
#And From suggestions click oneplus nord 2
#Then Page Title should be "Amazon.in : oneplus nord 2"
#When Select memory storage 256GB & above
#And RAM size 10Gb & above
#And Click on OnePlus Nord CE 3 5G (Aqua Surge, 12GB RAM, 256GB Storage) color grey
#And Click add to wishlist and Verify
#And Close browser



