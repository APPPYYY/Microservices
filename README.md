🌟 Microservices Project

This project demonstrates a comprehensive implementation of a microservices architecture using Spring Boot and various Spring Cloud components. It consists of six microservices:

1.UserService: Manages user-related operations.👤

2.HotelService: Manages hotel-related operations. 🏨

3.RatingService: Manages rating-related operations.⭐

4.ServiceRegistry: Eureka service registry for service discovery. 🔍

5.APIGateway: API Gateway using Spring Cloud Gateway. 🌐

6.ConfigServer: Centralized configuration server.⚙️

**Technologies Used**

1.Spring Boot: Framework for building Java applications. 🍃

2.Spring Cloud: For building microservices architecture.☁️

3.Eureka: Service registry and discovery. 🔎

4.Config Server: Centralized configuration management. 🗂️

5.Gateway: API Gateway for routing and filtering. 🚦

6.Spring AOP: Aspect-Oriented Programming for cross-cutting concerns.✂️

7.Spring Security: Securing microservices. 🔒

8.Resilience4j: Fault tolerance (circuit breaker, retry, rate limiting). 🛡️

9.JPA: Java Persistence API for ORM. 💾

10.Databases:

  a.MySQL: For UserService.
  
  b.PostgreSQL: For HotelService.
  
  c.MongoDB: For RatingService.
  
11.RestTemplate and FeignClient: For inter-service communication.

12.OKTA: Authentication and authorization.

13.Actuator: Monitoring and management of the application.

**Features**

1.Service Registry and Discovery: Implemented using Eureka server and client.

2.API Gateway: Using Spring Cloud Gateway for routing requests to appropriate services.

3.Configuration Management: Centralized configuration using Spring Cloud Config Server with configurations stored in GitHub.

4.Fault Tolerance: Circuit breaker, retry, and rate limiting using Resilience4j.

5.Security: Authentication and authorization using Spring Security and OKTA.

6.ORM: JPA for object-relational mapping.

7.Monitoring: Spring Boot Actuator for monitoring the health and metrics of microservices.

**Project Structure**

├── UserService 🧑‍💼
├── HotelService 🏨
├── RatingService ⭐
├── ServiceRegistry 🔍
├── APIGateway 🌐
└── ConfigServer ⚙️


**How to Run**

Prerequisites

1.Java 17 ☕

2.Maven 🛠️

3.MySQL, PostgreSQL, MongoDB 💾

4.Git 👨‍💻

5.OKTA account 🔐

**Steps**

1.Clone the Repository

git clone https://github.com/APPPYYY/Microservices.git

2.Setup Databases

MySQL: Create a database named microservices and configure UserService with the appropriate JDBC URL, username, and password.

PostgreSQL: Create a database named microservices and configure HotelService with the appropriate JDBC URL, username, and password.

MongoDB: Setup MongoDB and configure RatingService with the appropriate connection string.

3.Config Server

Update the application.properties of ConfigServer to point to your GitHub repository containing the configuration files.

4.Build and Run Services

**Start the services in the following order:**

1.ConfigServer⚙️

2.ServiceRegistry 🔍

3.APIGateway 🌐

4.UserService 👤

5.HotelService 🏨

6.RatingService⭐

**Access Services**

Service Registry: http://localhost:9000 🔍

API Gateway: http://localhost:9999 🌐

User Service: http://localhost:9091 👤

Hotel Service: http://localhost:9092 🏨

Rating Service: http://localhost:9093⭐

**Configuration Files**

Configuration files are stored in a separate GitHub repository and fetched by the ConfigServer at runtime. Ensure the spring.cloud.config.server.git.uri property in ConfigServer is pointing to your GitHub repository.

http://localhost:9094/application/prod

**Security**

Authentication and authorization are managed using OKTA. Update the application.properties in each service to include your OKTA client details.

**Monitoring**

Spring Boot Actuator is enabled for all services to provide endpoints for health, metrics, and other monitoring information.

**Contributing**

Contributions are welcome! Please fork the repository and submit pull requests.

**License**

This project is open-source.

**Contact**

For any inquiries or support, please contact comeflywithmes1999@gmail.com.
