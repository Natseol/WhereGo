create user wherego identified by '1234';
create database wherego;
grant all privileges on wherego.* to wherego;

create table users (
    id int auto_increment primary key,
    user_id varchar(40) unique NOT NULL,
    password varchar(64) NOT NULL
);

create table events (
    id int auto_increment primary key,
    codename varchar(50) NOT NULL,
    guname varchar(10) NOT NULL,
    title varchar(200) NOT NULL,
    date varchar(30) NOT NULL,
    place varchar(200) NOT NULL,
    org_name varchar(30),
    use_trgt varchar(100),
    use_free varchar(500),
    player longtext,
    program longtext,
    etc_desc longtext,
    org_link longtext,
    main_img varchar(500),
    rgsdate date,
    ticket varchar(20),
    strdate date,
    end_date date,
    themecode varchar(20),
    lot decimal(20,17),
    lat decimal(20,17),
    is_free varchar(20),
    hmpg_addr varchar(500)
);

create table bookmark(
    id int auto_increment primary key,
    user_id int not null,
    event_id int not null,
    UNIQUE KEY unique_combination (user_id, event_id),
    foreign key(user_id) REFERENCES users(id),
    foreign key(event_id) REFERENCES events(id)    
);