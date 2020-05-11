CREATE IF NOT EXISTS sequence hibernate_sequence;

CREATE TABLE IF NOT EXISTS player
(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email varchar(255),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    modified_date TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE IF NOT EXISTS battle_field
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS battle
(
    id BIGSERIAL PRIMARY KEY,
    battle_field_id BIGINT REFERENCES battle_field(id),
    battle_status varchar(255),
    start_at TIMESTAMP WITHOUT TIME ZONE,
    end_at TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE IF NOT EXISTS battle_participants
(
   battle_id BIGINT REFERENCES battle(id),
   player_id BIGINT REFERENCES player(id),
   PRIMARY KEY (battle_id, player_id)
);