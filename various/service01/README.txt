References: 
-  Main: https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm

NOTE: If you create more than one class with @Service, but using the same interface implemented
      Then, you wlll get error like the following below.
      
      To fix:
      Option1: Add @Primary in the class that must be used primariluy when multiple exist 
      Option2: Add @Qualifier in the class (like Controller) where the ProductService interface is autowired
      			Note that Qualifier overrides Primary
      
2020-12-29 15:50:21.015 ERROR 89845 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Field productService in com.gm.service.Controller required a single bean, but 2 were found:
	- productServiceImpl: defined in file [/Users/dbgsm0/stuff/mystuff/coderdba-coding-org/springboot/various/service01/bin/main/com/gm/service/ProductServiceImpl.class]
	- productServiceImpl2: defined in file [/Users/dbgsm0/stuff/mystuff/coderdba-coding-org/springboot/various/service01/bin/main/com/gm/service/ProductServiceImpl2.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
      