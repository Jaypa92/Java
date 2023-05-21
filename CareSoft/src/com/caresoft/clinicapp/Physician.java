package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...
	public Physician(Integer id) {
		super(id);
	}
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
    
    public boolean assignPin(int pin) {
    	int length = String.valueOf(pin).length();
    	if(length < 4) {
    	return false;	
    	}
    	setPin(pin);
    	return true;
    }
    
    public boolean accessAuthorized(Integer id) {
    	Integer ID = getId();
    	if(id == ID) {
    		return true;
    	}
    	return false;
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters

}
