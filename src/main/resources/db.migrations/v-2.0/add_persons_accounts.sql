create table accounts (
    id serial primary key,
    login varchar(50) not null unique,
    password varchar(80) not null,
    role text not null,
    status varchar(50) not null
);
GO

alter table PERSONS
add column account_id integer references accounts(id);