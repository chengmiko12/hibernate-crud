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
public class PersonName{
  
    private String lname;
    private String fname;
    private String mname;
    private String suffix;
    private String title;

	public PersonName(){};

	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "PersonName [LASTNAME=" + lname + ", FIRSTNAME=" + fname + 
			", MIDNAME=" + mname + ", SUFFIX=" + suffix +", TITLE=" + title + "]";
	}
}