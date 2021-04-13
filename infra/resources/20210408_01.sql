CREATE DATABASE exercise_db;

\c exercise_db

DROP SCHEMA IF EXISTS hibernate_exercise;
CREATE SCHEMA hibernate_exercise;

SET search_path TO hibernate_exercise;


DROP TABLE IF EXISTS person_role;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS roles;

CREATE TABLE person(
    pid SERIAL PRIMARY KEY,
    fname varchar(30),
    mname varchar(30),
    lname varchar(30),
    suffix varchar(10),
    title varchar(10),
    streetnumber varchar(50),
    barangay varchar(30),
    municipality varchar(30),
    zipcode varchar(10),
    birthday varchar(8),
    gwa varchar(30),
    datehired varchar(30),
    currentlyemployed varchar(30),
    landline varchar(30),
    mobilenumber varchar(30),
    email varchar(30)
);

CREATE TABLE roles(
	rid SERIAL primary key,
  roles varchar(15)
);



CREATE TABLE hibernate_exercise.person_role (
  pid INT not null,
  rid INT not null,
  FOREIGN KEY (pid) REFERENCES person(pid) ON UPDATE CASCADE,
  FOREIGN KEY (rid) REFERENCES roles(rid) ON UPDATE CASCADE);

INSERT INTO person (pid,fname,mname,lname,suffix,title,streetnumber,barangay,municipality,zipcode,birthday,gwa,datehired,currentlyemployed,landline,mobilenumber,email)
VALUES (1, 'John', 'Doe', 'Chaser', 'III', 'Mr.', '10B Alaska', 'Bakod', 'QC', '1200', '19971212', '2.0', '20210203', 'Exist', '82546545', '09178775458', 'john@ecc.com' );

INSERT INTO person (pid,fname,mname,lname,suffix,title,streetnumber,barangay,municipality,zipcode,birthday,gwa,datehired,currentlyemployed,landline,mobilenumber,email)
VALUES (2, 'Mary', 'Jane', 'Rock', 'N/A', 'Ms.', '15 Northern Rd', 'Batis', 'San Juan', '1500', '19991108', '3.0', '20200506', 'Exist', '85996487', '09096565852', 'mary@ecc.com' );


INSERT INTO person (pid,fname,mname,lname,suffix,title,streetnumber,barangay,municipality,zipcode,birthday,gwa,datehired,currentlyemployed,landline,mobilenumber,email)
VALUES (3, 'Josh', 'M', 'Roberts', 'N/A', 'Mr.', '2 Side Rd', 'Tibagan', 'San Juan', '1500', '19941208', '2.5', '20200913', 'Exist', '65498523', '09234568541', 'josh@ecc.com' );

INSERT INTO roles(rid, roles)
VALUES(1, 'QA');
INSERT INTO roles(rid, roles)
VALUES(2, 'DEV');
INSERT INTO roles(rid, roles)
VALUES(3, 'BA');
INSERT INTO roles(rid, roles)
VALUES(4, 'ACCOUNTANT');

INSERT INTO person_role (pid, rid)
VALUES (1, 3);
INSERT INTO person_role (pid, rid)
VALUES (1, 2);
INSERT INTO person_role (pid, rid)
VALUES (2, 1);
INSERT INTO person_role (pid, rid)
VALUES (2, 2);
INSERT INTO person_role (pid, rid)
VALUES (3, 4);

ALTER SEQUENCE person_pid_seq RESTART WITH 4;
ALTER SEQUENCE roles_rid_seq RESTART WITH 5;
