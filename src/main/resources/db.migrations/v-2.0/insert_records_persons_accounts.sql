insert into accounts(login, password, role, status) values
('munsun', '$2a$12$vQd9PZW.B3DvigJsqK2iF.Rl4/dhIIr768lvxJpeL3.VuLU9EPDRC', 'WRITE', 'ACTIVE'),
('andrey', '$2a$12$Lx1/.uTIg1qL2iCKk3f9i.S3vw1Ba3et1goFPdWCL024PW99naJLa', 'READ', 'ACTIVE'),
('kol2023', '$2a$12$wnDeMoMIuGX/LhfsLD/fieBHJSHNR84J5JRMpKKJ98KKHOLcKovsK', 'DELETE', 'ACTIVE'),
('lololo', '$2a$12$/mtJjkXItIvFO0lNlCBk/ePOqRrOKWDSoD2XjqgFKK5k8kExkY.Ti', 'READ', 'REMOVED');
GO

update PERSONS set account_id=1 where name='Munir';
GO

update PERSONS set account_id=2 where name='Andrey';
GO

update PERSONS set account_id=3 where name='Tolya';
GO

update PERSONS set account_id=4 where name='Kolya';