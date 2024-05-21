-- select current_user;
set ROLE larku;

DROP TABLE IF EXISTS Animal;
DROP TABLE IF EXISTS Adopter;


CREATE TABLE Adopter
(
    id          serial primary key not null,
    name        VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20),
    email      VARCHAR(255)
);



CREATE TABLE Animal
(
    animal_id   serial primary key not null,
    adopter_id  serial,
    FOREIGN KEY (adopter_id) REFERENCES Adopter(id),
    name        VARCHAR(255) NOT NULL,
    breed       VARCHAR(255),
    age         integer,
    type        varchar(20)
);


CREATE INDEX IF NOT EXISTS IDX_ADOPTER_ID
    ON Adopter(id, name, phonenumber, email);


CREATE INDEX IF NOT EXISTS IDX_ANIMAL_ID
    ON animal(animal_id,adopter_id);

INSERT INTO adopter (name, phoneNumber, email)
VALUES ('Komal','732-874-4554','komalhpatel87@gmail.com');
INSERT INTO adopter (name, phoneNumber, email)
VALUES ('Krishna','732-874-3554','krishnapatel@gmail.com');
INSERT INTO adopter(name, phoneNumber, email)
VALUES ('Roma','863-324-4554','romapatel7@gmail.com');


insert into animal (name, breed, age, type,adopter_id) VALUES ('Soju','American Curl Cat',7,'CAT',1);
insert into animal (name, breed, age, type,adopter_id) VALUES ('Ozzy','German Shepherd',7,'DOG',1);
insert into animal (name, breed, age, type,adopter_id) VALUES ('Siji','German Shepherd',7,'DOG',2);
insert into animal (name, breed, age, type,adopter_id) VALUES ('Gigi','German Shepherd',7,'DOG',3);

REVOKE ALL ON SCHEMA PUBLIC FROM PUBLIC;
GRANT USAGE ON SCHEMA public TO LARKU;
GRANT SELECT, INSERT, UPDATE, DELETE, TRUNCATE on ALL TABLES IN SCHEMA public TO LARKU;
GRANT USAGE, SELECT, UPDATE on ALL SEQUENCES IN SCHEMA public TO LARKU;
