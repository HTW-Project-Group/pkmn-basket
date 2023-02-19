create table basket
(
    id          UUID UNIQUE NOT NULL,
    user_id      UUID NOT NULL,
    description TEXT,
    quantity    INTEGER,
    name        VARCHAR(50),
    price       NUMERIC(10, 2) DEFAULT 0,
    pokemon_id VARCHAR (50) NOT NULL,
    PRIMARY KEY (id)
);
