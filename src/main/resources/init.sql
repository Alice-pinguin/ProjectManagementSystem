DROP DATABASE IF EXISTS homework;
CREATE DATABASE IF NOT EXISTS homework;
use homework;

CREATE TABLE developers (
                            id_developer int NOT NULL AUTO_INCREMENT,
                            Name varchar(55) NOT NULL,
                            Age int(2),
                            Gender varchar(10),
                            PRIMARY KEY (id_developer)
);

CREATE TABLE skills (
                        id_skill int NOT NULL AUTO_INCREMENT,
                        Language varchar(10),
                        Level varchar(10),
                        PRIMARY KEY (id_skill));

CREATE TABLE projects (
                          id_project int NOT NULL AUTO_INCREMENT,
                          Name varchar(100) NOT NULL,
                          Field varchar(20) NOT NULL,
                          PRIMARY KEY (id_project));

CREATE TABLE companies (
                           id_company int NOT NULL AUTO_INCREMENT,
                           Name varchar(20) NOT NULL,
                           City varchar(20) NOT NULL,
                           PRIMARY KEY (id_company));

CREATE TABLE customers (
                           id_customer int NOT NULL AUTO_INCREMENT,
                           Name varchar(25) NOT NULL,
                           City varchar(20) NOT NULL,
                           Industry varchar (20) NOT NULL,
                           PRIMARY KEY (id_customer));

CREATE TABLE developers_skills (
                                   id_developer int NOT NULL,
                                   id_skill int NOT NULL,
                                   PRIMARY KEY (id_developer, id_skill),
                                   FOREIGN KEY (id_developer) REFERENCES developers (id_developer),
                                   FOREIGN KEY (id_skill) REFERENCES skills (id_skill));

CREATE TABLE developers_projects (
                                     id_developer int NOT NULL,
                                     id_project int NOT NULL,
                                     PRIMARY KEY (id_developer, id_project),
                                     FOREIGN KEY (id_developer) REFERENCES developers (id_developer),
                                     FOREIGN KEY (id_project) REFERENCES projects (id_project));

CREATE TABLE companies_projects (
                                    id_company int NOT NULL,
                                    id_project int NOT NULL,
                                    PRIMARY KEY (id_company, id_project),
                                    KEY id_project (id_project),
                                    FOREIGN KEY (id_company) REFERENCES companies (id_company),
                                    FOREIGN KEY (id_project) REFERENCES projects (id_project));

CREATE TABLE customers_projects (
                                    id_customer int NOT NULL,
                                    id_project int NOT NULL,
                                    PRIMARY KEY (id_customer, id_project),
                                    KEY id_project (id_project),
                                    FOREIGN KEY (id_customer) REFERENCES customers (id_customer),
                                    FOREIGN KEY (id_project) REFERENCES projects (id_project));