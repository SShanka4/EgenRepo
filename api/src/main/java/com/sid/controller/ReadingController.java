package com.sid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.entity.Reading;
import com.sid.entity.Vehicle;
import com.sid.service.VehicleService;

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {
	
	@Autowired
    ReadingService readingService;

    

    @CrossOrigin(origins="http://mocker.egen.io",maxAge=5000)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Reading reading) {
    	return readingService.create(reading);
    }
}
