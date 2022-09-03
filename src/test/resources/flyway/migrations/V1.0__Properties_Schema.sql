DROP TABLE IF EXISTS property_employee;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS tenant;
DROP TABLE IF EXISTS unit;
DROP TABLE IF EXISTS property;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS state;

CREATE TABLE state(
    state_code CHAR(2) NOT NULL,
    PRIMARY KEY (state_code)
);

CREATE TABLE city(
    city_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    state_code CHAR(2) NOT NULL,
    city_name VARCHAR(64) NOT NULL,
    PRIMARY KEY (city_id),
    UNIQUE KEY (city_name, state_code),
    FOREIGN KEY (state_code) REFERENCES state (state_code) ON DELETE CASCADE
);

CREATE TABLE property(
    property_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    city_id INT UNSIGNED NOT NULL,
    street_address VARCHAR(64) NOT NULL,
    taxes DECIMAL(8, 2) NOT NULL,
    mortgage DECIMAL(7, 2) NOT NULL,
    PRIMARY KEY (property_id),
    UNIQUE KEY (street_address, city_id),
    FOREIGN KEY (city_id) REFERENCES city (city_id) ON DELETE CASCADE
);

CREATE TABLE unit(
    unit_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    property_id INT UNSIGNED NOT NULL,
    unit_number VARCHAR(4) NOT NULL,
    rent DECIMAL(7, 2) NOT NULL,
    leased BOOLEAN NOT NULL,
    PRIMARY KEY (unit_id),
    UNIQUE KEY (unit_number, property_id),
    FOREIGN KEY (property_id) REFERENCES property (property_id) ON DELETE CASCADE
);

CREATE TABLE tenant(
    person_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    unit_id INT UNSIGNED NOT NULL,
    name VARCHAR(64) NOT NULL,
    phone CHAR(10) NOT NULL,
    email VARCHAR(64) NOT NULL,
    PRIMARY KEY (person_id),
    UNIQUE KEY (unit_id),
    FOREIGN KEY (unit_id) REFERENCES unit (unit_id) ON DELETE CASCADE
);

CREATE TABLE employee(
    person_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    name VARCHAR(64) NOT NULL,
    phone CHAR(10) NOT NULL,
    email VARCHAR(64) NOT NULL,
    salary DECIMAL(8, 2) NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE property_employee(
    property_id INT UNSIGNED NOT NULL,
    person_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (property_id) REFERENCES property (property_id) ON DELETE CASCADE,
    FOREIGN KEY (person_id) REFERENCES employee (person_id) ON DELETE CASCADE,
    UNIQUE KEY (property_id, person_id)
);