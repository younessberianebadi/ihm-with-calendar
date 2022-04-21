CREATE TABLE IF NOT EXISTS EVENTS
(
   id integer not null,
   title varchar(255),
   date date,
   date2 date,
   primary key(id)
);
CREATE TABLE IF NOT EXISTS Objectifs
(
    id integer not null,
    year integer,
    category varchar(255),
    product varchar(255),
    objectif varchar(255),
    level varchar(255),
    entity varchar(255),
    january integer,
    february integer,
    march integer,
    april integer,
    may integer,
    june integer,
    july integer,
    august integer,
    september integer,
    october integer,
    november integer,
    december integer,
    total integer,
    createdat date,
    updatedat date,
    createdby varchar(255),
    updatedby varchar(255),
    primary key(id)
);
insert into Objectifs (id, year, category, product, objectif, level, entity, january, february, march, april, may, june, july, august, september, october, november, december, total, createdat, updatedat, createdby, updatedby) values(1, 2020, 'Fixe', 'Fixe', 'Objectif Budgetaire Brut HT', 'DVGP', 'DVGP', 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 12000, "2020-01-01", "2020-01-01", 'DVGP', 'DVGP');

CREATE TABLE IF NOT EXISTS Categories
(
    id integer not null,
    name varchar(255),
    description varchar(255),
    primary key(id)
);

insert into Categories (id, name, description) values(1, 'Fixe', 'La téléphonie fixe, ou téléphonie résidentielle, correspond aux systèmes téléphoniques dont la ligne terminale d\'abonné est située à un emplacement fixe.');
insert into Categories (id, name, description) values(2, 'Mobile postpayé', 'La téléphonie fixe, ou téléphonie résidentielle, correspond aux systèmes téléphoniques dont la ligne terminale d\'abonné est située à un emplacement fixe.');
insert into Categories (id, name, description) values(3, 'Mobile prepayé', 'La téléphonie fixe, ou téléphonie résidentielle, correspond aux systèmes téléphoniques dont la ligne terminale d\'abonné est située à un emplacement fixe.');
insert into Categories (id, name, description) values(4, 'ADSL', 'La téléphonie fixe, ou téléphonie résidentielle, correspond aux systèmes téléphoniques dont la ligne terminale d\'abonné est située à un emplacement fixe.');
insert into Categories (id, name, description) values(5, 'Fibre optique', 'La téléphonie fixe, ou téléphonie résidentielle, correspond aux systèmes téléphoniques dont la ligne terminale d\'abonné est située à un emplacement fixe.');

CREATE TABLE IF NOT EXISTS Months
(
    id integer not null,
    name varchar(255),
    description varchar(255),
    primary key(id)
);

insert into Months (id, name, description) values(1, 'Janvier', '1');


CREATE TABLE IF NOT EXISTS Objectiftypes
(
    id integer not null,
    type varchar(255),
    name varchar(255),
    description varchar(255),
    primary key(id)
);

insert into Objectiftypes (id, type, name, description) values(1, 'Budgétaire', 'Objectif Budgetaire Brut HT', 'Objectif Budgetaire Brut HT');

CREATE TABLE IF NOT EXISTS Products
(
    id integer not null,
    name varchar(255),
    description varchar(255),
    categoryid integer,
    primary key(id)
);

insert into Products (id, name, description, categoryid) values(1, 'Fixe', 'Fixe', 1);


CREATE TABLE IF NOT EXISTS Years
(
    id integer not null,
    name varchar(255),
    description varchar(255),
    primary key(id)
);

insert into Years (id, name, description) values(1, '2020', '2020');
insert into Years (id, name, description) values(2, '2019', '2019');
insert into Years (id, name, description) values(3, '2018', '2018');

CREATE TABLE IF NOT EXISTS Entities
(
    id integer not null,
    name varchar(255),
    level varchar(255),
    idParent integer,
    idDirector integer,
    primary key(id)
);

insert into Entities (id, name, level, idParent, idDirector) values(1, 'Marrakech', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(2, 'Agadir', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(3, 'Casablanca', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(4, 'Fes', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(5, 'Oujda', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(6, 'Rabat', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(7, 'Marrakech', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(8, 'Settat', 'DR', 1, 2);
insert into Entities (id, name, level, idParent, idDirector) values(9, 'Tanger', 'DR', 1, 2);
