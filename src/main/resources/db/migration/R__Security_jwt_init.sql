CREATE TABLE `user` (
`id` bigint NOT NULL AUTO_INCREMENT,
`username` varchar(255),
`password` varchar(255),
  PRIMARY KEY (`id`));

CREATE TABLE `role` (
`id` bigint NOT NULL AUTO_INCREMENT,
`description` varchar(255),
`name` varchar(255),
PRIMARY KEY (`id`));

CREATE TABLE `user_roles`(
`user_id` bigint not null,
`role_id` bigint not null,
PRIMARY KEY(`user_id`, `role_id`));

alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key(role_id) references role (id);
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key(user_id) references user (id);

INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'USER');

INSERT INTO user(id, username, password) VALUES (1, 'Admin', '$2a$04$iRsccpxqihb7QvTewwyncOVpMTF/xLX4YekCDIgUi4b.BBzM4uRdi');
INSERT INTO user(id, username, password) VALUES (2, 'User', '$2a$04$gpcSxxNLO/pNfvxVDCAFqeInF9RrmQadtyMFX9Mywum22eEz7Lvqa');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);