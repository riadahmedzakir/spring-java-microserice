# Learning the basics of java

The goal is to explore java and build a restful api with spring boot.

## What am I doing?

 - Create a eureka discovery service to automatically register multiple instance of a avaialbe service to be used on other micro-services.

 `*Note: With docker windows installed, app-settings need to specify the prefered hostman or clean up host entry for services to be asigned to localhost, or it will be hosted using a docker host address.`

 - Creating first microservice(identiy-service) with eureka discovery enabled delegating responsiblities of
   
    - Create new user (Registration)
    - User login
    - User details
    - User update
    - User delete
 
- Creating second microservice(uam-service) with eureka discovery enabled delegating responsiblities of

   - Password reset
   - Email verification

- Using spring could API gateway as a load balancer
- Using jwt token to authorize endpoints using gateway filters
- Creating a spring cloud config server to centralize configurations 