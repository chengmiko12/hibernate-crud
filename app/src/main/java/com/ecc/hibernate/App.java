package com.ecc.hibernate;

import com.ecc.hibernate.*;
import java.util.*;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person p = new Person();
        PersonService pService = new PersonService();
        pService.init();

        Scanner sc = new Scanner(System.in);
        int input;
        int rid, pid;
        String roleName;
        int roleChoice;
        String fName,mname,lname,suffix,title,landline,
            mnumber,email,street,barangay,municipality,
            zip,bday,gwa,datehired,currentlyemployed;
        List<Roles> rList; 
        List<Person> pList; 
        Roles r;

        do{
            System.out.println("--------------------");
            System.out.println("CRUD");
            System.out.println("[1] - CREATE");
            System.out.println("[2] - READ");
            System.out.println("[3] - UPDATE");
            System.out.println("[4] - DELETE");
            System.out.println("\n[0] - TERMINATE APPLICATION");
            System.out.println("--------------------");
            System.out.println();

            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("--------------------");
                    System.out.println("CREATE");
                    System.out.println("[1] - Create Person");
                    System.out.println("[2] - Create Role");
                    System.out.println("--------------------");
    
                    int a = sc.nextInt();

                    switch (a) {
                        case 1:
                            System.out.println("--------------------");
                            System.out.println("CREATE PERSON");
                            System.out.println("--------------------");
                            System.out.println("Enter First Name: ");
                            fName = sc.next();
                            System.out.println("Enter Middle Name: ");
                            mname = sc.next();
                            System.out.println("Enter Last Name: ");
                            lname = sc.next();
                            System.out.println("Enter Suffix: ");
                            suffix = sc.next();
                            System.out.println("Enter Title: ");
                            title = sc.next();
                            System.out.println("Enter Landline: ");
                            landline = sc.next();
                            System.out.println("Enter Mobile Number: ");
                            mnumber = sc.next();
                            System.out.println("Enter Email: ");
                            email = sc.next();
                            System.out.println("Enter Street: ");
                            street = sc.next();
                            System.out.println("Enter Barangay: ");
                            barangay = sc.next();
                            System.out.println("Enter Municipality: ");
                            municipality = sc.next();
                            System.out.println("Enter Zip Code: ");
                            zip = sc.next();
                            System.out.println("Enter Birthday (YYYYMMDD): ");
                            bday = sc.next();
                            System.out.println("Enter Grade Weighted Average (GWA): ");
                            gwa = sc.next();
                            System.out.println("Enter Date Hired (YYYYMMDD): ");
                            datehired = sc.next();
                            System.out.println("Enter Currently Employed: ");
                            currentlyemployed = sc.next();
                            System.out.println("--------------------");
                            System.out.println("*** ROLES ***");
                            rList = pService.getRoleList();
                            for(int i = 0; i < rList.size(); i++){
                                System.out.println("["+ i +"] "+rList.get(i));
                                if(i == i-1){
                                    System.out.println("["+ i+1 +"] IF N/A");
                                }
                            }
                            System.out.println("--------------------");
                            System.out.println("Enter Role ID: ");
                            roleChoice = sc.nextInt();
                            

                            if(roleChoice > rList.size()){
                                r = null;
                            }else{
                                r = rList.get(roleChoice);
                            }

                            pService.createPerson(fName,mname,lname,suffix,title,
                                            landline,mnumber,email,street,barangay,
                                            municipality,zip,bday,gwa,
                                            datehired,currentlyemployed,r);

                            break;

                        case 2:
                        System.out.println("--------------------");
                        System.out.println("CREATE ROLE");
                        System.out.println("--------------------");
                        System.out.println("Enter Role Name: ");
                        roleName = sc.next();
                        pService.createRole(roleName);

                            break;
                    
                        default:
                            break;
                    }

                    break;

                case 2:
                    System.out.println("--------------------");
                    System.out.println("READ");
                    System.out.println("--------------------");
                    System.out.println("[1] Read Person List - GWA");
                    System.out.println("[2] Read Person List - Date Hired");
                    System.out.println("[3] Read Person List - Last Name");

                    int read = sc.nextInt();
                    
                        
                    switch (read) {
                        case 1:
                            System.out.println("--------------------");
                            System.out.println("LIST BY GWA");
                            pService.listGWA();
                        
                            break;

                        case 2:
                            System.out.println("--------------------");
                            System.out.println("LIST BY DATE HIRED");
                            pService.listDateHired();

                            break;
                        
                        case 3:
                            System.out.println("--------------------");
                            System.out.println("LIST BY LAST NAME");
                            pService.listLastName();
                            
                            break;
                    
                        default:
                            break;
                    }
                  break;
                
                case 3:
                    System.out.println("--------------------");
                    System.out.println("UPDATE");
                    System.out.println("[1] Update Person");
                    System.out.println("[2] Update Person Contact");
                    System.out.println("[3] Update Role");
                    System.out.println("[4] Add Role");
                    System.out.println("[5] Add Role to Person");

                    int update = sc.nextInt();

                    switch (update) {

                        case 1:
                            System.out.println("--------------------");
                            System.out.println("UPDATE");    
                            System.out.println("--------------------");

                            System.out.println("Enter Person ID To Update:");
                            pid = sc.nextInt();

                            System.out.println("Enter First Name: ");
                            fName = sc.next();
                            System.out.println("Enter Middle Name: ");
                            mname = sc.next();
                            System.out.println("Enter Last Name: ");
                            lname = sc.next();
                            System.out.println("Enter Suffix: ");
                            suffix = sc.next();
                            System.out.println("Enter Title: ");
                            title = sc.next();
                            System.out.println("Enter Landline: ");
                            landline = sc.next();
                            System.out.println("Enter Mobile Number: ");
                            mnumber = sc.next();
                            System.out.println("Enter Email: ");
                            email = sc.next();
                            System.out.println("Enter Street: ");
                            street = sc.next();
                            System.out.println("Enter Barangay: ");
                            barangay = sc.next();
                            System.out.println("Enter Municipality: ");
                            municipality = sc.next();
                            System.out.println("Enter Zip Code: ");
                            zip = sc.next();
                            System.out.println("Enter Birthday (YYYYMMDD): ");
                            bday = sc.next();
                            System.out.println("Enter Grade Weighted Average (GWA): ");
                            gwa = sc.next();
                            System.out.println("Enter Date Hired (YYYYMMDD): ");
                            datehired = sc.next();
                            System.out.println("Enter Currently Employed: ");
                            currentlyemployed = sc.next();

                            pService.updatePerson(pid,fName,mname,lname,suffix,title,
                                                landline,mnumber,email,street,barangay,
                                                municipality,zip,bday,gwa,
                                                datehired,currentlyemployed);
                            break;

                        case 3:
                            System.out.println("--------------------");
                            System.out.println("Enter Role ID:");
                            rid = sc.nextInt();
                            System.out.println("Enter New Role Name:");
                            roleName = sc.next();

                            pService.updateRole(rid, roleName);

                            break;

                        case 4: 
                            System.out.println("--------------------");
                            System.out.println("ADD ROLE TO DATABASE");
                            System.out.println("Enter New Role Name:");
                            roleName = sc.next();
                            pService.createRole(roleName);
                            
                            break;

                        case 5: 
                            System.out.println("--------------------");
                            System.out.println("ADD ROLE TO PERSON");

                            pList=pService.getPersonList();
                            rList=pService.getRoleList();

                            for(Person person:pList){
                                System.out.println(">>> " + person);
                            }
                            for(Roles role:rList){
                                System.out.println(">>> " + role);
                            }

                            System.out.println("Enter Person ID:");
                            pid = sc.nextInt();
                            System.out.println("Enter Role ID:");
                            rid = sc.nextInt();

                            pService.addRoleToPerson(pid,rid);

                            break;
                        case 2: 
                            
                            System.out.println("--------------------");
                            System.out.println("UPDATE PERSON CONTACT");
                            
                            System.out.println("Enter Person ID:");
                            pid = sc.nextInt();
                            System.out.println("Enter Landline: ");
                            landline = sc.next();
                            System.out.println("Enter Mobile Number: ");
                            mnumber = sc.next();
                            System.out.println("Enter Email: ");
                            email = sc.next();

                            pService.updatePersonContact(pid,landline,mnumber,email);
                            break;
                            
                        
                    }
                   
                    break;
                
                case 4:
                    System.out.println("--------------------");
                    System.out.println("[1] Delete Person");
                    System.out.println("[2] Delete Role");
                    System.out.println("[3] Delete Contact Information");
                    System.out.println("Enter Choice: ");
                    
                    int delete = sc.nextInt();

                    switch (delete) {
                        case 1:
                            pList=pService.getPersonList();

                            for(Person p1:pList){
                                System.out.println(">>> " + p1);
                            }
                            System.out.println("Enter Person ID to Delete: ");
                            pid = sc.nextInt();
                            pService.deletePerson(pid);
                            break;

                        case 2:
                            rList=pService.getRoleList();                          
                            for(Roles r1:rList){
                                System.out.println(">>> " + r1);
                            }
                            System.out.println("Enter Role ID to Delete: ");
                            rid = sc.nextInt();
                            pService.deleteRole(rid);
                            break;

                        case 3:
                            pList=pService.getPersonList();                            
                            for(Person p2:pList){
                                System.out.println(">>> " + p2);
                            }
                            System.out.println("Enter Person ID of Contact Information to Delete: ");
                            pid = sc.nextInt();
                            pService.deleteContact(pid);
                            break;
                    
                        default:
                            break;
                    }
                    break;

            }


            // pService.createPerson();
            // pService.updatePerson(1);
            // pService.getPersonList();
            
        }while(input!=0);
        
        System.out.println(">>> DONE!");
    }
}
