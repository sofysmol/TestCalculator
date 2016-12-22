CREATE DATABASE IF NOT EXISTS testDB;

USE testDB;

CREATE TABLE IF NOT EXISTS
    testplan (id INT PRIMARY KEY,
    name VARCHAR(255),
    descr VARCHAR(255));

CREATE TABLE IF NOT EXISTS
 testcase (id INT NOT NULL,
    name VARCHAR(255),
    idPlan INT NOT NULL,
    descr VARCHAR(255),
    inp TEXT,
    `out` TEXT,
    PRIMARY KEY (id,idPlan),
    FOREIGN KEY (idPlan) REFERENCES testplan(id) ON DELETE SET CASCADE);