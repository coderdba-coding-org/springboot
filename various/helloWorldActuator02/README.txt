Based on https://spring.io/guides/gs/actuator-service/

NOTE: @ResponseBody with @Controller 
- or - @RestController makes it serve a response-body and not a web UI output like html

=============================================
@ResponseBody and automatic JSON Marshalling
=============================================
The @ResponseBody annotation tells Spring MVC not to render a model into a view but, 
rather, to write the returned object into the response body. 
It does so by using one of Spring’s message converters. Because Jackson 2 is in the classpath, 
MappingJackson2HttpMessageConverter will handle the conversion of a Greeting object to JSON 
if the request’s Accept header specifies that JSON should be returned.