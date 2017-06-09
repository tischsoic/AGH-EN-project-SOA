create table book (
  id integer primary key,
  title char(32),
  authorFirstName char(32),
  authorSecondName char(32),
  isbn char(32),
  publicationDate integer,
  price numeric(7,2)
);