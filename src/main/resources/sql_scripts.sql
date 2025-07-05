DROP TABLE IF EXISTS pond CASCADE;
DROP TABLE IF EXISTS location CASCADE;
DROP TABLE IF EXISTS fish CASCADE;
DROP TABLE IF EXISTS location_fish CASCADE;

CREATE TABLE IF NOT EXISTS pond
(
    id        SERIAL PRIMARY KEY,
    pond_name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS location
(
    id            SERIAL PRIMARY KEY,
    location_name VARCHAR(128) NOT NULL UNIQUE,
    pond_id       INT          NOT NULL REFERENCES pond (id)
);

CREATE TABLE IF NOT EXISTS fish
(
    id        SERIAL PRIMARY KEY,
    fish_name VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS location_fish
(
    location_id INT NOT NULL REFERENCES location (id),
    fish_id     INT NOT NULL REFERENCES fish (id)
);

INSERT INTO pond(pond_name)
VALUES ('Паша'),
       ('Волхов'),
       ('Озеро');

INSERT INTO location(location_name, pond_id)
VALUES ('впереди деревня', 1),
       ('северное небо', 1),
       ('берег спасовавшей фантазии', 1),
       ('старица', 1),
       ('мурманское шоссе', 1),
       ('тихий закуток', 1),
       ('подтопленный берег', 2),
       ('северный берег', 2),
       ('западный затон', 2),
       ('тихая заводь', 2),
       ('южный залив', 2),
       ('березовая заводь', 2),
       ('ветренный плес', 2),
       ('под сенью клена', 2),
       ('лесной пляж', 2),
       ('грозовые тучи', 3),
       ('у дубравы', 3),
       ('легкий бриз', 3),
       ('домик на берегу', 3),
       ('небольшой просвет', 3),
       ('камыш и камни', 3),
       ('деревня на холме', 3);

INSERT INTO fish(fish_name)
VALUES ('Красноперка'),
       ('Плотва');

INSERT INTO location_fish(location_id, fish_id)
VALUES (7, 1),
       (7, 2),
       (8, 1),
       (8, 2);