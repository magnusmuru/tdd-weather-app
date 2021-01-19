# Testing Course Project

## Project author
- Magnus Muru

## Used tech stack
 - Java
    - Spring boot
    - Junit
    - Jackson
    - Lombok
    - AssertJ
 - Gradle
 
# Providing input for the application

All input should be put in the file called `input.txt` which is located inside the root directory folder called `input`
Application supports only `.txt` file extension inputs.

Provide city names in the following format:
1) Each city name needs to be on its own line
2) Use spaces to separate cities with names that have multiple words eg `Buenos Aires` or `New York`

Example:
```
New York
Tallinn
Moscow
Lissabon
```

Every city that has a valid name will have its report generated in the same folder following naming pattern `{city_name}.json`

# Running the application on CLI

### To run the application
In the **root** directory run the following command
```
./gradlew bootRun
```
This will run the application and generate reports on Cities that are currently in your `/input/input.txt`

### To run the application tests
In the **root** directory run the following command
```
./gradlew test
```
This will run the application tests and generate some new weather reports in the input folder so make sure to move any reports you wish to save outside of the folder.