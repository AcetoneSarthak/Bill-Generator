This is a Bill Generator project which used Java and SpringBoot as backend framework.
Here user has to initate an http request either with postman or any other client application using url as (http://<host>:8093/api/calculate).
Purpose of this application is to convert the bill in the specified currency from the base currency using third-party integration api using url (https://open.er-api.com/v6/latest/{base_currency}?apikey=your-api-key) 
[Note: base_currency is to be supplied in the request and your-api-key is generated from third-party application and is configured in application.properties]]
third-party api convert base currency to target currency for 1 unit of base currency, accordingly all logics are implemented in the application to apply discounts.
