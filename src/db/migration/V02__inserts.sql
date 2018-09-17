--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2018-09-16 22:23:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2184 (class 0 OID 82053)
-- Dependencies: 193
-- Data for Name: cedula; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO cedula (id, descricao, valor, imagem) VALUES (1, 'R$100,00', 100, '100_reais.jpg');
INSERT INTO cedula (id, descricao, valor, imagem) VALUES (2, 'R$50,00', 50, '50_reais.jpg');
INSERT INTO cedula (id, descricao, valor, imagem) VALUES (3, 'R$20,00', 20, '20_reais.jpg');
INSERT INTO cedula (id, descricao, valor, imagem) VALUES (4, 'R$10,00', 10, '10_reais.jpg');


--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 192
-- Name: cedula_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cedula_id_seq', 4, true);


--
-- TOC entry 2186 (class 0 OID 82064)
-- Dependencies: 195
-- Data for Name: estoque_cedula; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO estoque_cedula (id, estoque, cedula) VALUES (2, 100, 2);
INSERT INTO estoque_cedula (id, estoque, cedula) VALUES (4, 90, 4);
INSERT INTO estoque_cedula (id, estoque, cedula) VALUES (3, 0, 3);
INSERT INTO estoque_cedula (id, estoque, cedula) VALUES (1, 30, 1);


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 194
-- Name: estoque_cedula_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estoque_cedula_id_seq', 16, true);


--
-- TOC entry 2180 (class 0 OID 82024)
-- Dependencies: 189
-- Data for Name: permissao; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 188
-- Name: permissao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('permissao_id_seq', 1, false);


--
-- TOC entry 2178 (class 0 OID 82013)
-- Dependencies: 187
-- Data for Name: tipo_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_usuario (id, nome) VALUES (1, 'ADMIN');
INSERT INTO tipo_usuario (id, nome) VALUES (2, 'USER');


--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 186
-- Name: tipo_usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_usuario_id_seq', 2, true);


--
-- TOC entry 2182 (class 0 OID 82035)
-- Dependencies: 191
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario (id, login, senha, tipo_usuario, ativo, ultimo_acesso) VALUES (1, 'admin', 'admin', 1, true, '2018-09-16 22:18:09.359359');


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 190
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_seq', 1, true);


--
-- TOC entry 2176 (class 0 OID 82001)
-- Dependencies: 185
-- Data for Name: version; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2018-09-16 22:23:24

--
-- PostgreSQL database dump complete
--

