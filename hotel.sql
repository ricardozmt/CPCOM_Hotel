--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-01-20 03:15:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 16523)
-- Name: hotel; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA hotel;


ALTER SCHEMA hotel OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16524)
-- Name: cliente; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.cliente (
    id_cliente integer NOT NULL,
    profissao character varying,
    nome character varying,
    telefone character varying,
    cpf character varying,
    email character varying,
    cep character varying,
    logradouro character varying,
    numero integer,
    complemento character varying
);


ALTER TABLE hotel.cliente OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16529)
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.cliente_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hotel.cliente_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 3450 (class 0 OID 0)
-- Dependencies: 216
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.cliente_id_cliente_seq OWNED BY hotel.cliente.id_cliente;


--
-- TOC entry 217 (class 1259 OID 16530)
-- Name: funcionario; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.funcionario (
    id_funcionario integer NOT NULL,
    numero_cdt integer,
    nome character varying,
    telefone character varying,
    cpf character varying,
    email character varying,
    cep character varying,
    logradouro character varying,
    numero integer,
    complemento character varying,
    usuario character varying,
    senha character varying
);


ALTER TABLE hotel.funcionario OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16535)
-- Name: funcionario_id_funcionario_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.funcionario_id_funcionario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hotel.funcionario_id_funcionario_seq OWNER TO postgres;

--
-- TOC entry 3451 (class 0 OID 0)
-- Dependencies: 218
-- Name: funcionario_id_funcionario_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.funcionario_id_funcionario_seq OWNED BY hotel.funcionario.id_funcionario;


--
-- TOC entry 219 (class 1259 OID 16536)
-- Name: hospedagem; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.hospedagem (
    id_hospedagem integer NOT NULL,
    data_reserva date,
    inf_pagamento double precision,
    numero_cartao_acesso integer,
    data_checkout character varying,
    "data_check-in" character varying,
    id_funcionario integer,
    id_cliente integer,
    id_suite integer
);


ALTER TABLE hotel.hospedagem OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16541)
-- Name: hospedagem_id_hospedagem_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.hospedagem_id_hospedagem_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hotel.hospedagem_id_hospedagem_seq OWNER TO postgres;

--
-- TOC entry 3452 (class 0 OID 0)
-- Dependencies: 220
-- Name: hospedagem_id_hospedagem_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.hospedagem_id_hospedagem_seq OWNED BY hotel.hospedagem.id_hospedagem;


--
-- TOC entry 221 (class 1259 OID 16542)
-- Name: registro_de_servicos; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.registro_de_servicos (
    id_registro_servicos integer NOT NULL,
    codigo_hospedagem integer,
    descricao character varying,
    valor double precision,
    id_hospedagem integer
);


ALTER TABLE hotel.registro_de_servicos OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16547)
-- Name: registro_de_servicos_id_registro_servicos_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.registro_de_servicos_id_registro_servicos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hotel.registro_de_servicos_id_registro_servicos_seq OWNER TO postgres;

--
-- TOC entry 3453 (class 0 OID 0)
-- Dependencies: 222
-- Name: registro_de_servicos_id_registro_servicos_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.registro_de_servicos_id_registro_servicos_seq OWNED BY hotel.registro_de_servicos.id_registro_servicos;


--
-- TOC entry 223 (class 1259 OID 16548)
-- Name: suite; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.suite (
    id_suite integer NOT NULL,
    id_tipo_suite integer,
    disponivel boolean
);


ALTER TABLE hotel.suite OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16551)
-- Name: suite_id_suite_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.suite_id_suite_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hotel.suite_id_suite_seq OWNER TO postgres;

--
-- TOC entry 3454 (class 0 OID 0)
-- Dependencies: 224
-- Name: suite_id_suite_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.suite_id_suite_seq OWNED BY hotel.suite.id_suite;


--
-- TOC entry 225 (class 1259 OID 16552)
-- Name: tipo_suite; Type: TABLE; Schema: hotel; Owner: postgres
--

CREATE TABLE hotel.tipo_suite (
    id_tipo_suite integer NOT NULL,
    descricao character varying,
    valor double precision
);


ALTER TABLE hotel.tipo_suite OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16557)
-- Name: tipo_suite_id_tipo_suite_seq; Type: SEQUENCE; Schema: hotel; Owner: postgres
--

CREATE SEQUENCE hotel.tipo_suite_id_tipo_suite_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hotel.tipo_suite_id_tipo_suite_seq OWNER TO postgres;

--
-- TOC entry 3455 (class 0 OID 0)
-- Dependencies: 226
-- Name: tipo_suite_id_tipo_suite_seq; Type: SEQUENCE OWNED BY; Schema: hotel; Owner: postgres
--

ALTER SEQUENCE hotel.tipo_suite_id_tipo_suite_seq OWNED BY hotel.tipo_suite.id_tipo_suite;


--
-- TOC entry 228 (class 1259 OID 16672)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    profissao character varying,
    nome character varying,
    telefone character varying,
    cpf character varying,
    email character varying,
    cep character varying,
    logradouro character varying,
    complemento character varying,
    numero character varying
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16671)
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 3456 (class 0 OID 0)
-- Dependencies: 227
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_cliente_seq OWNED BY public.cliente.id_cliente;


--
-- TOC entry 230 (class 1259 OID 16681)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    id_funcionario integer NOT NULL,
    nome character varying,
    telefone character varying,
    cpf character varying,
    email character varying,
    cep character varying,
    logradouro character varying,
    complemento character varying,
    usuario character varying,
    senha character varying,
    cargo character varying,
    numero_cdt character varying,
    numero character varying
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16680)
-- Name: funcionario_id_funcionario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.funcionario_id_funcionario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.funcionario_id_funcionario_seq OWNER TO postgres;

--
-- TOC entry 3457 (class 0 OID 0)
-- Dependencies: 229
-- Name: funcionario_id_funcionario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.funcionario_id_funcionario_seq OWNED BY public.funcionario.id_funcionario;


--
-- TOC entry 236 (class 1259 OID 16711)
-- Name: hospedagem; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hospedagem (
    id_hospedagem integer NOT NULL,
    numero_cartao_acesso integer,
    id_cliente integer,
    id_suite integer,
    inf_pagamento character varying,
    data_checkin character varying,
    data_checkout character varying,
    data_reserva character varying
);


ALTER TABLE public.hospedagem OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16710)
-- Name: hospedagem_id_hospedagem_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hospedagem_id_hospedagem_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hospedagem_id_hospedagem_seq OWNER TO postgres;

--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 235
-- Name: hospedagem_id_hospedagem_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hospedagem_id_hospedagem_seq OWNED BY public.hospedagem.id_hospedagem;


--
-- TOC entry 238 (class 1259 OID 16735)
-- Name: registro_de_servicos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.registro_de_servicos (
    id_registro_servicos integer NOT NULL,
    descricao character varying,
    valor double precision,
    id_hospedagem integer
);


ALTER TABLE public.registro_de_servicos OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16734)
-- Name: registro_de_servicos_id_registro_servicos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.registro_de_servicos_id_registro_servicos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.registro_de_servicos_id_registro_servicos_seq OWNER TO postgres;

--
-- TOC entry 3459 (class 0 OID 0)
-- Dependencies: 237
-- Name: registro_de_servicos_id_registro_servicos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.registro_de_servicos_id_registro_servicos_seq OWNED BY public.registro_de_servicos.id_registro_servicos;


--
-- TOC entry 234 (class 1259 OID 16699)
-- Name: suite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.suite (
    id_suite integer NOT NULL,
    id_tipo_suite integer,
    disponivel boolean,
    nome character varying,
    valor double precision
);


ALTER TABLE public.suite OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16698)
-- Name: suite_id_suite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.suite_id_suite_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.suite_id_suite_seq OWNER TO postgres;

--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 233
-- Name: suite_id_suite_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.suite_id_suite_seq OWNED BY public.suite.id_suite;


--
-- TOC entry 232 (class 1259 OID 16690)
-- Name: tipo_suite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_suite (
    id_tipo_suite integer NOT NULL,
    descricao character varying
);


ALTER TABLE public.tipo_suite OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16689)
-- Name: tipo_suite_id_tipo_suite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_suite_id_tipo_suite_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_suite_id_tipo_suite_seq OWNER TO postgres;

--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 231
-- Name: tipo_suite_id_tipo_suite_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_suite_id_tipo_suite_seq OWNED BY public.tipo_suite.id_tipo_suite;


--
-- TOC entry 239 (class 1259 OID 25021)
-- Name: view_hospedagem; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.view_hospedagem AS
 SELECT h.id_hospedagem,
    c.nome,
    h.data_reserva,
    s.nome AS suite,
    s.valor,
    h.numero_cartao_acesso,
    h.data_checkin,
    h.data_checkout,
    h.inf_pagamento
   FROM ((public.hospedagem h
     JOIN public.cliente c ON ((c.id_cliente = h.id_cliente)))
     JOIN public.suite s ON ((s.id_suite = h.id_suite)));


ALTER TABLE public.view_hospedagem OWNER TO postgres;

--
-- TOC entry 3233 (class 2604 OID 16558)
-- Name: cliente id_cliente; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('hotel.cliente_id_cliente_seq'::regclass);


--
-- TOC entry 3234 (class 2604 OID 16559)
-- Name: funcionario id_funcionario; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.funcionario ALTER COLUMN id_funcionario SET DEFAULT nextval('hotel.funcionario_id_funcionario_seq'::regclass);


--
-- TOC entry 3235 (class 2604 OID 16560)
-- Name: hospedagem id_hospedagem; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.hospedagem ALTER COLUMN id_hospedagem SET DEFAULT nextval('hotel.hospedagem_id_hospedagem_seq'::regclass);


--
-- TOC entry 3236 (class 2604 OID 16561)
-- Name: registro_de_servicos id_registro_servicos; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.registro_de_servicos ALTER COLUMN id_registro_servicos SET DEFAULT nextval('hotel.registro_de_servicos_id_registro_servicos_seq'::regclass);


--
-- TOC entry 3237 (class 2604 OID 16562)
-- Name: suite id_suite; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.suite ALTER COLUMN id_suite SET DEFAULT nextval('hotel.suite_id_suite_seq'::regclass);


--
-- TOC entry 3238 (class 2604 OID 16563)
-- Name: tipo_suite id_tipo_suite; Type: DEFAULT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.tipo_suite ALTER COLUMN id_tipo_suite SET DEFAULT nextval('hotel.tipo_suite_id_tipo_suite_seq'::regclass);


--
-- TOC entry 3239 (class 2604 OID 16675)
-- Name: cliente id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_cliente_seq'::regclass);


--
-- TOC entry 3240 (class 2604 OID 16684)
-- Name: funcionario id_funcionario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario ALTER COLUMN id_funcionario SET DEFAULT nextval('public.funcionario_id_funcionario_seq'::regclass);


--
-- TOC entry 3243 (class 2604 OID 16714)
-- Name: hospedagem id_hospedagem; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospedagem ALTER COLUMN id_hospedagem SET DEFAULT nextval('public.hospedagem_id_hospedagem_seq'::regclass);


--
-- TOC entry 3244 (class 2604 OID 16738)
-- Name: registro_de_servicos id_registro_servicos; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.registro_de_servicos ALTER COLUMN id_registro_servicos SET DEFAULT nextval('public.registro_de_servicos_id_registro_servicos_seq'::regclass);


--
-- TOC entry 3242 (class 2604 OID 16702)
-- Name: suite id_suite; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suite ALTER COLUMN id_suite SET DEFAULT nextval('public.suite_id_suite_seq'::regclass);


--
-- TOC entry 3241 (class 2604 OID 16693)
-- Name: tipo_suite id_tipo_suite; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_suite ALTER COLUMN id_tipo_suite SET DEFAULT nextval('public.tipo_suite_id_tipo_suite_seq'::regclass);


--
-- TOC entry 3421 (class 0 OID 16524)
-- Dependencies: 215
-- Data for Name: cliente; Type: TABLE DATA; Schema: hotel; Owner: postgres
--



--
-- TOC entry 3423 (class 0 OID 16530)
-- Dependencies: 217
-- Data for Name: funcionario; Type: TABLE DATA; Schema: hotel; Owner: postgres
--



--
-- TOC entry 3425 (class 0 OID 16536)
-- Dependencies: 219
-- Data for Name: hospedagem; Type: TABLE DATA; Schema: hotel; Owner: postgres
--



--
-- TOC entry 3427 (class 0 OID 16542)
-- Dependencies: 221
-- Data for Name: registro_de_servicos; Type: TABLE DATA; Schema: hotel; Owner: postgres
--



--
-- TOC entry 3429 (class 0 OID 16548)
-- Dependencies: 223
-- Data for Name: suite; Type: TABLE DATA; Schema: hotel; Owner: postgres
--



--
-- TOC entry 3431 (class 0 OID 16552)
-- Dependencies: 225
-- Data for Name: tipo_suite; Type: TABLE DATA; Schema: hotel; Owner: postgres
--



--
-- TOC entry 3434 (class 0 OID 16672)
-- Dependencies: 228
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente (id_cliente, profissao, nome, telefone, cpf, email, cep, logradouro, complemento, numero) VALUES (15, 'Programador', 'Ricardo', '(33)33333-333333', '444.444.444-44', 'ricardo@gmail.com', '33-333-333', 'Avenida 2', 'Casa', '2345');
INSERT INTO public.cliente (id_cliente, profissao, nome, telefone, cpf, email, cep, logradouro, complemento, numero) VALUES (16, 'Gerente de projetos', 'Josh', '(42)34334-434343', '233.333.333-33', 'josh@gmail.com', '32-325-995', 'Avenida 34', 'Casa', '2323');
INSERT INTO public.cliente (id_cliente, profissao, nome, telefone, cpf, email, cep, logradouro, complemento, numero) VALUES (17, 'Comerciante', 'Reck', '(55)55555-555555', '455.555.555-55', 'reck@gmail.com', '32-429-293', 'Avenida 55', 'Casa', '5543');
INSERT INTO public.cliente (id_cliente, profissao, nome, telefone, cpf, email, cep, logradouro, complemento, numero) VALUES (18, 'Vendedor', 'Murilo', '(32)32323-232322', '929.424.329-49', 'murilo@gmail.com', '32-323-232', 'Avenida 66', 'Casa', '2323');
INSERT INTO public.cliente (id_cliente, profissao, nome, telefone, cpf, email, cep, logradouro, complemento, numero) VALUES (19, 'Funcionario', 'Felipe', '(23)23232-232323', '293.293.232-92', 'felipe@gmail.com', '23-232-323', 'Aveniad 242', 'Casa', '2323');


--
-- TOC entry 3436 (class 0 OID 16681)
-- Dependencies: 230
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.funcionario (id_funcionario, nome, telefone, cpf, email, cep, logradouro, complemento, usuario, senha, cargo, numero_cdt, numero) VALUES (31, 'Kadu', '(55)55555-5555', '232.323.232-32', 'kadu@gmail.com', '34333-333', 'Casa', 'Casa', '', '', 'Programador', '54545454', '2493');
INSERT INTO public.funcionario (id_funcionario, nome, telefone, cpf, email, cep, logradouro, complemento, usuario, senha, cargo, numero_cdt, numero) VALUES (41, 'Admin', '(55)55555-5555', '444.444.444-44', 'adm@gmail.com', '33333-333', 'Avenida 9', 'Casa', '', '', 'Administrador', '2323232332', '4232');
INSERT INTO public.funcionario (id_funcionario, nome, telefone, cpf, email, cep, logradouro, complemento, usuario, senha, cargo, numero_cdt, numero) VALUES (44, 'Admin', '(55)55555-5555', '444.444.444-44', 'adm@gmail.com', '33333-333', 'Avenida 9', 'Casa', '', '', 'Administrador', '2323232332', '4232');
INSERT INTO public.funcionario (id_funcionario, nome, telefone, cpf, email, cep, logradouro, complemento, usuario, senha, cargo, numero_cdt, numero) VALUES (42, 'Pedro', '(32)32323-2232', '333.333.333-33', 'pedro@gmail.com', '33333-333', 'Avenida 4', 'Casa', '', '', 'Diretor de eventos', '32332333', '2423');
INSERT INTO public.funcionario (id_funcionario, nome, telefone, cpf, email, cep, logradouro, complemento, usuario, senha, cargo, numero_cdt, numero) VALUES (43, 'Pedro', '(32)32323-2232', '333.333.333-33', 'pedro@gmail.com', '33333-333', 'Avenida 4', 'Casa', '', '', 'Diretor de eventos', '32332333', '2423');


--
-- TOC entry 3442 (class 0 OID 16711)
-- Dependencies: 236
-- Data for Name: hospedagem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.hospedagem (id_hospedagem, numero_cartao_acesso, id_cliente, id_suite, inf_pagamento, data_checkin, data_checkout, data_reserva) VALUES (16, 3232, 15, 17, 'Credito', '33/33/3333', '33/33/3333', '15/55/5555');
INSERT INTO public.hospedagem (id_hospedagem, numero_cartao_acesso, id_cliente, id_suite, inf_pagamento, data_checkin, data_checkout, data_reserva) VALUES (17, 2222, 16, 18, 'Debito', '33/33/3333', '44/44/4444', '15/55/5555');
INSERT INTO public.hospedagem (id_hospedagem, numero_cartao_acesso, id_cliente, id_suite, inf_pagamento, data_checkin, data_checkout, data_reserva) VALUES (18, 2222, 17, 19, 'Pix', '55/55/5555', '44/44/4444', '22/22/2222');


--
-- TOC entry 3444 (class 0 OID 16735)
-- Dependencies: 238
-- Data for Name: registro_de_servicos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.registro_de_servicos (id_registro_servicos, descricao, valor, id_hospedagem) VALUES (2, 'Bolão', 200, NULL);
INSERT INTO public.registro_de_servicos (id_registro_servicos, descricao, valor, id_hospedagem) VALUES (3, 'Bolito', 70, 17);


--
-- TOC entry 3440 (class 0 OID 16699)
-- Dependencies: 234
-- Data for Name: suite; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.suite (id_suite, id_tipo_suite, disponivel, nome, valor) VALUES (17, 29, true, 'Quarto 01', 800);
INSERT INTO public.suite (id_suite, id_tipo_suite, disponivel, nome, valor) VALUES (18, 30, true, 'Quarto 02', 450);
INSERT INTO public.suite (id_suite, id_tipo_suite, disponivel, nome, valor) VALUES (19, 31, true, 'Quarto 03', 550);


--
-- TOC entry 3438 (class 0 OID 16690)
-- Dependencies: 232
-- Data for Name: tipo_suite; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tipo_suite (id_tipo_suite, descricao) VALUES (29, 'Deluxe');
INSERT INTO public.tipo_suite (id_tipo_suite, descricao) VALUES (30, 'Standard');
INSERT INTO public.tipo_suite (id_tipo_suite, descricao) VALUES (31, 'Master');


--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 216
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.cliente_id_cliente_seq', 1, false);


--
-- TOC entry 3463 (class 0 OID 0)
-- Dependencies: 218
-- Name: funcionario_id_funcionario_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.funcionario_id_funcionario_seq', 1, false);


--
-- TOC entry 3464 (class 0 OID 0)
-- Dependencies: 220
-- Name: hospedagem_id_hospedagem_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.hospedagem_id_hospedagem_seq', 1, false);


--
-- TOC entry 3465 (class 0 OID 0)
-- Dependencies: 222
-- Name: registro_de_servicos_id_registro_servicos_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.registro_de_servicos_id_registro_servicos_seq', 1, false);


--
-- TOC entry 3466 (class 0 OID 0)
-- Dependencies: 224
-- Name: suite_id_suite_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.suite_id_suite_seq', 1, false);


--
-- TOC entry 3467 (class 0 OID 0)
-- Dependencies: 226
-- Name: tipo_suite_id_tipo_suite_seq; Type: SEQUENCE SET; Schema: hotel; Owner: postgres
--

SELECT pg_catalog.setval('hotel.tipo_suite_id_tipo_suite_seq', 1, false);


--
-- TOC entry 3468 (class 0 OID 0)
-- Dependencies: 227
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 19, true);


--
-- TOC entry 3469 (class 0 OID 0)
-- Dependencies: 229
-- Name: funcionario_id_funcionario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.funcionario_id_funcionario_seq', 44, true);


--
-- TOC entry 3470 (class 0 OID 0)
-- Dependencies: 235
-- Name: hospedagem_id_hospedagem_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hospedagem_id_hospedagem_seq', 18, true);


--
-- TOC entry 3471 (class 0 OID 0)
-- Dependencies: 237
-- Name: registro_de_servicos_id_registro_servicos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.registro_de_servicos_id_registro_servicos_seq', 3, true);


--
-- TOC entry 3472 (class 0 OID 0)
-- Dependencies: 233
-- Name: suite_id_suite_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.suite_id_suite_seq', 19, true);


--
-- TOC entry 3473 (class 0 OID 0)
-- Dependencies: 231
-- Name: tipo_suite_id_tipo_suite_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_suite_id_tipo_suite_seq', 31, true);


--
-- TOC entry 3246 (class 2606 OID 16565)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 3248 (class 2606 OID 16567)
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id_funcionario);


--
-- TOC entry 3250 (class 2606 OID 16569)
-- Name: hospedagem hospedagem_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.hospedagem
    ADD CONSTRAINT hospedagem_pkey PRIMARY KEY (id_hospedagem);


--
-- TOC entry 3252 (class 2606 OID 16571)
-- Name: registro_de_servicos registro_de_servicos_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.registro_de_servicos
    ADD CONSTRAINT registro_de_servicos_pkey PRIMARY KEY (id_registro_servicos);


--
-- TOC entry 3254 (class 2606 OID 16573)
-- Name: suite suite_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.suite
    ADD CONSTRAINT suite_pkey PRIMARY KEY (id_suite);


--
-- TOC entry 3256 (class 2606 OID 16575)
-- Name: tipo_suite tipo_suite_pkey; Type: CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.tipo_suite
    ADD CONSTRAINT tipo_suite_pkey PRIMARY KEY (id_tipo_suite);


--
-- TOC entry 3258 (class 2606 OID 16679)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 3260 (class 2606 OID 16688)
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id_funcionario);


--
-- TOC entry 3266 (class 2606 OID 16718)
-- Name: hospedagem hospedagem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospedagem
    ADD CONSTRAINT hospedagem_pkey PRIMARY KEY (id_hospedagem);


--
-- TOC entry 3268 (class 2606 OID 16742)
-- Name: registro_de_servicos registro_de_servicos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.registro_de_servicos
    ADD CONSTRAINT registro_de_servicos_pkey PRIMARY KEY (id_registro_servicos);


--
-- TOC entry 3264 (class 2606 OID 16704)
-- Name: suite suite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suite
    ADD CONSTRAINT suite_pkey PRIMARY KEY (id_suite);


--
-- TOC entry 3262 (class 2606 OID 16697)
-- Name: tipo_suite tipo_suite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_suite
    ADD CONSTRAINT tipo_suite_pkey PRIMARY KEY (id_tipo_suite);


--
-- TOC entry 3269 (class 2606 OID 16576)
-- Name: hospedagem foreign_key_cliente_hospedagem; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.hospedagem
    ADD CONSTRAINT foreign_key_cliente_hospedagem FOREIGN KEY (id_cliente) REFERENCES hotel.cliente(id_cliente) ON DELETE RESTRICT NOT VALID;


--
-- TOC entry 3270 (class 2606 OID 16581)
-- Name: hospedagem foreign_key_funcionario_hospedagem; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.hospedagem
    ADD CONSTRAINT foreign_key_funcionario_hospedagem FOREIGN KEY (id_funcionario) REFERENCES hotel.funcionario(id_funcionario) ON DELETE RESTRICT;


--
-- TOC entry 3272 (class 2606 OID 16586)
-- Name: registro_de_servicos foreign_key_hospedagem_registro; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.registro_de_servicos
    ADD CONSTRAINT foreign_key_hospedagem_registro FOREIGN KEY (id_hospedagem) REFERENCES hotel.hospedagem(id_hospedagem);


--
-- TOC entry 3271 (class 2606 OID 16591)
-- Name: hospedagem foreign_key_suite_hospedagem; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.hospedagem
    ADD CONSTRAINT foreign_key_suite_hospedagem FOREIGN KEY (id_suite) REFERENCES hotel.suite(id_suite) NOT VALID;


--
-- TOC entry 3273 (class 2606 OID 16596)
-- Name: suite foreign_key_tiposuite_suite; Type: FK CONSTRAINT; Schema: hotel; Owner: postgres
--

ALTER TABLE ONLY hotel.suite
    ADD CONSTRAINT foreign_key_tiposuite_suite FOREIGN KEY (id_tipo_suite) REFERENCES hotel.tipo_suite(id_tipo_suite);


--
-- TOC entry 3275 (class 2606 OID 16724)
-- Name: hospedagem hospedagem_id_cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospedagem
    ADD CONSTRAINT hospedagem_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- TOC entry 3276 (class 2606 OID 16729)
-- Name: hospedagem hospedagem_id_suite_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospedagem
    ADD CONSTRAINT hospedagem_id_suite_fkey FOREIGN KEY (id_suite) REFERENCES public.suite(id_suite);


--
-- TOC entry 3277 (class 2606 OID 16743)
-- Name: registro_de_servicos registro_de_servicos_id_hospedagem_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.registro_de_servicos
    ADD CONSTRAINT registro_de_servicos_id_hospedagem_fkey FOREIGN KEY (id_hospedagem) REFERENCES public.hospedagem(id_hospedagem);


--
-- TOC entry 3274 (class 2606 OID 16705)
-- Name: suite suite_id_tipo_suite_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suite
    ADD CONSTRAINT suite_id_tipo_suite_fkey FOREIGN KEY (id_tipo_suite) REFERENCES public.tipo_suite(id_tipo_suite);


-- Completed on 2023-01-20 03:15:03

--
-- PostgreSQL database dump complete
--

