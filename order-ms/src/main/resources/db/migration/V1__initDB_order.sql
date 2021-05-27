create schema if not exists order_schema_ms;
create table if not exists order_status
(
    id     bigserial primary key,
    status varchar(50) not null
);
insert into order_status(status)
values ('PAID'),
       ('RESERVED'),
       ('DELIVERED'),
       ('IN_CARD'),
       ('NaN');

create table if not exists shop_order
(
    id     bigserial primary key,
    order_status integer default 5 not null references order_status(id),
    id_customer bigint
);