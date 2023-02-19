create table basket
(
    id          UUID               NOT NULL,
    user_id      UUID              NOT NULL,
    pokemon_id  VARCHAR(50) UNIQUE NOT NULL,
    name        VARCHAR(50)        NOT NULL,
    description TEXT,
    price       NUMERIC(10, 2) DEFAULT 0,
    quantity    INTEGER CHECK (quantity > 0),
    PRIMARY KEY (id)
);
