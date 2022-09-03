INSERT INTO property (city_id, street_address, taxes, mortgage) VALUES (4833, '6166 N Sheridan', 1234.56, 789.01);
INSERT INTO property (city_id, street_address, taxes, mortgage) VALUES (4833, '6157 N Sheridan', 2345.67, 890.12);

INSERT INTO unit (property_id, unit_number, rent, leased) VALUES (1, '101A', 675.90, 0);
INSERT INTO unit (property_id, unit_number, rent, leased) VALUES (1, '101B', 775.90, 1);
INSERT INTO unit (property_id, unit_number, rent, leased) VALUES (2, '201A', 875.90, 1);
INSERT INTO unit (property_id, unit_number, rent, leased) VALUES (2, '201B', 975.90, 0);

INSERT INTO tenant (unit_id, name, phone, email) VALUES (2, 'David Tennant', '6308675309', 'thedoctor@tardis.com');
INSERT INTO tenant (unit_id, name, phone, email) VALUES (3, 'Catherine Tate', '5314769524', 'notbovvered@noble.com');

INSERT INTO employee (name, phone, email, salary) VALUES ('Peter Capaldi', '5631296320', 'number12@gallifrey.com', 1200);
INSERT INTO employee (name, phone, email, salary) VALUES ('Amy Pond', '9856341287', 'petrichor@lostintime.com', 1000);
INSERT INTO employee (name, phone, email, salary) VALUES ('Rory Williams', '8526417980', 'thecenturian@lostintime.com', 1000);

INSERT INTO property_employee (property_id, person_id) VALUES (1, 1);
INSERT INTO property_employee (property_id, person_id) VALUES (1, 2);
INSERT INTO property_employee (property_id, person_id) VALUES (2, 1);
INSERT INTO property_employee (property_id, person_id) VALUES (2, 3);