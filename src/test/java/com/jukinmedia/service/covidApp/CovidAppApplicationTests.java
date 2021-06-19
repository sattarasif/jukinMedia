package com.jukinmedia.service.covidApp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jukinmedia.service.covidapp.entity.CovidCountry;
import com.jukinmedia.service.covidapp.entity.TotalCovidRecord;
import com.jukinmedia.service.covidapp.entity.WorldWiseCovidRecord;
import com.jukinmedia.service.covidapp.repository.CovidCountryRepository;
import com.jukinmedia.service.covidapp.repository.TotalCovidRecordRepository;
import com.jukinmedia.service.covidapp.repository.WorldWiseCovidRecordRepository;
import com.jukinmedia.service.covidapp.service.CovidCountryService;

@WebMvcTest
@RunWith(SpringRunner.class)
public class CovidAppApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private CovidCountryService covidCountryService;

	@MockBean
	private CovidCountryRepository covidCountryRepository;

	@MockBean
	private TotalCovidRecordRepository totalCovidRecordRepository;

	@MockBean
	private WorldWiseCovidRecordRepository worldWiseCovidRecordRepository;

	@Test
	public void testWorldWiseCovid() throws Exception {

		WorldWiseCovidRecord worldWiseCovidRecord = new WorldWiseCovidRecord(32, "abc", "ab", "tst", 3242423, 4534543);
		WorldWiseCovidRecord worldWiseCovidRecord1 = new WorldWiseCovidRecord(4, "india", "df", "rer", 324545423,
				45545);

		Mockito.when(worldWiseCovidRecordRepository.save(worldWiseCovidRecord)).thenReturn(worldWiseCovidRecord);
		assertEquals(worldWiseCovidRecord, worldWiseCovidRecordRepository.save(worldWiseCovidRecord));

		Mockito.when(worldWiseCovidRecordRepository.saveAll(Arrays.asList(worldWiseCovidRecord, worldWiseCovidRecord1)))
				.thenReturn(Arrays.asList(worldWiseCovidRecord, worldWiseCovidRecord1));
		assertEquals(Arrays.asList(worldWiseCovidRecord, worldWiseCovidRecord1),
				worldWiseCovidRecordRepository.saveAll(Arrays.asList(worldWiseCovidRecord, worldWiseCovidRecord1)));

	}

	@Test
	public void testTotalCovidCase() throws Exception {

		TotalCovidRecord totalCovidRecord = new TotalCovidRecord(23, 434, 556, 545, 232, new Date(), new Date());
		TotalCovidRecord totalCovidRecord1 = new TotalCovidRecord(345, 35, 435, 345, 345, new Date(), new Date());

		Mockito.when(totalCovidRecordRepository.save(totalCovidRecord)).thenReturn(totalCovidRecord);
		assertEquals(totalCovidRecord, totalCovidRecordRepository.save(totalCovidRecord));

		Mockito.when(totalCovidRecordRepository.saveAll(Arrays.asList(totalCovidRecord, totalCovidRecord1)))
				.thenReturn(Arrays.asList(totalCovidRecord, totalCovidRecord1));
		assertEquals(Arrays.asList(totalCovidRecord, totalCovidRecord1),
				totalCovidRecordRepository.saveAll(Arrays.asList(totalCovidRecord, totalCovidRecord1)));

	}

	@Test
	public void testCovidCountryWise() throws Exception {

		CovidCountry covidCountry = new CovidCountry(242, "India", "IND", 676, 54, 23, 232, 34443, 32423, new Date(),
				new Date());
		CovidCountry covidCountry1 = new CovidCountry(22, "USA", "US", 34, 46, 5, 678, 768, 32423, new Date(),
				new Date());

		Mockito.when(covidCountryRepository.save(covidCountry)).thenReturn(covidCountry);
		assertEquals(covidCountry, covidCountryRepository.save(covidCountry));

		Mockito.when(covidCountryRepository.saveAll(Arrays.asList(covidCountry, covidCountry1)))
				.thenReturn(Arrays.asList(covidCountry, covidCountry1));
		assertEquals(Arrays.asList(covidCountry, covidCountry1),
				covidCountryRepository.saveAll(Arrays.asList(covidCountry, covidCountry1)));

	}

}
