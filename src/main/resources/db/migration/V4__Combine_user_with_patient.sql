CREATE TABLE `user` (
`id` bigint NOT NULL AUTO_INCREMENT,
`username` varchar(255),
`password` varchar(255),
`id_role` bigint,
  PRIMARY KEY (`id`));

CREATE TABLE `role` (
`id` bigint NOT NULL AUTO_INCREMENT,
`description` varchar(255),
`name` varchar(255),
PRIMARY KEY (`id`));

alter table user
add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key(id_role) references role (id) on delete cascade;

alter table patient
add column id_user bigint,
add Foreign key (id_user) references user(id);