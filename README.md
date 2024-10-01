**Bill Generator **
 
# Description

This is the application to convert the bill in the specified currency(base currency) to the target currency using third-party integration api. This application internally integrates with  third-party api((https://open.er-api.com/v6/latest/{base_currency}?apikey=your-api-key) which convert base currency to target currency for 1 unit of base currency, accordingly all logics are implemented in the application to apply discounts. 
 
 
 # How to use this project
 To use the project, one has to clone the project from github repo on link (https://github.com/AcetoneSarthak/Bill-Generator) and run in on any server.

 # Steps to import from GiHhub
 
 Step 1: Copy the Repo Link
 Step 2: Open repo in Eclispse or any other IDE
 Open Eclipse and go to Window > Show views > Other > Git > Git Repositories
 Step 3: Clone the GitHub Repo
 Step 4: Configure GitHub Account after supplying username and password
 Step 5: Selet the Required Branch
 Step 6: Mention Final Directory
 
 
# How to test this project
 Here, user has to initate an http request either with postman or any other client application using url (http://<localhost>:8093/api/calculate)[Note localhost to be replaced by server host on which this service is running]
 

# Sample Request to use

 {
  "items" : [
{

"name" : "Television",
"category" : "Electronics",
"amount" : 500}],

  "userType" : "Employee",
  "tenureInYears" : 1,
  "originalCurrency" : "USD",
  "targetCurrency" : "INR"
}

# Configuration
your-api-key is one time generated key from third-party application which is already configured in application.properties file and accordingly it has to be configured for new users.
