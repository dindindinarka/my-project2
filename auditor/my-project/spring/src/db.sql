CREATE TYPE status_enum AS ENUM('DRAFT', 'SENT');

CREATE TABLE location
(
    id bigint PRIMARY KEY,
    locationname CHARACTER VARYING(180)
);

CREATE TABLE tempoflocation
(
    id bigint PRIMARY KEY,
    locationname CHARACTER VARYING(180),
	temperature int,
	locationid int,
	counttemp int
);

ALTER TABLE tempoflocation
add COLUMN id integer

delete from tempoflocation

select * from tempoflocation

CREATE SEQUENCE public.hibernate_sequence INCREMENT 1 START 1 MINVALUE 1;