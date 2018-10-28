alter table user
add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key(id_role) references role (id) on delete cascade;

INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'DOCTOR');

INSERT INTO user(id, username, password,id_role) VALUES (1, 'Admin', '$2a$04$iRsccpxqihb7QvTewwyncOVpMTF/xLX4YekCDIgUi4b.BBzM4uRdi',1);
INSERT INTO user(id, username, password,id_role) VALUES (2, 'user', '$2a$04$gpcSxxNLO/pNfvxVDCAFqeInF9RrmQadtyMFX9Mywum22eEz7Lvqa',2);

