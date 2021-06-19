package com.jukinmedia.service.covidapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jukinmedia.service.covidapp.entity.TotalCovidRecord;

public interface TotalCovidRecordRepository extends JpaRepository<TotalCovidRecord, Integer>{

	Optional<TotalCovidRecord> findByid(int id);
}

