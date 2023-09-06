create table CUSTOMERS (
    id serial primary key,
    name text not null,
    surname text not null,
    age integer not null,
    phone_number text
);

insert into CUSTOMERS(name, surname, age, phone_number) values
('alexey', 'mark', 22, '123456'),
('masha', 'lower', 35, '89099912120'),
('andrey', 'upper', 26, '909912'),
('munir', 'king', 25, '89873022923'),
('alexey', 'abedey', 42, '8973442023');

create table ORDERS (
    id serial primary key,
    date date,
    customer_id integer,
    product_name text not null,
    amount money not null
);

insert into ORDERS(date, customer_id, product_name, amount) VALUES
('2023-11-11', 1, 'капуста', 100.45),
('2023-12-11', 2, 'картофель', 880),
('2023-11-01', 3, 'макароны', 322),
('2023-09-04', 4, 'пиво', 1000),
('2023-08-11', 1, 'спички', 55);

alter table ORDERS
add constraint fk_orders_customers
foreign key(customer_id) references CUSTOMERS(id);