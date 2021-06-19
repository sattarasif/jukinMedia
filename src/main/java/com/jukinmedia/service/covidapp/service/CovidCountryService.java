package com.jukinmedia.service.covidapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jukinmedia.service.covidapp.entity.CovidCountry;
import com.jukinmedia.service.covidapp.entity.TotalCovidRecord;
import com.jukinmedia.service.covidapp.entity.WorldWiseCovidRecord;
import com.jukinmedia.service.covidapp.exception.CovidException;
import com.jukinmedia.service.covidapp.repository.CovidCountryRepository;
import com.jukinmedia.service.covidapp.repository.TotalCovidRecordRepository;
import com.jukinmedia.service.covidapp.repository.WorldWiseCovidRecordRepository;


@Service
public class CovidCountryService {

	@Autowired
	private CovidCountryRepository covidCountryRepository;
	
	@Autowired
	private TotalCovidRecordRepository totalCovidRecordRepository;
	
	@Autowired
	private WorldWiseCovidRecordRepository worldWiseCovidRecordRepository;
	
	@Value("${get.covid.name.api.url}")
	private String covidCountryUrlByName;
	
	@Value("${get.covid.code.api.url}")
	private String covidCountryUrlByCode;
	
	@Value("${get.total.api.url}")
	private String covidTotalRecordUrl;
	
	@Value("${get.countries.api.url}")
	private String covidWorldWisedUrl;
	
	@Value("${api.key}")
	private String apiKey;
	
	private static final String CovidRapidApiKey = "X-RapidAPI-Key";
	
	
	public List<CovidCountry> saveCovidCountry(String format, String countryNameOrCode, boolean isCode) {
		
		CovidCountry[] covidCountry = getCovidDataByCountryNameOrCode(format,countryNameOrCode, isCode).getBody();
		List<CovidCountry> listOfCovidCountry = new ArrayList<CovidCountry>(Arrays.asList(covidCountry));
		return listOfCovidCountry.isEmpty() ? listOfCovidCountry : covidCountryRepository.saveAll(listOfCovidCountry);
	}
	
	private ResponseEntity<CovidCountry[]>  getCovidDataByCountryNameOrCode(String format, String countryNameOrCode, boolean isCode) {
		 
	    RestTemplate restTemplate = new RestTemplate();
	    xmlFormat(format, restTemplate);
	    HttpHeaders headers = getHeadersObj();
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("format", format);
	    params.put("name", countryNameOrCode);
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    if(isCode )
	    	return restTemplate.exchange(covidCountryUrlByCode,HttpMethod.GET,entity, CovidCountry[].class, params);
	    else
	    	return restTemplate.exchange(covidCountryUrlByName,HttpMethod.GET,entity, CovidCountry[].class, params);
		
	}

	private void xmlFormat(String format, RestTemplate restTemplate) {
		
		if(format.equalsIgnoreCase("xml")) {
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
			MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
			converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
			messageConverters.add(converter);  
		    restTemplate.setMessageConverters(messageConverters);
	    }
	}
	
	public CovidCountry getCovidCountryById (int id) {
		return covidCountryRepository.findById(id).orElseThrow(() ->new CovidException("Invalid id found for covid country - " + id));
	}
	
	public TotalCovidRecord getTotalRecordyById (int id) {
		return totalCovidRecordRepository.findById(id).orElseThrow(() ->new CovidException("Invalid id found for total record - " + id));
	}
	
	public WorldWiseCovidRecord getWorldWiseCovidRecordyById (int id) {
		return worldWiseCovidRecordRepository.findById(id).orElseThrow(() ->new CovidException("Invalid id for world wise covid record - " + id));
	}
	
	public List<TotalCovidRecord> saveTotalCovidRecords() {
		
		TotalCovidRecord[] totalCovidRecords = getTotalNoCovidRecords().getBody();
		List<TotalCovidRecord> listOfCovidCountry = new ArrayList<TotalCovidRecord>(Arrays.asList(totalCovidRecords));
		return listOfCovidCountry.isEmpty() ? listOfCovidCountry : totalCovidRecordRepository.saveAll(listOfCovidCountry);
	}

	private ResponseEntity<TotalCovidRecord[]> getTotalNoCovidRecords() {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = getHeadersObj();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(covidTotalRecordUrl, HttpMethod.GET, entity, TotalCovidRecord[].class);
	}

	public List<WorldWiseCovidRecord> saveListOfCovidRecords() {
		
		WorldWiseCovidRecord[] totalCovidRecords = getWorldWiseCovidRecords().getBody();
		List<WorldWiseCovidRecord> listOfCovidCountry = new ArrayList<WorldWiseCovidRecord>(Arrays.asList(totalCovidRecords));
		return listOfCovidCountry.isEmpty() ? listOfCovidCountry : worldWiseCovidRecordRepository.saveAll(listOfCovidCountry);
	}

	private ResponseEntity<WorldWiseCovidRecord[]> getWorldWiseCovidRecords() {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = getHeadersObj();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(covidWorldWisedUrl, HttpMethod.GET, entity, WorldWiseCovidRecord[].class);
		
	}

	private HttpHeaders getHeadersObj() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(CovidRapidApiKey, apiKey);
		return headers;
	}
}
