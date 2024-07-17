create table benutzer
(
    id   uuid,
    name varchar(255),
    primary key (id)
);

create table wochenplan
(
    id          uuid,
    benutzer_id uuid,
    name        varchar(50),
    primary key (id),
    foreign key (benutzer_id) references benutzer (id)
);

create table aktivitaet
(
    id            uuid,
    wochenplan_id uuid,
    name          varchar(100),
    wochentag     varchar(10),
    primary key (id),
    foreign key (wochenplan_id) references wochenplan (id)
);

-- insert into benutzer(id, name)
-- values ('56a20397-c953-4e3b-b033-1a9a1e574455', 'Stefan');
--
-- insert into wochenplan(id, benutzer_id, name)
-- values ('15c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', '56a20397-c953-4e3b-b033-1a9a1e574455',
--         'Mittagessen'),
--        ('25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', '56a20397-c953-4e3b-b033-1a9a1e574455',
--         'Familie');
--
-- insert into aktivitaet(id, wochenplan_id, name, wochentag)
-- values ('14b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '15c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Sahara',
--         'Montag'),
--        ('24b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '15c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Edeka',
--         'Dienstag'),
--        ('34b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '15c4f07c-f4db-4d6f-bf4c-a52f49a1bd63',
--         'Viet Kitchen', 'Mittwoch'),
--        ('44b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '15c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'PapalaCup',
--         'Donnerstag'),
--        ('54b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '15c4f07c-f4db-4d6f-bf4c-a52f49a1bd63',
--         'Burgermeister', 'Freitag'),
--        ('64b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Einkaufen',
--         'Montag'),
--        ('74b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Turnen Anna',
--         'Dienstag'),
--        ('84b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63',
--         'Opa Hans', 'Mittwoch'),
--        ('94b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Oma Angela',
--         'Donnerstag'),
--        ('10b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63',
--         'Einkaufen', 'Freitag'),
--        ('11b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Turnen Ida',
--         'Montag'),
--        ('12b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Besuch Raika',
--         'Dienstag'),
--        ('13b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63',
--         'Beachvolleyball', 'Mittwoch'),
--        ('15b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63', 'Schwimmen Ida',
--         'Donnerstag'),
--        ('16b8aa6f-5d5e-49d0-ab7b-c530fc820b3d', '25c4f07c-f4db-4d6f-bf4c-a52f49a1bd63',
--         'Garten', 'Freitag');