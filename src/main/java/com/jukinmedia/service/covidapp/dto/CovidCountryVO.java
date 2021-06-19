package com.jukinmedia.service.covidapp.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CovidCountryVO implements Serializable {

	private static final long serialVersionUID = -6042345826203404712L;
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
