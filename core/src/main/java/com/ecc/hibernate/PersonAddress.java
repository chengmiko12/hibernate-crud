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
public class PersonAddress{
    
    private String street;
    private String barangay;
    private String municipality;
    private String zipcode;

	public PersonAddress(){};

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBarangay() {
		return barangay;
	}
	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Person [STREET=" + street + ", BARANGAY=" + barangay + ", MUNICIPALITY="
				+ municipality + ", ZIPCODE=" + zipcode + "]";
	}
}