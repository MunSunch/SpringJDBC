create table CUSTOMERS (
    id serial primary key,
    name text not null,
    surname text not null,
    age integer not null,
    phone_number text
);

create table ORDERS (
    id serial primary key,
    date date,
    customer_id integer,
    product_name text not null,
    amount money not null
);

alter table ORDERS
add constraint fk_orders_customers
foreign key(customer_id) references CUSTOMERS(id);