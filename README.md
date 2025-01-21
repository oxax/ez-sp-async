# ezbob-sb-test
## Overview


ezbob-sb-test

 is a Spring Boot project with two modules: 

service-log

 and 

service-shuffle

. The 

service-log

 module handles logging, while the 

service-shuffle

 module provides an API to shuffle numbers.

## Modules
- **service-log**: Provides logging services.
- **service-shuffle**: Offers an API to shuffle numbers.

## Prerequisites
- Java 17
- Maven

## Setup

1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd ezbob-sb-test
   ```

2. Build the project:
   ```sh
   mvn clean install
   ```

3. Run the 

service-shuffle

 module:
   ```sh
   cd service-shuffle
   mvn spring-boot:run
   ```

## API Endpoints

### Shuffle Number
- **URL**: `/api/shuffle`
- **Method**: `POST`
- **Request Param**: 

number

 (int)
- **Response**: Shuffled array of numbers

## Configuration
- **service-shuffle/src/main/resources/application.properties**:
  ```properties
  service.log.url=http://localhost:8081/api/log
  ```

## License
This project is licensed under the MIT License.
