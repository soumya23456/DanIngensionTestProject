use dan_ingension_db;
-- create registration user table
create table if not exists DAN_USER(
userid int primary key auto_increment not null,
fullname varchar(255) unique not null,
email varchar(200) unique not null,
phonenumber varchar(100) unique not null,
userpassword varchar(200) not null,
address varchar(255) not null,
postalcode varchar(100) not null,
region varchar(150) not null,
country varchar(150) not null,
-- usertype varchar(100) not null,
createdAt varchar(255) not null,
updatedAt varchar(255) not null,
isActivated boolean not null
);

-- create dan_user type table
create table if not exists USER_TYPE(
typeid int primary key auto_increment not null,
usertype varchar(100) unique not null);

CREATE TABLE if not exists `userroles` (
  `user_id` int NOT NULL,
  `type_id` int NOT NULL,
  INDEX `user_id_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `type_id_fk_idx` (`type_id` ASC) VISIBLE,
  CONSTRAINT `user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `DAN_USER` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `type_id_fk`
    FOREIGN KEY (`type_id`)
    REFERENCES `USER_TYPE` (`typeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- create file upload table
create table if not exists FILE(
fileid int primary key auto_increment not null,
filename varchar(255) not null,
filetype varchar(200) not null,
filesize float not null,
username varchar(255) not null,
usertype varchar(100) not null,
createdAt varchar(255) not null
);

-- create employee table
create table if not exists EMPLOYEE(
employeeid int auto_increment not null primary key,
employee_name varchar(255) not null unique,
phone varchar(100) not null,
email varchar(200) not null,
address varchar(255) not null,
postalZip varchar(100) not null,
region varchar(150) not null,
country varchar(150) not null,
createdAt varchar(255) not null,
updatedAt varchar(255) not null
);

-- create contractor table
create table if not exists CONTRACTOR(
contractorid int auto_increment not null primary key,
contractor_name varchar(255) not null unique,
phone varchar(100) not null,
email varchar(200) not null,
address varchar(255) not null,
postalZip varchar(100) not null,
region varchar(150) not null,
country varchar(150) not null,
createdAt varchar(255) not null,
updatedAt varchar(255) not null
);

-- create samplecsvuser table
CREATE TABLE IF NOT EXISTS DAN_TEST_CSVDATA (
    testid INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    testname VARCHAR(255) NOT NULL,
    phone VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
    address VARCHAR(255) NOT NULL,
    postalZip VARCHAR(100) NOT NULL,
    region VARCHAR(150) NOT NULL,
    country VARCHAR(150) NOT NULL
);

-- create feedback table
create table if not exists FEEDBACK(
feedbackid int auto_increment not null primary key,
fullname varchar(255) not null,
email varchar(200) not null,
subject varchar(255) not null,
message text not null,
createdAt varchar(255) not null
);

-- insert user types to user_type table
-- insert into dan_project_db.user_type(usertype) values('ADMIN');
-- insert into dan_project_db.user_type(usertype) values('CLIENT');
-- insert into dan_project_db.user_type(usertype) values('VENDOR');