## Native Query Demo
### Requirments
 * IntelliJIDEA
 * Serverport: 8080 (use: localhost:8080)
 * Java version: 17
 * MySql Databse
 * Everything is present in the pom.xml (no need to download any library)
 ### Steps to run program
 * Download the source code and import in intellijIDEA.
 * Go to localhost:8080/ 
 * Type endpoints in url or
 * You Can also Use Swagger 
 
### The Student will have the following attribute -
 * Id
 * Firstname
 * Latsname
 * age
 * Admission Date(Timestamp)
 * Active(true/false)
 
### Endpoints are -
 
     Post - /save/student
     Get  - /student/(nullable firstname i.e. : if we send the first name in the request param then we will get the details of that student otherwise will get all active student details )
     Delete-/delete-id/{id}
### Note
* You can change server port by setting properties in application.properties file i.e.

        server.port=8081
 
 


   
     
 
 

