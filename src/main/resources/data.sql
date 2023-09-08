select o.productName
from Customer c join fetch Order o on c.id = o.customer_id
where lower(c.name) = :name;