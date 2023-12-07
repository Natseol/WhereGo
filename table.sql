create table users (
    id int auto_increment primary key,
    user_id varchar(40) NOT NULL,
    password varchar(64) NOT NULL
);

create table events (
    id int auto_increment primary key,
    codename varchar(50) NOT NULL,
    guname varchar(10) NOT NULL,
    title varchar(200) NOT NULL,
    date varchar(30) NOT NULL,
    place varchar(20) NOT NULL,
    org_name varchar(30),
    use_trgt varchar(20),
    use_fee varchar(200),
    player varchar(20),
    program varchar(200),
    ete_desc varchar(200),
    org_link varchar(200),
    main_img varchar(200),
    rgsdate varchar(20),
    ticket varchar(20),
    strdate varchar(50),
    end_date varchar(50),
    themecode varchar(20),
    lot decimal(20,17),
    lat decimal(20,17),
    is_free varchar(20),
    hmpg_addr varchar(200)
);

create table bookmark(
    id int auto_increment primary key,
    user_id int not null,
    event_id int not null,
    foreign key(user_id) REFERENCES users(id),
    foreign key(event_id) REFERENCES events(id)
);