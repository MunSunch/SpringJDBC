alter table ORDERS
drop constraint fk_orders_customers;
GO

drop table ORDERS;
drop table CUSTOMERS;