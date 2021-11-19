### P.P.S.Prasanthika
#### 18001254
#### SCS3203 / IS3108 Middleware Architecture
# Pet Store

## Build and deploy the API

Run the following commands and up the swagger and refer the End points

##### step one:
run the command on terminal

    ./gradlew build -Dquarkus.package.type=uber-jar

##### step two
run the command on terminal

    java -jar build/petStore-runner.jar

##### step three
to find the End-points on here

    http://localhost:8080/ http://localhost:8080/swagger-ui/

## Run Test Suite
run the command on terminal

    ./gradlew test

## CURL/WGET commands
    #Get all pets using CURL command
    curl -v http://localhost:8080/pets

### Pets
Get the all the pets

    curl -X GET "http://localhost:8080/pets" -H  "accept: application/json"

Create a new pet

    curl -X POST "http://localhost:8080/pets/add" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"petAge\":3,\"petName\":\"Charly\",\"petType\":\"Dog\"}"

Update an existing pet

    curl -X PUT "http://localhost:8080/pets/edit/2" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"petAge\":4,\"petName\":\"Nikky\",\"petType\":\"Dog\"}"

Delete an existing pet

    curl -X DELETE "http://localhost:8080/pets/delete/4" -H  "accept: */*"

Search pets with name/type/age

    curl -X GET "http://localhost:8080/pets/search?age=2&name=boola&type=Cat" -H  "accept: application/json"

Get pet by ID

    curl -X GET "http://localhost:8080/pets/2" -H  "accept: application/json"

### Pet Types

Get all pet types

    curl -X GET "http://localhost:8080/pettypes" -H  "accept: application/json"

Create a new pet type

    curl -X POST "http://localhost:8080/petTypes/add" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"petId\":4,\"petType\":\"lion\,\"petQuantity\":10\"}"

Update an existing pet type

    curl -X PUT "http://localhost:8080/petTypes/edit/1" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"petId\":1,\"petType\":\"dogs\",\"petQuantity\":10\"}"

Delete an existing  pet type

    curl -X DELETE "http://localhost:8080/petTypes/delete/1" -H  "accept: application/json"

#### Schemas
Pet Schema

    {
    "petAge": int,
    "petId": int,
    "petName": "string",
    "petType": "string" 
    }

PetType Schema

    {
    "petTypeId": int,
    "petType": "string",
    "petsQuantity": int
    }
