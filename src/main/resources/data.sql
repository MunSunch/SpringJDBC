select o.product_name as "product"
from CUSTOMERS as c join ORDERS o on c.id = o.customer_id
where lower(c.name) = :name;