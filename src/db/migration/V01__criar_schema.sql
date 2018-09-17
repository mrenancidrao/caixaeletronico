--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2018-09-16 22:12:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 193 (class 1259 OID 82053)
-- Name: cedula; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cedula (
    id integer NOT NULL,
    descricao character varying,
    valor integer,
    imagem character varying
);


ALTER TABLE cedula OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 82051)
-- Name: cedula_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cedula_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cedula_id_seq OWNER TO postgres;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 192
-- Name: cedula_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cedula_id_seq OWNED BY cedula.id;


--
-- TOC entry 195 (class 1259 OID 82064)
-- Name: estoque_cedula; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE estoque_cedula (
    id integer NOT NULL,
    estoque integer,
    cedula integer
);


ALTER TABLE estoque_cedula OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 82062)
-- Name: estoque_cedula_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE estoque_cedula_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estoque_cedula_id_seq OWNER TO postgres;

--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 194
-- Name: estoque_cedula_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE estoque_cedula_id_seq OWNED BY estoque_cedula.id;


--
-- TOC entry 189 (class 1259 OID 82024)
-- Name: permissao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE permissao (
    id integer NOT NULL,
    descricao character varying
);


ALTER TABLE permissao OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 82022)
-- Name: permissao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE permissao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE permissao_id_seq OWNER TO postgres;

--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 188
-- Name: permissao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE permissao_id_seq OWNED BY permissao.id;


--
-- TOC entry 187 (class 1259 OID 82013)
-- Name: tipo_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_usuario (
    id integer NOT NULL,
    nome character varying
);


ALTER TABLE tipo_usuario OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 82011)
-- Name: tipo_usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 186
-- Name: tipo_usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_usuario_id_seq OWNED BY tipo_usuario.id;


--
-- TOC entry 191 (class 1259 OID 82035)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id integer NOT NULL,
    login character varying,
    senha character varying,
    tipo_usuario integer,
    ativo boolean,
    ultimo_acesso timestamp without time zone
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 82033)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2187 (class 0 OID 0)
-- Dependencies: 190
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;


--
-- TOC entry 185 (class 1259 OID 82001)
-- Name: version; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE version (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE version OWNER TO postgres;

--
-- TOC entry 2038 (class 2604 OID 82056)
-- Name: cedula id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cedula ALTER COLUMN id SET DEFAULT nextval('cedula_id_seq'::regclass);


--
-- TOC entry 2039 (class 2604 OID 82067)
-- Name: estoque_cedula id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estoque_cedula ALTER COLUMN id SET DEFAULT nextval('estoque_cedula_id_seq'::regclass);


--
-- TOC entry 2036 (class 2604 OID 82027)
-- Name: permissao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permissao ALTER COLUMN id SET DEFAULT nextval('permissao_id_seq'::regclass);


--
-- TOC entry 2035 (class 2604 OID 82016)
-- Name: tipo_usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_usuario ALTER COLUMN id SET DEFAULT nextval('tipo_usuario_id_seq'::regclass);


--
-- TOC entry 2037 (class 2604 OID 82038)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);


--
-- TOC entry 2052 (class 2606 OID 82061)
-- Name: cedula cedula_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cedula
    ADD CONSTRAINT cedula_pk PRIMARY KEY (id);


--
-- TOC entry 2054 (class 2606 OID 82076)
-- Name: estoque_cedula cedula_uk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estoque_cedula
    ADD CONSTRAINT cedula_uk UNIQUE (cedula);


--
-- TOC entry 2056 (class 2606 OID 82069)
-- Name: estoque_cedula estoque_cedula_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estoque_cedula
    ADD CONSTRAINT estoque_cedula_pk PRIMARY KEY (id);


--
-- TOC entry 2046 (class 2606 OID 82032)
-- Name: permissao permissao_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permissao
    ADD CONSTRAINT permissao_pk PRIMARY KEY (id);


--
-- TOC entry 2044 (class 2606 OID 82021)
-- Name: tipo_usuario tipo_usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_usuario
    ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY (id);


--
-- TOC entry 2048 (class 2606 OID 82045)
-- Name: usuario usuario_login_uk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_login_uk UNIQUE (login);


--
-- TOC entry 2050 (class 2606 OID 82043)
-- Name: usuario usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id);


--
-- TOC entry 2041 (class 2606 OID 82009)
-- Name: version version_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY version
    ADD CONSTRAINT version_pk PRIMARY KEY (installed_rank);


--
-- TOC entry 2042 (class 1259 OID 82010)
-- Name: version_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX version_s_idx ON version USING btree (success);


--
-- TOC entry 2058 (class 2606 OID 82077)
-- Name: estoque_cedula estoque_cedula_cedula_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estoque_cedula
    ADD CONSTRAINT estoque_cedula_cedula_fk FOREIGN KEY (cedula) REFERENCES cedula(id);


--
-- TOC entry 2057 (class 2606 OID 82046)
-- Name: usuario usuario_tipo_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_tipo_usuario_fk FOREIGN KEY (tipo_usuario) REFERENCES tipo_usuario(id);


-- Completed on 2018-09-16 22:12:04

--
-- PostgreSQL database dump complete
--

