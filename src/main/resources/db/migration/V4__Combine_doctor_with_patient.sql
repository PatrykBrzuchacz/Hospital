CREATE TABLE `doctor` (
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
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key(user_id) references doctor (id);

alter table patient
add column id_doctor bigint,
add Foreign key (id_doctor) references doctor(id);