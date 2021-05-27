
create table if not exists order_items
(
    id     bigserial primary key,
    order_number bigint,
    customer_id bigint,
    product_id bigint
);