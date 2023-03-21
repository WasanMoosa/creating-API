package com.helloWordApp.helloWord.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;

@RestController // Indicates that this class is a REST controller
@RequestMapping("/v1/api") // Maps all requests with "/v1/api" prefix to this controller
public class MainController {
    @Operation(summary = "Just get a name",
            description = "Give you a name with Hello, the name can be passed as a query string")
    @GetMapping({"/hw", ""}) // Handles GET requests with "/v1/api/hw" or "/v1/api" endpoint
    // The GiveSentence method takes a query parameter called "myname" and returns a HashMap containing response data
    public HashMap<String, Object> GiveSentence(@RequestParam(value = "name", defaultValue = "Mr") String name) {

        // Creates a new HashMap to hold the response data
        HashMap<String, Object> response = new HashMap<>();

        // Creates a new HashMap to hold the response status data
        HashMap<String, String> status = new HashMap<>();
        try {

            // Gets a calendar instance representing the current date and time
            Calendar calendar = Calendar.getInstance();

            // Gets the current year and converts it to a String
            String year = String.valueOf(calendar.get(Calendar.YEAR));

            // Gets the current month and converts it to a String
            String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);

            // Gets the current day and converts it to a String
            String day = String.valueOf(calendar.get(Calendar.DATE));

            // Concatenates the day, month, and year to form a date string in dd/mm/yyyy format
            String date = day + "/" + month + "/" + year;

            // Adds the current date to the status HashMap
            status.put("date", date);

            // Adds a success status code to the status HashMap
            status.put("success", "200");

            // Adds the status HashMap to the response HashMap
            response.put("status", status);

            // Adds a "sentence" key with the value "Hello  and welcome name" to the response HashMap
            response.put("sentence", "Hello Word and welcome " + name + "!");

            // Adds a "name" key with the value of the "myname" query parameter to the response HashMap
            response.put("name", name);


        } catch (Exception e) {
            // Adds a failure status code to the status HashMap
            status.put("failure", "500");
            response.put("status", status);
        }
        // Returns the response HashMap
        return response;
    }

}
