insert into roles(id,role) select '1','ROLE_ADMIN' where not exists (select 1 from roles where id=1 and role='ROLE_ADMIN');
insert into roles(id,role) select '2','ROLE_USER' where not exists (select 1 from roles where id=2 and role='ROLE_USER');
insert into roles(id,role) select '3','ROLE_MANAGER' where not exists (select 1 from roles where id=3 and role='ROLE_MANAGER');