package com.jukinmedia.service.covidapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WORLD_WISE_COVID_RECORD")
public class WorldWiseCovidRecord implements Serializable {
	
	private static final long serialVersionUID = -3007897033317844102L;
	@Id
    @GeneratedValue
	private int id;
	private String name;
	private String alpha2code;
	private String alpha3code;
	private double latitude;
	private double longitude;

}
