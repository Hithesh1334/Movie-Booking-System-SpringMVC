CREATE TABLE movie(name varchar(20),id int,release_date date,availability int,primary key(id));

Insert into movie(name,id,release_date,availability) values("KGF",1,"2022/04/14",40),("Don't Look Up",2,"2022/04/14",40),("Kantara",3,"2022/04/14",40),("RRR",4,"2022/04/14",40);

CREATE TABLE login(id int,name varchar(20),email varchar(30),password varchar(20),phoneno varchar(15),primary key(id));

Insert into login values(1,"Hithesh","hiteshg1334@gmail.com","h1234","6363997532");

CREATE TABLE bookedmovie(movie_name varchar(20),movie_id int,user_name varchar(20),email varchar(30),phone_no varchar(15),primary key(movie_id));

CREATE TABLE transaction(cardno varchar(20),expirydate date,cvv int,carttype varchar(10),nameoncard varchar(20),primary key(cardno));