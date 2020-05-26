This ReadMe.txt has instructions to run the back-end spring-boot application and the front-end angular 9 application

1. Spring-boot Application	

	1.1 In application.properties congifure the mongoDB configuration (as I wasn't able to get the environment variables to work),
			example:
				spring.data.mongodb.host=localhost
				spring.data.mongodb.port=27017
				spring.data.mongodb.database=project
		
	1.2 I have not included the dist file in the static folder of spring-boot app as I wasn't able to get ViewModel to work
	
2. Angular Application

	2.1 In angular application (as I wan't able to configure the ViewModel) in order to run application properly and send API requests to the server navigate to:
		
			frontend\src\app\shared\api\api.service.ts
		
		inside api.service.ts (ApiService service) set value of private varibale 'baseURL' to server's base URL.
		
		NOTE: by default 'baseURL' is set to an empty string
		
	2.2 Use 'npm install' command to install all packages in node_modules folder required by the project as the submitted folder doesn't have these packages. 
		NOTE: node_modules folder contains all the required libraries and dependencies for the angular project, which results in a large file size.
			Thus, they are not included in this zip file.

3. Issues and incomplete features:
	3.1 Angular Session Management
	3.2 SpringSecurity
	3.3 Material UI


