CREATE TABLE city (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    country_id integer NOT NULL,
    active boolean NOT NULL
);

CREATE SEQUENCE city_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE country (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    acronym character varying(2) NOT NULL
);

CREATE SEQUENCE country_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE observation (
    id integer NOT NULL,
    datetime timestamp without time zone NOT NULL,
    weatherservice_id integer NOT NULL,
    city_id integer NOT NULL,
    temperature double precision NOT NULL,
    humidity smallint NOT NULL,
    pressure double precision NOT NULL,
    windspeed double precision NOT NULL,
    winddirection character varying(3) NOT NULL,
    winddirectionindegrees double precision NOT NULL,
    sunrise timestamp without time zone NOT NULL,
    sunset timestamp without time zone NOT NULL,
    CONSTRAINT observation_pressure_check CHECK ((pressure >= (0)::double precision))
);

CREATE SEQUENCE observation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE weatherservice (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    active boolean NOT NULL,
    delayinmilliseconds bigint NOT NULL,
    CONSTRAINT weatherservice_delayinmilliseconds_check CHECK ((delayinmilliseconds >= 1000))
);

CREATE SEQUENCE weatherservice_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);

ALTER TABLE ONLY country
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);

ALTER TABLE ONLY observation
    ADD CONSTRAINT observation_pkey PRIMARY KEY (id);

ALTER TABLE ONLY country
    ADD CONSTRAINT uk_392hc9s27x9krk8h98tclsuyi UNIQUE (acronym);

ALTER TABLE ONLY weatherservice
    ADD CONSTRAINT uk_mud5lhqg73rppmoyh7bgfdtje UNIQUE (name);

ALTER TABLE ONLY country
    ADD CONSTRAINT uk_t81fgsgaq5hcgbixtau1ptk3 UNIQUE (name);

ALTER TABLE ONLY weatherservice
    ADD CONSTRAINT weatherservice_pkey PRIMARY KEY (id);

CREATE UNIQUE INDEX city_name_country_udx ON city USING btree (name, country_id);

CREATE UNIQUE INDEX observation_datetime_city_service_udx ON observation USING btree (datetime, city_id, weatherservice_id);

ALTER TABLE ONLY observation
    ADD CONSTRAINT fk_gx4lj8csx88nrmal3ull1fsor FOREIGN KEY (city_id) REFERENCES city(id);

ALTER TABLE ONLY observation
    ADD CONSTRAINT fk_l9qs909b0c13ui6fae85tfiv7 FOREIGN KEY (weatherservice_id) REFERENCES weatherservice(id);

ALTER TABLE ONLY city
    ADD CONSTRAINT fk_m503bcpirmab9y40lg2ia9d54 FOREIGN KEY (country_id) REFERENCES country(id);

insert into country
("id", "name", "acronym")
values
  (nextval('country_seq'), 'Russia', 'ru'),
  (nextval('country_seq'), 'Great Britain', 'gb');

-- TODO: move to manually assigned uuid primary keys for dictionaries
insert into city
("id", "name", "active", "country_id")
values
  (nextval('city_seq'), 'Moscow', true, (select
                                           c.id
                                         from
                                           country c
                                         where
                                           c.name = 'Russia')),
  (nextval('city_seq'), 'Yekaterinburg', true, (select
                                                  c.id
                                                from
                                                  country c
                                                where
                                                  c.name = 'Russia')),
  (nextval('city_seq'), 'London', true, (select
                                           c.id
                                         from
                                           country c
                                         where
                                           c.name = 'Great Britain'));