package com.jukinmedia.service.covidapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jukinmedia.service.covidapp.dto.CovidCountryVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COVID_COUNTRY")
public class CovidCountry implements Serializable{

	   
		private static final long serialVersionUID = 3333937475294627688L;
		@Id
	    @GeneratedValue
	    private int id;
		public String country;
	    public String code;
	    public int confirmed;
	    public int recovered;
	    public int critical;
	    public int deaths;
	    public double latitude;
	    public double longitude;
	    public Date lastChange;
	    public Date lastUpdate;
}
