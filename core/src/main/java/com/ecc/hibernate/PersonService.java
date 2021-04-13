package com.ecc.hibernate;

import java.util.*;
import java.util.stream.*;
public class PersonService{

    private PersonDAO personDAO;

    public PersonService(){
        System.out.println(">>> INSIDE PersonService() [CONSTRUCTOR]...");
    }

    public void init(){
        System.out.println(">>> INSIDE PersonService().init()\n>>>INITIALIZING...");
        this.personDAO = new PersonDAO();
        this.personDAO.init();
    }

    public void createPerson(String fName,String mname,String lname,String suffix,String title,
                        String landline,String mnumber,String email,String street,String barangay,
                        String municipality,String zip,String bday,String gwa,String datehired,
                        String currentlyemployed,Roles role){
        
        System.out.println(">>> INSIDE PersonService().createPerson()...\n>>>CREATING PERSON...");
        Person person = new Person();
        PersonName personName = new PersonName();
        PersonAddress personAddress = new PersonAddress();
        PersonContactInformation pContactInformation = new PersonContactInformation();

        personName.setFname(fName);
        personName.setMname(mname);
        personName.setLname(lname);
        personName.setSuffix(suffix);
        personName.setTitle(title);

        personAddress.setBarangay(barangay);
        personAddress.setStreet(street);
        personAddress.setMunicipality(municipality);
        personAddress.setZipcode(zip);

        pContactInformation.setEmail(email);
        pContactInformation.setLandline(landline);
        pContactInformation.setMnumber(mnumber);

        person.setName(personName);
        person.setAddress(personAddress);
        person.setContact(pContactInformation);
        person.setBday(bday);
        person.setGwa(gwa);
        person.setEmployed(currentlyemployed);
        person.setDateHired(datehired);
        person.addRole(role);
        
        this.personDAO.createPerson(person);
    }

    public void updatePerson(int id,String fName,String mname,String lname,String suffix,String title,
                            String landline,String mnumber,String email,String street,String barangay,
                            String municipality,String zip,String bday,String gwa,String datehired,
                            String currentlyemployed){
        
        System.out.println(">>> INSIDE PersonService().updatePerson()...\n>>>UPDATING PERSON...");
        Person person = this.personDAO.getPerson(id);
        PersonName personName = new PersonName();
        PersonAddress personAddress = new PersonAddress();
        PersonContactInformation pContactInformation = new PersonContactInformation();

        personName.setFname(fName);
        personName.setMname(mname);
        personName.setLname(lname);
        personName.setSuffix(suffix);
        personName.setTitle(title);

        personAddress.setBarangay(barangay);
        personAddress.setStreet(street);
        personAddress.setMunicipality(municipality);
        personAddress.setZipcode(zip);

        pContactInformation.setEmail(email);
        pContactInformation.setLandline(landline);
        pContactInformation.setMnumber(mnumber);

        person.setName(personName);
        person.setAddress(personAddress);
        person.setContact(pContactInformation);
        person.setBday(bday);
        person.setGwa(gwa);
        person.setEmployed(currentlyemployed);
        person.setDateHired(datehired);
        
        this.personDAO.updatePerson(person);
    }

    public void updatePersonContact(int id, String landline, String mnumber, String email){
        Person person = this.personDAO.getPerson(id);
        PersonContactInformation pContactInformation = new PersonContactInformation();
        pContactInformation.setEmail(email);
        pContactInformation.setLandline(landline);
        pContactInformation.setMnumber(mnumber);
        person.setContact(pContactInformation);
    }
    public void updateRole(int id, String roleName){
        Roles role = this.personDAO.getRole(id);
        role.setRole(roleName);
        this.personDAO.updateRole(role);
    }

    public List<Person> getPersonList(){
        //this.personDAO.getPersonList();

        List<Person> pList = this.personDAO.getPersonList();

        for(int i = 0; i < this.personDAO.getPersonList().size(); i++){
            System.out.println(">>> PersonService() - " + pList.get(i));
        }

        return pList;

    }

    public void createRole(String roleName){
        Roles role = new Roles();
        role.setRole(roleName);
        this.personDAO.createRole(role);
    }

    public List<Roles> getRoleList(){
        List<Roles> rList = this.personDAO.getRoleList();
        return rList;
    }   

    public void listGWA(){
        List<Person> pList = this.personDAO.getPersonList();
        //Collections.sort(pList, Person.personGWAComparator);

        List<Person> sortedUsers = pList.stream()
                .sorted(Comparator.comparing(Person::getGwa))
                .collect(Collectors.toList());
                
        for(Person person: sortedUsers){
			System.out.println(person);
	    }
    }


    public void listDateHired(){
        List<Person> pList = this.personDAO.getPersonList();
        Collections.sort(pList, Person.personDateHiredComparator);

        for(Person person: pList){
			System.out.println(person);
	    }
    }
    public void listLastName(){
        List<Person> pList = this.personDAO.getPersonList();
        Collections.sort(pList, Person.personNameComparator);

        for(Person person: pList){
			System.out.println(person);
	    }
    }

    public void addRoleToPerson(int pid, int rid){
        Person person = this.personDAO.getPerson(pid);
        Roles role = this.personDAO.getRole(rid);

        person.addRole(role);
        this.personDAO.updatePerson(person);
    }

    public void deletePerson(int id){
        this.personDAO.deletePerson(id);
    }
    public void deleteRole(int id){
        this.personDAO.deleteRole(id);
    }
    public void deleteContact(int id){
        Person person = this.personDAO.getPerson(id);
        person.setContact(null);
        this.personDAO.updatePerson(person);
    }
}