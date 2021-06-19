package com.jukinmedia.service.covidapp.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "TOTAL_COVID_RECORDS")
public class TotalCovidRecord implements Serializable{
	
	private static final long serialVersionUID = 6078583978182620441L;
	@Id
    @GeneratedValue
	private int id;
	private int confirmed;
	private int recovered;
	private int critical;
	private int deaths;
	private Date lastChange;
	private Date lastUpdate;

}
