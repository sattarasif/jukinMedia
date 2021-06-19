package com.jukinmedia.service.covidapp.exception;

public class CovidException extends RuntimeException{
	
	public CovidException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public CovidException(String exMessage) {
        super(exMessage);
    }

}
