# Training version 2

## Endpoints

http://127.0.0.1:8080/persons/1 - returns the entity with primary key 1

http://127.0.0.1:8080/persons/color/blue - returns all people who selected blue color

http://127.0.0.1:8080/persons/color/blue1 - in case if there is a typo in the name of the color it throws ColorNotFoundException
