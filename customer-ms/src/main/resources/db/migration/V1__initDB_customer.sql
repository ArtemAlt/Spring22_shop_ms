create schema if not exists customer_schema_ms;

create table if not exists shop_account_status
(
    id   bigserial primary key,
    type varchar(50) not null
);
insert into shop_account_status (type)
values ('DEMO'),
       ('STANDARD'),
       ('VIP');




create table if not exists shop_account
(
    id     bigserial primary key,
    amount decimal(10, 2) not null default 0,
    status bigint         not null references shop_account_status (id) on DELETE RESTRICT
);

insert into shop_account(amount,status)
values (100,1),
       (200,1),
       (300,1),
       (400,1),
       (500,1);





create TABLE if not exists customer_status
(
    id   bigserial primary key,
    type varchar(50) not null
);

insert into customer_status(type)
values ('ACTIVE'),
       ('DISABLE'),
       ('BLOCK');

create table if not exists customer
(
    id         bigserial primary key,
    name       varchar(255) not null,
    password   varchar(255) not null,
    status_id  bigint       not null default 1 references customer_status (id) on DELETE RESTRICT,
    account_id bigint       not null references shop_account (id) on DELETE RESTRICT

);
insert into customer(name, password, account_id)
values ('User', '100', 1),
       ('Admin', '100', 2),
       ('SupperAdmin', '100', 3),
       ('provider', '100', 4);
create table if not exists roles
(
    id          bigserial primary key,
    name        varchar(50) not null,
    customer_id bigint      not null references customer (id) on DELETE RESTRICT
);

insert into roles(name, customer_id)
values ('ROLE_ADMIN', 2),
       ('ROLE_USER', 1),
       ('ROLE_SUPPERADMIN', 3),
       ('ROLE_PROVIDER', 4);

