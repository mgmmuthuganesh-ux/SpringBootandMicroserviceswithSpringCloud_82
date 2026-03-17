# SpringBootandMicroserviceswithSpringCloud_82

# Request Body
```
{
    "name": "vivek",
    "email": "vivek@gmail.com",
    "address": {
        "city": "hyd",
        "state": "TG",
        "zip": 123
    },
    "hobbies": [
        {
            "name": "cricket",
            "type": "outdoor"
        },
        {
            "name": "reading",
            "type": "indoor"
        }
    ],
    "cources": [
        {
            "name": "java"
        },
        {
            "name": "python"
        },
        {
            "name": "devops"
        }
    ]
}
```
# Swagger Url

UI : http://localhost:8080/swagger-ui.html (gives swagger UI)

api : http://localhost:8080/v3/api-docs (gives in json)

# Zipkin Download (zipkin-server-X.X.X-exec.jar  )
https://repo1.maven.org/maven2/io/zipkin/zipkin-server/3.5.1/

# KEYCLOAK CONFIGURATION
- Download KEYCLOAK and extract from https://www.keycloak.org/downloads .
- Go to bin folder and run `kc.bat start-dev`
- By default KEYCLOAK run on 8080 if you want to change port `kc.bat start-dev --http-port=<portnumber>`
- Access KEYCLOAK from your browser http://localhost:8080 for the first time it will ask to set admin user and password.
- Then login to admin console
![KEYCLOAK ADMIN ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/keycloakadmin.PNG)
1. Create a New Realm
![Realm ADMIN ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/realm.PNG)
2. Create a New Client
	- Enter the Client ID, then click Next.
	- In the Third/Last Tab:
	- Set the Root URL to your Spring Boot application's URL (e.g., http://localhost:9090).
	- Set the Valid Redirect URIs to your application's URL with a wildcard (e.g., http://localhost:9090/*).
	- Click Save.
	- Now, select the Client ID you just created.
	- Go to the Roles tab, create roles, and save them.
3. Create a User
	- Go to the Users tab.
	- Click Create User.
	- Username and Email are mandatory fields.
	- After creating the user, select it and go to the Credentials tab.
	- Set a password and uncheck the Temporary checkbox.
4. Map User to Roles
	- Go to the Role Mapping tab.
	- Click Assign Role.
	- In Filter by Client, search for the roles you created for the client and assign them.
5. Retrieve Keycloak Endpoints
	- To find issue-related details or endpoints:

	- Go to Realm Settings (bottom-right corner).
	- Click OpenID Endpoint Configuration to view all available endpoints, such as:

 ``
 {
  "issuer": "http://localhost:8080/realms/master",
  "authorization_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/auth",
  "token_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/token",
  "introspection_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/token/introspect",
  "userinfo_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/userinfo",
  "end_session_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/logout"
} 
``
# Trouble Shooting
If you get some error like

`` 
{
    "error": "invalid_grant",
    "error_description": "Account is not fully set up"
}
``

Check the credentials. If still the error persists then follow below steps:
- From the left sidebar, select the Users menu. In the Details tab, fill in the following fields:
	- Email
	- Switch Email verified control to On
- From left sidebar select Authentication menu and in Required actions tab Disable these actions:
	- Verify Profile
	- Update Profile
	- Verify Email

![KEYCLOAK troublShoot ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/keycloaktroubleshoot.jpg)

* Error like

``
{
    "error": "unauthorized_client",
    "error_description": "Client not allowed for direct access grants"
}
``

Then go to client settings check the checkbox Direct access grants at Capability config
![KEYCLOAK troublShoot ](https://github.com/HarshaPrimeTrainings/SpringBootandMicroserviceswithSpringCloud_82/blob/main/directaccess.PNG)

# Token Generation With KEYCLOAK
![KEYCLOAK Token Generation ](https://github.com/HarshaPrimeTrainings/64_spring_boot_microservice_cloud_security/blob/main/keycloaktoken.JPG)
# Testing API with KEYCLOAK Token
- User ACCESS
![KEYCLOAK Token Testing ](https://github.com/HarshaPrimeTrainings/79_springbootandmicroservices/blob/main/useracces.PNG)

- Admin ACCESS
![KEYCLOAK Token Testing ](https://github.com/HarshaPrimeTrainings/79_springbootandmicroservices/blob/main/adminacces.PNG)

# DOCKER
- Example Dockerfile
```
FROM openjdk:17-jdk-alpine
ADD target/app1.jar app1.jar
ENTRYPOINT [ "java","-jar","app1.jar" ]
EXPOSE 8080
```
- Image Build
`docker build -f Dockerfile -t mydemoimage .` ("." is current location)
- Running Image
`docker run -p 7070:7070 mydemoimage`

# Running Docker application by using docker-compose
- Example docker-compose.yml
```
version: "3"
services:
  springapp1:
    image: app1image
    build:
      context: ./
      dockerfile: Dockerfile
    ports:
      - 8080:8080
  springapp2:
    image: app2image
    build:
      context: ./../springdockerdemoapp/
      dockerfile: Dockerfile
    ports:
      - 7070:7070
```

# Trouble Shooting Docker & MySql

- Here application running in container and Mysql Running in Local Machine.
- A very common Docker networking issue. Inside a container, localhost refers to the container itself, not your host machine. So when your Spring Boot app tries to connect to localhost:3306 it looks for MySQL inside the container, not on your local machine.
# Recomended Solution 
Docker provides a special hostname to access the host machine from inside containers i.e `host.docker.internal`
```
spring.datasource.url=jdbc:mysql://host.docker.internal:3306/your_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```
- If still unable to connect then 
# Verify MySQL Allows External Connections ?

This query gives allowed hosts.
```
SELECT host,user FROM mysql.user;
```

# Allow MySQL Connections from Docker
- Open MySQL Workbench
- Go to Server → Users and Privileges
- Click Add Account
- Fill:
```
Login Name: root
Limit to Hosts Matching: %
Password: yourpassword
```
- Go to Administrative Roles
- Select DBA or All Privileges
- Click Apply
