
CREATE USER user_weather_shelest WITH PASSWORD 'Qwerty_1';
CREATE DATABASE weather_shelest WITH OWNER user_weather_shelest;

\connect weather_shelest
--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Ubuntu 10.5-1.pgdg18.04+1)
-- Dumped by pg_dump version 10.5 (Ubuntu 10.5-1.pgdg18.04+1)

--SET statement_timeout = 0;
--SET lock_timeout = 0;
--SET idle_in_transaction_session_timeout = 0;
--SET client_encoding = 'UTF8';
--SET standard_conforming_strings = on;
--SELECT pg_catalog.set_config('search_path', '', false);
--SET check_function_bodies = false;
--SET client_min_messages = warning;
--SET row_security = off;

--SET default_tablespace = '';

--SET default_with_oids = false;

--
-- Name: weather; Type: TABLE; Schema: public; Owner: user_weather_shelest
--

CREATE TABLE public.weather (
    id bigint NOT NULL,
    datetime timestamp without time zone,
    country character varying(32),
    city character varying(32),
    temperature_c integer,
    wind_chill integer,
    wind_direction integer,
    wind_speed integer
);


ALTER TABLE public.weather OWNER TO user_weather_shelest;

--
-- Name: weather_id_seq; Type: SEQUENCE; Schema: public; Owner: user_weather_shelest
--

CREATE SEQUENCE public.weather_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.weather_id_seq OWNER TO user_weather_shelest;
--
-- Name: weather_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user_weather_shelest
--
ALTER SEQUENCE public.weather_id_seq OWNED BY public.weather.id;
--
-- Name: weather id; Type: DEFAULT; Schema: public; Owner: user_weather_shelest
--

ALTER TABLE ONLY public.weather ALTER COLUMN id SET DEFAULT nextval('public.weather_id_seq'::regclass);
--
-- Data for Name: weather; Type: TABLE DATA; Schema: public; Owner: user_weather_shelest
--
--
-- Name: weather_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user_weather_shelest
--
SELECT pg_catalog.setval('public.weather_id_seq', 1, false);
--
-- Name: weather weather_pkey; Type: CONSTRAINT; Schema: public; Owner: user_weather_shelest
--
ALTER TABLE ONLY public.weather
    ADD CONSTRAINT weather_pkey PRIMARY KEY (id);
--
-- PostgreSQL database dump complete
--

