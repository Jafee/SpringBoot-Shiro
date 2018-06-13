# Spring boot with Shiro [![License: GPL v3+](https://img.shields.io/badge/License-GPL%20v3%2B-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
The best practices of integrating Spring Boot with Apache Shiro

### Based on:
- Spring Boot
- Spring Web MVC
- Spring Data JPA ( Hibernate )
- Apache Shiro
- Thymeleaf 3
- Java 8
- Maven
- H2 Database

## Build and Run
1. Make sure JDK 8 and Maven are installed, and enter the root directory.
2. Build: `mvn clean package`
3. Run: `mvn spring-boot:run`
4. Visit the homepage: `http://localhost:8080`
5. By default, in-memory database is used and data is initialized. 

## Account Info
| Username | Password | Role  | Permission       |
|----------|----------|-------|------------------|
| admin    | 123456   | admin | `/` , `/manager` |
| User     | 123456   | user  | `/`              |


## License
[GPLv3+](LICENSE).