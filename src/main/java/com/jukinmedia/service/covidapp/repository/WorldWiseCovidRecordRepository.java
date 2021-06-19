package com.jukinmedia.service.covidapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jukinmedia.service.covidapp.entity.WorldWiseCovidRecord;

public interface WorldWiseCovidRecordRepository extends JpaRepository<WorldWiseCovidRecord, Integer>{

	Optional<WorldWiseCovidRecord> findByid(int id);
}

