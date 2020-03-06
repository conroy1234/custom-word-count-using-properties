documentation link can be found at the following
http://localhost:8080/v2/api-docs

the above link can be copy and past into any api tool such as postman ind it will give all details about the api
the following url also can be use 
the doc url will return a json format that gives information about the app.

http://localhost:8080/swagger-ui.html
just copy the above and past it in a web browser after starting the application

agter running  http://localhost:8080/swagger-ui.html in your web browser click on hide/show to see the api(endpoints)

integration test can be found in the test packagea

to complete the task I have read the file and past the data to an object which is then store in an embedded h2 database. 

the rest api  -- flights/planner/find-by-departure-/{time} -- will select data via departureTime 
the time is the expression should be replace with a value from the table.

some example data I have fetch back using the complete path 

http://localhost:8080/flights/planner/find-by-departure-/09:00

this enpoint can be place in a web browser once the application is started.

some sample result frome the above query 

to find all data use endpoint --- http://localhost:8080/flights/planner/all-api

http://localhost:8080/flights/planner/find-by-departure-/09:00
{
    "departureTime": "09:00",
    "destination": "Tobago",
    "destinationAirportIATA": "TAB",
    "flightNo": "VS097",
    "sunday": "15:15",
    "monday": " ",
    "tuesday": " ",
    "wednesday": " ",
    "thursday": " ",
    "friday": " ",
    "saturday": "."
}

to start the application go to class --FlightPnannerApplication-- and run it as a spring oot application.
once it is start up you can access the data