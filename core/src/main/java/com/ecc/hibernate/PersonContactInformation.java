package com.ecc.hibernate;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Embeddable
public class PersonContactInformation{
    private String landline;
    private String mnumber;
    private String email;
    
    

	public PersonContactInformation(){};

	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getMnumber() {
		return mnumber;
	}
	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Person [LANDLINE=" + landline + ", MOBILE=" + mnumber + ", EMAIL=" + email + "]";
	}
}