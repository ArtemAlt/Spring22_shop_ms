create schema if not exists product_schema_ms;
create table if not exists product
(
    id    bigserial primary key,
    title varchar(255) not null
);
insert into product (title)
values ('Lams'),
       ('Steak'),
       ('Beef'),
       ('Turkey'),
       ('Pork'),
       ('Crab'),
       ('Cod'),
       ('Tuna'),
       ('Salmon'),
       ('Lobster'),
       ('Mushroom'),
       ('Cabbage'),
       ('Tomato'),
       ('Carrot'),
       ('Cucumber'),
       ('Orange'),
       ('Melon'),
       ('Banana'),
       ('Lemon'),
       ('Apple');



create table if not exists category
(
    id   bigserial primary key,
    name varchar(255) not null
);
insert into category (name)
values ('NEW'),
       ('OUT_OF_STORE'),
       ('AVAILABLE');

create table if not exists product_category
(
    id          bigserial primary key,
    category_id bigint not null default 1 references category (id) on DELETE RESTRICT,
    product_id  bigint not null references product (id) on DELETE RESTRICT

);
insert into product_category (product_id)
values (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10),
       (11),
       (12),
       (13),
       (14),
       (15),
       (16),
       (17),
       (18),
       (19),
       (20);

create table if not exists product_description
(
    id          bigserial primary key,
    description text default ('NO DESCRIPTION'),
    product_id  bigint not null references product (id) on DELETE RESTRICT
);
insert into product_description (product_id)
values (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10),
       (11),
       (12),
       (13),
       (14),
       (15),
       (16),
       (17),
       (18),
       (19),
       (20);

create table if not exists product_item
(
    id         bigserial primary key,
    price      decimal(10, 2),
    quantity   bigint,
    storage_id bigint,
    product_id bigint not null references product (id) on DELETE RESTRICT
);
insert into product_item (product_id)
values (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10),
       (11),
       (12),
       (13),
       (14),
       (15),
       (16),
       (17),
       (18),
       (19),
       (20);