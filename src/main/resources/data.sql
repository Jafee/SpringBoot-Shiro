insert into user(id, username, password) VALUES(1,'user','123456');
insert into user(id, username, password) VALUES(2,'admin','123456');

insert into role(id, name) VALUES(1,'admin');
insert into role(id, name) VALUES(2,'user');

insert into permission(id, name, url) VALUES(1,'用户界面', '/');
insert into permission(id, name, url) VALUES(2,'管理员界面', '/manager');

insert into user_role(user_id, role_id) values(1, 1);
insert into user_role(user_id, role_id) values(2, 2);

insert into role_permission(role_id, permission_id) values(1, 1);
insert into role_permission(role_id, permission_id) values(2, 1);
insert into role_permission(role_id, permission_id) values(2, 2);
