create table PERSONS (
     name text not null,
     surname text not null,
     age integer not null,
     phone_number text not null,
     city_of_living text not null,
     primary key(name, surname, age)
);