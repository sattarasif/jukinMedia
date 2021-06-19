package com.jukinmedia.service.covidapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jukinmedia.service.covidapp.entity.CovidCountry;

public interface CovidCountryRepository extends JpaRepository<CovidCountry, Integer>{

	Optional<CovidCountry> findByid(int id);
}
