=======
PURPOSE
=======
Sending JSON in request
Updating response header the way we want

Test cases also 

===========
REFERENCES
===========
Main
https://www.baeldung.com/spring-resttemplate-post-json


To set header in response
https://www.baeldung.com/spring-response-header 
https://stackoverflow.com/questions/29488956/simple-spring-boot-application-httpservletresponse-needed

To use RestTemplate (in test cases)
https://www.tutorialspoint.com/spring_boot/spring_boot_rest_template.htm

==============
RUN MANUALLY
==============

- CREATE
http://localhost:8080/persons/createPerson
With request 'body':
{"id":"2","name":"name2"}

Gives response body:
{
    "id": 2,
    "name": "name2"
}

Gives header:
connection →keep-alive
content-type →application/json
date →Fri, 08 Jan 2021 09:10:42 GMT
keep-alive →timeout=60
transfer-encoding →chunked


- UPDATE
http://localhost:8080/persons/updatePerson
With request 'body':
{"id":"2","name":"name2"}

Gives response:
{
    "id": 2,
    "name": "name2"
}

Gives response body:
{
    "id": 2,
    "name": "name2"
}

Gives header: (note that it has added an attribute called 'location'
connection →keep-alive
content-type →application/json
date →Fri, 08 Jan 2021 09:15:19 GMT
keep-alive →timeout=60
location →http://localhost:8080/findPerson/2
transfer-encoding →chunked