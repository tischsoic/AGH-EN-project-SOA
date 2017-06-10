create table book (
  id integer primary key,
  title char(32),
  authorFirstName char(32),
  authorSecondName char(32),
  isbn char(32),
  publicationDate integer,
  price numeric(7,2)
);

create table "user" (
  user_id SERIAL PRIMARY KEY,
  username CHAR(32),
  password CHAR(64),
  admin BOOLEAN,
  logged BOOLEAN
);

create table zone(
  zone_id SERIAL PRIMARY KEY,
  name CHAR(32),
  user_id INTEGER REFERENCES "user"(user_id)
);

create table parking_meter (
  parking_meter_id SERIAL PRIMARY KEY,
  zone_id INTEGER REFERENCES zone(zone_id)
);

CREATE TABLE parking_space (
  parking_space_id SERIAL PRIMARY KEY,
  zone_id INTEGER REFERENCES zone(zone_id)
);

CREATE TABLE ticket (
  ticket_id SERIAL PRIMARY KEY,
  parking_meter_id INTEGER REFERENCES parking_meter(parking_meter_id),
  tic_start TIMESTAMP,
  tic_end TIMESTAMP,
  tic_duration INTEGER
);

CREATE TABLE occupancy (
  occupancy_id SERIAL PRIMARY KEY,
  parking_space_id INTEGER REFERENCES parking_space(parking_space_id),
  occ_start TIMESTAMP,
  occ_end TIMESTAMP,
  ticket_id INTEGER REFERENCES ticket(ticket_id)
);

