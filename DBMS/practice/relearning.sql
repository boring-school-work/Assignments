create database TestDB;

drop table Students;
drop table Score;

CREATE TABLE Students (
    ID VARCHAR(45) NOT NULL,
    Name VARCHAR(45),
    Age FLOAT,
    PRIMARY KEY (ID)
);

CREATE TABLE Score (
    CID VARCHAR(45) NOT NULL,
    SID INT,
    Grade FLOAT,
    PRIMARY KEY (CID)
);

/* cascade: all the time in exams */

q