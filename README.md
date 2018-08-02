# A project for GraphQL Spring Boot Implementation

### Prerequisites

You should know Spring Boot, Data, MVC. You should be familiar with JSON, Java Reflection API. 

You should at least read some examples, guides about Spring Boot with GraphQL usage which I will
not talk about and there is no documentation in this project.(There are amazing guides about this though,
especially this one: https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot )

### Disclaimer 

This project is based on this: https://github.com/eh3rrera/graphql-java-spring-boot-example
### Start

There are many examples on the internet about GraphQL, but they all doing the same thing: Querying
 API from GraphiQL which is visualisation tool for GraphQL and it is good.
 
 
 But in real life you need also consume the API and it is little different from REST based APIs. You
 need to pass GraphQL based JSON to the endpoint of "/graphql"(it is default one and changeable).
 
 This project will help you how to create the API and consume it.
 
 ### Instructions 
 
 Just clone the project and run it. If you go to "localhost:8080" you will see a form and entering 
 random strings will trigger 3 different Author fields visibility, to be honest i just used this for
 testing.
 
 **The real GraphQL things happen in:**
 
        localhost:8080/checkbox
        
 Here you will see 3 different fields in Author class. There are checkboxes for which fields are you
 querying. Result screen shows only selected fields and they are class independent, so you can pass
 any POJO. This is happening thanks to Java Reflection API, at runtime it checks fields and
 dynamically creates fields and relative checkboxes.
 
 ### GraphQL plusses
 
 This way we can use advantages of GraphQL by only getting specific data from API provider. Classic
 REST based API's sends every data even if you were querying for only part of it.
 
 JSON based querying makes GraphQL special and improves services with lot less internet and
 computing usage.