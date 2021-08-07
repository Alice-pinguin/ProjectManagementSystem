use homework;
INSERT INTO developers VALUES
(1, 'Zina Ivanovich', 26, 'women'),
(2, 'Vasya Pupkin', 32, 'men'),
(3, 'Petro Ignatov', 21, 'men'),
(4, 'Kira Plastinina', 22, 'women'),
(5, 'Gus Batcovich', 25, 'men'),
(6, 'Irina Chursec', 35, 'women'),
(7, 'Leonid Sagaidak', 26, 'men'),
(8, 'Igor Saltikov', 32, 'men'),
(9, 'Arkadiy Gryg', 29, 'men'),
(10, 'Vera Zinckevich', 25, 'women');

INSERT INTO skills VALUES
(1,'Java','Junior'),
(2,'Java','Middle'),
(3,'Java','Senior'),
(4,'C++','Junior'),
(5,'C++','Middle'),
(6,'C++','Senior'),
(7,'C#','Junior'),
(8,'C#','Middle'),
(9,'C#','Senior'),
(10,'JS','Junior'),
(11,'JS','Middle'),
(12,'JS','Senior');

INSERT INTO projects VALUES
(1,'Heroes', 'Gaming'),
(2, 'Money Conventer', 'Bank'),
(3, 'Weather Prognose', 'NewsChannel'),
(4, 'The Clever TeaPot', 'home appliances'),
(5, 'Customer', 'Machine learning');

INSERT INTO companies VALUES
(1,'Intellias ','Odessa'),
(2,'Itransition','Kiyv'),
(3,'SoftServe','Dnipro'),
(4, 'N-iX', 'Lviv'),
(5, 'ELEKS', 'Ternopil');

INSERT INTO customers VALUES
(1,'IKEA','Lviv', 'Home furniture'),
(2,'Pumb','Kyiv', 'Bank'),
(3,'TechoCase','Dnipro', 'Game'),
(4,'Udemy','Dnipro', 'Education'),
(5,'CRM','Chernigiv', 'News');


INSERT INTO developers_skills VALUES
(1,12), (1,9), (2,4), (3,1), (3,6), (4, 10), (5,7),(6,5), (7,2), (8,11),(9,8), (10,10), (1,3);

INSERT INTO developers_projects VALUES
(1,2),(3,1),(5,1), (2,3),(7,2),(10,3),(8,3), (1,4),(7,4),(4,3), (9,5),(7,5),(1,5);

INSERT INTO companies_projects VALUES
(1,1),(2,2),(3,3),(4,4),(5,5);

INSERT INTO customers_projects VALUES
(1,4),(2,2),(3,1),(4,5),(5,3);
use homework;
alter table developers add column salary long;
UPDATE developers SET salary = 5600 WHERE (id_developer = 1);
UPDATE developers SET salary = 1000 WHERE (id_developer = 2);
UPDATE developers SET salary = 2500 WHERE (id_developer = 3);
UPDATE developers SET salary = 3200 WHERE (id_developer = 4);
UPDATE developers SET salary = 2400 WHERE (id_developer = 5);
UPDATE developers SET salary = 2500 WHERE (id_developer = 6);
UPDATE developers SET salary = 3160 WHERE (id_developer = 7);
UPDATE developers SET salary = 4400 WHERE (id_developer = 8);
UPDATE developers SET salary = 2600 WHERE (id_developer = 9);
UPDATE developers SET salary = 1000 WHERE (id_developer = 10);
alter table projects
    add column creation_date date default current_date;
alter table projects add column cost long;
UPDATE projects SET cost = 15000 WHERE (id_project = 1);
UPDATE projects SET cost = 10000 WHERE (id_project = 2);
UPDATE projects SET cost = 10000 WHERE (id_project = 3);
UPDATE projects SET cost = 45000 WHERE (id_project = 4);
UPDATE projects SET cost = 110000 WHERE (id_project = 5);

