package com.ecc.hibernate;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Query;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersonDAO{
    
    private File directory;
    private Configuration con;
    private ServiceRegistry reg;
    private SessionFactory sf;
    private Session session;
    private Transaction tx;

    public PersonDAO(){
        
    }

    public void init(){
        System.out.println(">>> INSIDE pDAO.init()");
        this.directory = new File(".\\infra\\resources\\hibernate.cfg.xml");
        this.con = new Configuration().configure(directory).addAnnotatedClass(Person.class).addAnnotatedClass(Roles.class);
        this.reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        this.sf = con.buildSessionFactory(reg);
        this.session = sf.openSession(); 
        
    }
    public void createPerson(Person p){
        this.tx = session.beginTransaction();
        session.save(p);
        this.tx.commit();
    }
    public void createRole(Roles r){
        this.tx = session.beginTransaction();
        session.save(r);
        this.tx.commit();
    }

    public List getPersonList(){
        List<Person> personList =  this.session.createQuery("from Person", Person.class).list();
        return personList;
    }

    public List getRoleList(){
        List<Roles> rList =  this.session.createQuery("from Roles", Roles.class).list();
        return rList;
    }

    public Person getPerson(int id){
        Person p = (Person)session.get(Person.class, id);
        return p;
    }

    public Roles getRole(int id){
        Roles role = (Roles)session.get(Roles.class, id);
        return role;
    }
    public void updateRole(Roles r){   
        this.tx = session.beginTransaction();
        session.update(r);
        this.tx.commit();
    }
    public void updatePerson(Person p){   
        this.tx = session.beginTransaction();
        session.update(p);
        this.tx.commit();
    }

    public void deletePerson(int id){
        Person person= (Person)session.get(Person.class, id);
        this.tx = session.beginTransaction();
        if(person != null){
            session.delete(person);
        }
        this.tx.commit();
    }
    public void deleteRole(int id){
        Roles role = (Roles)session.get(Roles.class, id);
        tx = session.beginTransaction();
        if(role != null){
            session.delete(role);
        }
        this.tx.commit();
    }
}