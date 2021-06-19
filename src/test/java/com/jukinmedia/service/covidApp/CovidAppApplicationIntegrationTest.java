package com.jukinmedia.service.covidApp;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jukinmedia.service.covidapp.entity.TotalCovidRecord;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CovidAppApplicationIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testCovidCountryService() throws JSONException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<TotalCovidRecord[]> response = testRestTemplate.exchange(
				createURLWithPort("/api/covid/totalRecords"), HttpMethod.GET, entity, TotalCovidRecord[].class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
