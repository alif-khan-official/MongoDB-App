# Run a Spring Boot Application in a Container establishing Network (using 'docker-compose') with a MongoDB Database running in another Container

## Run MongoDB Database in Docker Container

### Pull MongoDB (latest) Image
`docker pull mongo`

### Run Database in Container  
`docker run -d  --name mongodb  -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo`

## Docker Compose

### Establish Network between MongoDB Container and Application Container
Create __docker-compose.yml__ File in Project Root Directory

    version: '3'
    services:
        application:
            image: mongo-app
            environment: 
                - MONGODB_CONNSTRING=mongodb://mongoadmin:secret@localhost
            ports:
                - 8080:8080
            links:
                - mongodb
            depends_on:
                - mongodb  
        mongodb:
            image: mongo
            environment:
                - MONGO_INITDB_ROOT_USERNAME=mongoadmin
                - MONGO_INITDB_ROOT_PASSWORD=secret  
        ports:
            - 27017:27017        

### Update __application.properties__ File according to the __docker-compose.yml__ File   

    spring.data.mongodb.authentication-database=admin
    spring.data.mongodb.host=mongodb
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=mongo
    spring.data.mongodb.username=mongoadmin
    spring.data.mongodb.password=secret
    
### Build Application  

MacOS/Linux:  
`./mvnw spring-boot:run`.    

Windows:  
`mvnw spring-boot:run`     

## Using Swagger to Create API Documentations
Including Swagger Maven dependencies in _pom.xml_

    <dependency>
    	<groupId>io.springfox</groupId>
    	<artifactId>springfox-swagger2</artifactId>
    	<version>3.0.0</version>
	</dependency>

    <dependency>
    	<groupId>io.springfox</groupId>
    	<artifactId>springfox-boot-starter</artifactId>
    	<version>3.0.0</version>
	</dependency>
	
	<dependency>
    	<groupId>io.springfox</groupId>
    	<artifactId>springfox-swagger-ui</artifactId>
    	<version>2.9.2</version>
	</dependency>
	
### Integrating Swagger 2 Into the Project

    @Configuration
        public class SpringFoxConfig {                                    
        @Bean
        public Docket api() { 
            return new Docket(DocumentationType.SWAGGER_2)  
            .select()                                  
            .apis(RequestHandlerSelectors.any())              
            .paths(PathSelectors.any())                          
            .build();                                           
        }
    }
    
### Swagger Verification
`http://localhost:8080/v3/api-docs`

### Swagger UI
`http://localhost:8080/swagger-ui/`

## Run Application in Docker Container

### Run both the MongoDB Container and Application Container establishing Network between them
`docker-compose up -d`

### Test Application
Use the APIs from Swagger UI to Test the Application

## Access Containarized MongoDB Database using

### Connecting through 'localhost' using 'MongoDB Compass'
`mongodb://mongoadmin:secret@localhost:27017/?authSource=admin`

### Verify Database
Navigate through the Collections & Documents of the 'mongo' Database to Verify it
