package com.ecc.hibernate;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="hibernate_exercise.roles")
public class Roles{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rid")
	private int rid;

	@Column(name="roles")
	private String role;

	@ManyToMany
	@JoinTable(
		name = "hibernate_exercise.person_role", 
		joinColumns = @JoinColumn(name = "rid"),
		inverseJoinColumns = @JoinColumn(name = "pid"))
	private List<Person> persons;

	public Roles(){};

	public Roles(int rid, String role){
		this.rid=rid;
		this.role=role;

	}

	public void setRid(int id){this.rid = id;}

	public void setRole(String role){this.role=role;}

	public int getRid(){return this.rid;}

	public String getRole(){return this.role;}

	public void addPerson(Person person){
		if(persons == null){
			persons = new ArrayList<>();
		}
		persons.add(person);
	}

	public List<Person> getPerson(){return this.persons;}
	public void setPerson(List<Person> persons){ this.persons = persons;}

	@Override
	public String toString() {
		return "ROLE - (RID=" + rid + ", ROLE=" + role + ")";
	}
}