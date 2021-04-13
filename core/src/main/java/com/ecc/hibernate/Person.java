package com.ecc.hibernate;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import javax.persistence.*;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Column;
// import javax.persistence.Table;
// import javax.persistence.ManyToMany;

@Entity
@Table(name="hibernate_exercise.person")
public class Person{
    @Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride( name = "lname", column = @Column(name = "lname")),
		@AttributeOverride( name = "fname", column = @Column(name = "fname")),
		@AttributeOverride( name = "mname", column = @Column(name = "mname")),
		@AttributeOverride( name = "suffix", column = @Column(name = "suffix")),
		@AttributeOverride( name = "title", column = @Column(name = "title"))
	})
	private PersonName name;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride( name = "landline", column = @Column(name = "landline")),
		@AttributeOverride( name = "mnumber", column = @Column(name = "mobilenumber")),
		@AttributeOverride( name = "email", column = @Column(name = "email"))
	})
	private PersonContactInformation contact;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride( name = "street", column = @Column(name = "streetnumber")),
		@AttributeOverride( name = "barangay", column = @Column(name = "barangay")),
		@AttributeOverride( name = "municipality", column = @Column(name = "municipality")),
		@AttributeOverride( name = "zipcode", column = @Column(name = "zipcode"))
	})
	private PersonAddress address;

	@Column(name="birthday")
    private String bday;
	@Column(name="gwa")
    private String gwa;
	@Column(name="datehired")
    private String dateHired;
	@Column(name="currentlyemployed")
    private String employed;
	
	@ManyToMany
	@JoinTable(
		name = "hibernate_exercise.person_role", 
		joinColumns = {@JoinColumn(name = "pid")},
		inverseJoinColumns = {@JoinColumn(name = "rid")})
	private List<Roles> roles;

	public Person(){};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersonName getName() {
		return name;
	}

	public void setName(PersonName name) {
		this.name = name;
	}

	public PersonContactInformation getContact() {
		return contact;
	}

	public void setContact(PersonContactInformation contact) {
		this.contact = contact;
	}

	public PersonAddress getAddress() {
		return address;
	}

	public void setAddress(PersonAddress address) {
		this.address = address;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getGwa() {
		return gwa;
	}

	public void setGwa(String gwa) {
		this.gwa = gwa;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	public String getEmployed() {
		return employed;
	}

	public void setEmployed(String employed) {
		this.employed = employed;
	}

	public List<Roles> getRole() {
		return roles;
	}
	public void setRole(List<Roles> roles) {
		this.roles = roles;
	}
	
	public void addRole(Roles role) {
		if(roles == null) {
			roles = new ArrayList<>();
		}
		
		roles.add(role);
	}

	public static Comparator<Person> personNameComparator = new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
		   String personName1 = p1.getName().getLname().toUpperCase();
		   String personName2 = p2.getName().getLname().toUpperCase();
	
		   //ascending order
		   //return personName1.compareTo(personName2);
	
		   //descending order
		   return personName2.compareTo(personName1);
		}};

	public static Comparator<Person> personGWAComparator = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
			   String personGWA1 = p1.getGwa();
			   String personGWA2 = p2.getGwa();
		
			   //ascending order
			   //return personGWA1.compareTo(personGWA2);
		
			   //descending order
			   return personGWA2.compareTo(personGWA1);
			}};
	public static Comparator<Person> personDateHiredComparator = new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
			String personDateHired1 = p1.getDateHired();
			String personDateHired2 = p2.getDateHired();
	
			//ascending order
			//return personGWA1.compareTo(personGWA2);
	
			//descending order
			return personDateHired2.compareTo(personDateHired1);
		}};

	@Override
	public String toString() {
		return "Person [ID=" + id + ", NAME=(" + name + "), ADDRESS=(" + address + "), CONTACT=(" + contact + "), BDAY="
				 + bday + ", GWA=" + gwa + ", DATEHIRED=" + dateHired + ", EMPLOYED=" + employed + ", ROLES=("+ roles +")]";
	}
}