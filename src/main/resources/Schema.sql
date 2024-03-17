drop schema schema_itrum;

create schema if not exists schema_itrum;

create table if not exists "schema_itrum".wallets
(
    id     serial
        constraint wallets_pk
            primary key,
    amount integer not null
);

INSERT INTO "schema_itrum".wallets (id, amount)
VALUES (DEFAULT, 2000),
       (DEFAULT, 3000),
       (DEFAULT, 5000)