# Training version 2

## Endpoints
 
|  Endpoint	| HTTP Method |  Response	|  Exception |
|---	|---	|---	|---	| 
|  http://127.0.0.1:8080/persons/1 	|  GET |  returns the domain entity with primary key 1 	| If the id is null it throws IllegalArgumentException, if there is no such entity with given id it returns NoPersonFoundException   	|
|  http://127.0.0.1:8080/persons/color/blue |  GET |    returns all people who selected blue color  	|  in case of type on color name it throws ColorNotFoundException, in case there are no entities it throws NoPersonsFoundException   |
|   http://127.0.0.1:8080/persons	| GET  	| returns all domain entities  	| throws NoPersonsFoundException if there are no entities  	|
| http://127.0.0.1:8080/persons | POST | Initializes database from the broken CSV. |
