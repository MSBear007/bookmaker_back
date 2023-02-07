To run docker container:
1. run in command prompt
    ./mvn_clean
2. run then
    ./up
3. and after closing 
    ./down

To run in your environment put in file src/main/resources/application.properties your database connection parameters

add this lines to application.properties:
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always