--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.9
-- Dumped by pg_dump version 9.3.9
-- Started on 2015-08-30 17:09:29 PYT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 172 (class 3079 OID 11756)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1947 (class 0 OID 0)
-- Dependencies: 172
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 16429)
-- Name: ventas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ventas (
    id integer NOT NULL,
    numero integer,
    monto_total integer,
    nombre_cliente character varying(50) DEFAULT NULL::character varying,
    ruc_cliente integer,
    fecha timestamp without time zone
);


ALTER TABLE public.ventas OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16427)
-- Name: ventas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ventas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ventas_id_seq OWNER TO postgres;

--
-- TOC entry 1948 (class 0 OID 0)
-- Dependencies: 170
-- Name: ventas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ventas_id_seq OWNED BY ventas.id;


--
-- TOC entry 1827 (class 2604 OID 16432)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ventas ALTER COLUMN id SET DEFAULT nextval('ventas_id_seq'::regclass);


--
-- TOC entry 1939 (class 0 OID 16429)
-- Dependencies: 171
-- Data for Name: ventas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ventas VALUES (1, 1, 776470, 'Malachi Woodward', 1058144, '2015-04-15 00:00:00');
INSERT INTO ventas VALUES (2, 2, 707311, 'Fritz Christian', 4426612, '2016-07-25 00:00:00');
INSERT INTO ventas VALUES (3, 3, 811142, 'Mark Mcintosh', 5050273, '2016-03-09 00:00:00');
INSERT INTO ventas VALUES (4, 4, 828727, 'Arsenio', 1749694, '2015-10-10 00:00:00');
INSERT INTO ventas VALUES (5, 5, 376683, 'Jamal Vaughn', 2150364, '2015-03-14 00:00:00');
INSERT INTO ventas VALUES (6, 6, 828738, 'Kieran Floyd', 4616703, '2014-11-29 00:00:00');
INSERT INTO ventas VALUES (7, 7, 443768, 'Thomas Copeland', 5180700, '2016-04-22 00:00:00');
INSERT INTO ventas VALUES (8, 8, 708672, 'Merritt Fitzgerald', 4599054, '2016-06-22 00:00:00');
INSERT INTO ventas VALUES (9, 9, 569400, 'Lars Ryan', 1028522, '2015-09-02 00:00:00');
INSERT INTO ventas VALUES (10, 10, 56852, 'Tyler Miller', 1196454, '2016-02-24 00:00:00');
INSERT INTO ventas VALUES (11, 11, 195017, 'Malachi Woodward', 2179517, '2015-02-15 00:00:00');
INSERT INTO ventas VALUES (12, 12, 464520, 'Fritz Christian', 4830281, '2014-09-03 00:00:00');
INSERT INTO ventas VALUES (13, 13, 255324, 'Asher Knapp', 4206374, '2015-10-10 00:00:00');
INSERT INTO ventas VALUES (14, 14, 252216, 'Arsenio', 5377975, '2015-02-28 00:00:00');
INSERT INTO ventas VALUES (15, 15, 479157, 'Hayden Andrews', 5449188, '2016-06-18 00:00:00');
INSERT INTO ventas VALUES (16, 16, 291656, 'Joseph Ayala', 3763639, '2015-05-20 00:00:00');
INSERT INTO ventas VALUES (17, 17, 104351, 'Thomas Copeland', 1850156, '2015-10-20 00:00:00');
INSERT INTO ventas VALUES (18, 18, 621905, 'Vaughan Jordan', 4982375, '2016-01-14 00:00:00');
INSERT INTO ventas VALUES (19, 19, 553616, 'Herrod Dillard', 5526070, '2015-08-17 00:00:00');
INSERT INTO ventas VALUES (20, 20, 647602, 'Conan Weiss', 4566318, '2015-07-02 00:00:00');
INSERT INTO ventas VALUES (21, 21, 355607, 'Malachi Woodward', 4845880, '2016-05-10 00:00:00');
INSERT INTO ventas VALUES (22, 22, 171759, 'Fritz Christian', 4236601, '2014-09-19 00:00:00');
INSERT INTO ventas VALUES (23, 23, 93102, 'Nathan Roman', 5525419, '2016-06-03 00:00:00');
INSERT INTO ventas VALUES (24, 24, 765359, 'Arsenio', 5737161, '2016-03-25 00:00:00');
INSERT INTO ventas VALUES (25, 25, 378879, 'Preston King', 1712115, '2014-11-17 00:00:00');
INSERT INTO ventas VALUES (26, 26, 546607, 'Vincent Hartman', 2179855, '2014-10-29 00:00:00');
INSERT INTO ventas VALUES (27, 27, 664932, 'Thomas Copeland', 2465619, '2016-04-12 00:00:00');
INSERT INTO ventas VALUES (28, 28, 326778, 'Arsenio', 4358981, '2016-04-03 00:00:00');
INSERT INTO ventas VALUES (29, 29, 710168, 'Hammett Wolfe', 2844038, '2015-05-22 00:00:00');
INSERT INTO ventas VALUES (30, 30, 262096, 'Noble Noel', 3978629, '2016-08-12 00:00:00');
INSERT INTO ventas VALUES (31, 31, 392450, 'Malachi Woodward', 1172238, '2015-04-03 00:00:00');
INSERT INTO ventas VALUES (32, 32, 611601, 'Fritz Christian', 1399917, '2015-05-20 00:00:00');
INSERT INTO ventas VALUES (33, 33, 341142, 'Howard Randall', 2119188, '2014-10-07 00:00:00');
INSERT INTO ventas VALUES (34, 34, 631452, 'Arsenio', 3831382, '2015-03-31 00:00:00');
INSERT INTO ventas VALUES (35, 35, 447216, 'Grady Pearson', 5457182, '2015-02-20 00:00:00');
INSERT INTO ventas VALUES (36, 36, 404176, 'Hakeem Dotson', 2940220, '2015-09-01 00:00:00');
INSERT INTO ventas VALUES (37, 37, 341391, 'Thomas Copeland', 2246053, '2015-02-14 00:00:00');
INSERT INTO ventas VALUES (38, 38, 686655, 'Kennan Salinas', 1119921, '2015-11-07 00:00:00');
INSERT INTO ventas VALUES (39, 39, 692382, 'Dolan Lopez', 1246488, '2015-06-24 00:00:00');
INSERT INTO ventas VALUES (40, 40, 730772, 'Damian Morton', 1839308, '2016-02-23 00:00:00');
INSERT INTO ventas VALUES (41, 41, 348467, 'Malachi Woodward', 1973347, '2015-04-13 00:00:00');
INSERT INTO ventas VALUES (42, 42, 123854, 'Fritz Christian', 4791792, '2015-09-02 00:00:00');
INSERT INTO ventas VALUES (43, 43, 187931, 'Keefe Langley', 3049779, '2014-09-19 00:00:00');
INSERT INTO ventas VALUES (44, 44, 855220, 'Arsenio', 3812150, '2016-03-19 00:00:00');
INSERT INTO ventas VALUES (45, 45, 441063, 'Bruno Mcpherson', 4646952, '2016-06-18 00:00:00');
INSERT INTO ventas VALUES (46, 46, 705508, 'Carl Pickett', 3363242, '2015-11-01 00:00:00');
INSERT INTO ventas VALUES (47, 47, 157943, 'Thomas Copeland', 4529088, '2016-07-27 00:00:00');
INSERT INTO ventas VALUES (48, 48, 372885, 'Wing Adams', 3513665, '2016-03-15 00:00:00');
INSERT INTO ventas VALUES (49, 49, 811330, 'Macaulay Mcintyre', 2169372, '2015-11-30 00:00:00');
INSERT INTO ventas VALUES (50, 50, 537962, 'Colin Reilly', 2507601, '2015-09-06 00:00:00');
INSERT INTO ventas VALUES (51, 51, 75633, 'Malachi Woodward', 2750084, '2016-03-02 00:00:00');
INSERT INTO ventas VALUES (52, 52, 497614, 'Fritz Christian', 3415910, '2014-09-24 00:00:00');
INSERT INTO ventas VALUES (53, 53, 299847, 'Lewis Dawson', 2852649, '2015-05-27 00:00:00');
INSERT INTO ventas VALUES (54, 54, 854508, 'Arsenio', 2287373, '2015-10-22 00:00:00');
INSERT INTO ventas VALUES (55, 55, 91655, 'Dexter Oneal', 1311266, '2016-05-03 00:00:00');
INSERT INTO ventas VALUES (56, 56, 510017, 'Cole Rhodes', 1580861, '2015-06-01 00:00:00');
INSERT INTO ventas VALUES (57, 57, 436737, 'Thomas Copeland', 4226687, '2015-02-21 00:00:00');
INSERT INTO ventas VALUES (58, 58, 57064, 'Kareem Glass', 1289289, '2015-06-23 00:00:00');
INSERT INTO ventas VALUES (59, 59, 582847, 'Jesse Hopkins', 2090062, '2015-02-02 00:00:00');
INSERT INTO ventas VALUES (60, 60, 495834, 'Zachery Burnett', 1923484, '2015-07-01 00:00:00');
INSERT INTO ventas VALUES (61, 61, 709607, 'Malachi Woodward', 3313481, '2015-09-09 00:00:00');
INSERT INTO ventas VALUES (62, 62, 641847, 'Fritz Christian', 1042082, '2015-11-25 00:00:00');
INSERT INTO ventas VALUES (63, 63, 528480, 'Buckminster Rodgers', 4948434, '2016-04-22 00:00:00');
INSERT INTO ventas VALUES (64, 64, 248793, 'Arsenio', 4060297, '2016-08-26 00:00:00');
INSERT INTO ventas VALUES (65, 65, 52110, 'Thomas Finley', 1973386, '2016-01-02 00:00:00');
INSERT INTO ventas VALUES (66, 66, 166668, 'Neil Huff', 3037672, '2015-05-04 00:00:00');
INSERT INTO ventas VALUES (67, 67, 407452, 'Thomas Copeland', 1457001, '2015-09-02 00:00:00');
INSERT INTO ventas VALUES (68, 68, 397469, 'Alden Kirby', 4431881, '2016-03-10 00:00:00');
INSERT INTO ventas VALUES (69, 69, 536551, 'Daquan Delaney', 3266489, '2016-03-13 00:00:00');
INSERT INTO ventas VALUES (70, 70, 478123, 'Lance Vinson', 1525257, '2015-09-25 00:00:00');
INSERT INTO ventas VALUES (71, 71, 329713, 'Malachi Woodward', 1174018, '2016-06-20 00:00:00');
INSERT INTO ventas VALUES (72, 72, 349881, 'Fritz Christian', 5000274, '2014-10-18 00:00:00');
INSERT INTO ventas VALUES (73, 73, 236001, 'Amal Chang', 5252641, '2015-10-29 00:00:00');
INSERT INTO ventas VALUES (74, 74, 576412, 'Arsenio', 5067641, '2015-01-20 00:00:00');
INSERT INTO ventas VALUES (75, 75, 107100, 'Cody Patel', 4302844, '2015-01-08 00:00:00');
INSERT INTO ventas VALUES (76, 76, 355387, 'Hayden Nash', 4822423, '2014-08-30 00:00:00');
INSERT INTO ventas VALUES (77, 77, 98742, 'Thomas Copeland', 4261049, '2015-10-16 00:00:00');
INSERT INTO ventas VALUES (78, 78, 65327, 'Oscar Palmer', 2939871, '2016-07-07 00:00:00');
INSERT INTO ventas VALUES (79, 79, 241365, 'Jack Bright', 4954787, '2015-02-08 00:00:00');
INSERT INTO ventas VALUES (80, 80, 348067, 'Fitzgerald Oliver', 5621400, '2015-01-18 00:00:00');
INSERT INTO ventas VALUES (81, 81, 717271, 'Malachi Woodward', 5174388, '2015-11-19 00:00:00');
INSERT INTO ventas VALUES (82, 82, 183295, 'Fritz Christian', 3988566, '2015-07-21 00:00:00');
INSERT INTO ventas VALUES (83, 83, 205521, 'Abdul Mills', 5047659, '2016-05-26 00:00:00');
INSERT INTO ventas VALUES (84, 84, 441034, 'Arsenio', 4473157, '2016-06-02 00:00:00');
INSERT INTO ventas VALUES (85, 85, 305067, 'Tyrone Burch', 4545287, '2015-06-27 00:00:00');
INSERT INTO ventas VALUES (86, 86, 521127, 'Theodore Barr', 5052434, '2015-04-27 00:00:00');
INSERT INTO ventas VALUES (87, 87, 638679, 'Thomas Copeland', 5846996, '2015-10-21 00:00:00');
INSERT INTO ventas VALUES (88, 88, 484447, 'Neville Mosley', 3696303, '2015-07-30 00:00:00');
INSERT INTO ventas VALUES (89, 89, 235953, 'Perry Stewart', 2477226, '2015-06-27 00:00:00');
INSERT INTO ventas VALUES (90, 90, 590861, 'Bruno Noel', 5799885, '2015-03-12 00:00:00');
INSERT INTO ventas VALUES (91, 91, 249980, 'Malachi Woodward', 5741306, '2015-05-02 00:00:00');
INSERT INTO ventas VALUES (92, 92, 572970, 'Fritz Christian', 5745263, '2015-03-13 00:00:00');
INSERT INTO ventas VALUES (93, 93, 732217, 'Felix Peters', 4063423, '2015-07-20 00:00:00');
INSERT INTO ventas VALUES (94, 94, 498709, 'Arsenio', 4388915, '2016-07-21 00:00:00');
INSERT INTO ventas VALUES (95, 95, 328965, 'Caleb Nolan', 3437514, '2015-04-04 00:00:00');
INSERT INTO ventas VALUES (96, 96, 91870, 'Trevor Deleon', 2189013, '2015-02-10 00:00:00');
INSERT INTO ventas VALUES (97, 97, 66871, 'Thomas Copeland', 5654247, '2015-04-22 00:00:00');
INSERT INTO ventas VALUES (98, 98, 612559, 'Merritt Mcfarland', 1675120, '2015-05-10 00:00:00');
INSERT INTO ventas VALUES (99, 99, 830065, 'Dustin Andrews', 1412075, '2014-12-01 00:00:00');
INSERT INTO ventas VALUES (100, 100, 554070, 'Kennan Whitaker', 3933799, '2014-09-17 00:00:00');


--
-- TOC entry 1949 (class 0 OID 0)
-- Dependencies: 170
-- Name: ventas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ventas_id_seq', 100, true);


--
-- TOC entry 1830 (class 2606 OID 16435)
-- Name: ventas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ventas
    ADD CONSTRAINT ventas_pkey PRIMARY KEY (id);


--
-- TOC entry 1946 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-08-30 17:09:29 PYT

--
-- PostgreSQL database dump complete
--

