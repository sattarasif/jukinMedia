package com.jukinmedia.service.covidapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jukinmedia.service.covidapp.entity.CovidCountry;
import com.jukinmedia.service.covidapp.entity.TotalCovidRecord;
import com.jukinmedia.service.covidapp.entity.WorldWiseCovidRecord;
import com.jukinmedia.service.covidapp.service.CovidCountryService;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/covid")
public class CovidController {
	
	@Autowired
    private CovidCountryService covidCountryService;
	
	private static final String DataNotFoundMsg = "Data not found";
	private static final String parsingErr = "Parsing format is not correct.";
	private static final String xml = "xml";
	private static final String json = "json";
	
	@GetMapping("/covidCountry/format/{format}/countryName/{countryName}")
	public ResponseEntity<Object> savecovidCountryByName(@PathVariable("format") String format,@PathVariable("countryName") String countryName) {
		
		if(!format.equalsIgnoreCase(xml) && !format.equalsIgnoreCase(json))
			 return new ResponseEntity<Object>(parsingErr, BAD_REQUEST);
		List<CovidCountry> list= covidCountryService.saveCovidCountry(format,countryName, false);
		if(!list.isEmpty())
			return new ResponseEntity<Object>(list, OK);
		else
			return new ResponseEntity<Object>(DataNotFoundMsg+" for country name "+countryName, NOT_FOUND);
	}

	@GetMapping("/covidCountry/format/{format}/countryCode/{countryCode}")
	public ResponseEntity<Object> savecovidCountryByCode(@PathVariable("format") String format,@PathVariable("countryCode") String countryCode) {
		
		if(!format.equalsIgnoreCase(xml) && !format.equalsIgnoreCase(json))
			 return new ResponseEntity<Object>(parsingErr, BAD_REQUEST);
		List<CovidCountry> list= covidCountryService.saveCovidCountry(format,countryCode, true);
		if(!list.isEmpty())
			return new ResponseEntity<Object>(list, OK);
		else
			return new ResponseEntity<Object>(DataNotFoundMsg+" for country code "+countryCode, NOT_FOUND);
	}
	
	@GetMapping("/totalRecords")
	public ResponseEntity<Object> saveTotalCovidRecords() {
		
		List<TotalCovidRecord> list= covidCountryService.saveTotalCovidRecords();
		if(!list.isEmpty())
			return new ResponseEntity<Object>(list, OK);
		else
			return new ResponseEntity<Object>(DataNotFoundMsg, NOT_FOUND);
	}
	
	@GetMapping("/listOfCovidRecords")
	public ResponseEntity<Object> saveListOfCovidRecords() {
		
		List<WorldWiseCovidRecord> list= covidCountryService.saveListOfCovidRecords();
		if(!list.isEmpty())
			return new ResponseEntity<Object>(list, OK);
		else
			return new ResponseEntity<Object>(DataNotFoundMsg, NOT_FOUND);
	}
}
