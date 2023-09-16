insert into accounts(login, password, role, status) values
('munsun', '$2a$12$vQd9PZW.B3DvigJsqK2iF.Rl4/dhIIr768lvxJpeL3.VuLU9EPDRC', 'ADMIN', 'ACTIVE'),
('andrey', '$2a$12$q43JSJt1xGcsYAqMWXhXnOAkveo7n./YM9vNcBhZ9kqHNFuUtM5WG', 'USER', 'ACTIVE'),
('kol2023', '$2a$12$wnDeMoMIuGX/LhfsLD/fieBHJSHNR84J5JRMpKKJ98KKHOLcKovsK', 'USER', 'ACTIVE'),
('lololo', '$2a$12$/mtJjkXItIvFO0lNlCBk/ePOqRrOKWDSoD2XjqgFKK5k8kExkY.Ti', 'USER', 'REMOVED');
GO

update PERSONS set account_id=1 where name='Munir';
GO

update PERSONS set account_id=2 where name='Andrey';
GO

update PERSONS set account_id=3 where name='Tolya';
GO

update PERSONS set account_id=4 where name='Kolya';