CREATE TABLE IF NOT EXISTS public.employees
(
    salary double precision,
    employee_id bigint NOT NULL DEFAULT nextval('employees_employee_id_seq'::regclass),
    hotel_id bigint,
    role_id bigint,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    passport_info character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT employees_pkey PRIMARY KEY (employee_id),
    CONSTRAINT employee_email_unique UNIQUE (email),
    CONSTRAINT employee_passport_info_unique UNIQUE (passport_info)
);

CREATE TABLE IF NOT EXISTS public.guests
(
    guest_id bigint NOT NULL DEFAULT nextval('guests_guest_id_seq'::regclass),
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    passport_info character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT guests_pkey PRIMARY KEY (guest_id),
    CONSTRAINT guest_email_unique UNIQUE (email),
    CONSTRAINT guest_passport_info_unique UNIQUE (passport_info)
);

CREATE TABLE IF NOT EXISTS public.guests_registration
(
    guests_guest_id bigint NOT NULL,
    registration_registration_id bigint NOT NULL,
    guest_guest_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.hotel
(
    hotel_id bigint NOT NULL DEFAULT nextval('hotel_hotel_id_seq'::regclass),
    registration_id bigint,
    address character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    hotel_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    region character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id)
);

CREATE TABLE IF NOT EXISTS public.hotel_employees
(
    hotel_hotel_id bigint NOT NULL,
    employees_employee_id bigint NOT NULL,
    CONSTRAINT uk_121hdbslphn6ldbv0qq8gmy2 UNIQUE (employees_employee_id)
);

CREATE TABLE IF NOT EXISTS public.regestration
(
    regestration_id integer NOT NULL DEFAULT nextval('regestration_regestration_id_seq'::regclass),
    guest_id integer,
    room_id integer,
    ts_check_in timestamp with time zone,
    ts_check_out timestamp with time zone,
    CONSTRAINT regestration_pkey PRIMARY KEY (regestration_id)
);

CREATE TABLE IF NOT EXISTS public.registration
(
    guest_id bigint,
    registration_id bigint NOT NULL DEFAULT nextval('registration_registration_id_seq'::regclass),
    room_id bigint NOT NULL,
    ts_check_in timestamp(6) without time zone,
    ts_check_out timestamp(6) without time zone,
    CONSTRAINT registration_pkey PRIMARY KEY (registration_id),
    CONSTRAINT registration_guest_id_key UNIQUE (guest_id),
    CONSTRAINT registration_room_id_key UNIQUE (room_id)
);

CREATE TABLE IF NOT EXISTS public.registration_guests
(
    registration_registration_id bigint NOT NULL,
    guests_guest_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.roles
(
    role_id bigint NOT NULL DEFAULT nextval('roles_role_id_seq'::regclass),
    role_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (role_id)
);

CREATE TABLE IF NOT EXISTS public.rooms
(
    room_capacity integer NOT NULL,
    room_name integer NOT NULL,
    room_price double precision,
    room_id bigint NOT NULL DEFAULT nextval('rooms_room_id_seq'::regclass),
    room_status_id bigint NOT NULL,
    room_type_id bigint NOT NULL,
    CONSTRAINT rooms_pkey PRIMARY KEY (room_id),
    CONSTRAINT room_name_unique UNIQUE (room_name),
    CONSTRAINT rooms_room_status_id_key UNIQUE (room_status_id),
    CONSTRAINT rooms_room_type_id_key UNIQUE (room_type_id)
);

CREATE TABLE IF NOT EXISTS public.rooms_status
(
    room_status boolean NOT NULL,
    room_status_id bigint NOT NULL DEFAULT nextval('rooms_status_room_status_id_seq'::regclass),
    CONSTRAINT rooms_status_pkey PRIMARY KEY (room_status_id)
);

CREATE TABLE IF NOT EXISTS public.rooms_type
(
    room_type_id bigint NOT NULL DEFAULT nextval('rooms_type_room_type_id_seq'::regclass),
    room_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT rooms_type_pkey PRIMARY KEY (room_type_id)
);

ALTER TABLE IF EXISTS public.employees
    ADD CONSTRAINT fkah490190ww1q2a4piuv41hk6e FOREIGN KEY (role_id)
        REFERENCES public.roles (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.employees
    ADD CONSTRAINT fkgciw80auatpgg6axe8hd0s6t FOREIGN KEY (hotel_id)
        REFERENCES public.hotel (hotel_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.hotel
    ADD CONSTRAINT fkqbro3kwfvf52xwirgvqtoxn9t FOREIGN KEY (registration_id)
        REFERENCES public.registration (registration_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.registration
    ADD CONSTRAINT fk68sojgkv83u9i9koj0amtbg93 FOREIGN KEY (room_id)
        REFERENCES public.rooms (room_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS registration_room_id_key
    ON public.registration(room_id);


ALTER TABLE IF EXISTS public.registration
    ADD CONSTRAINT fklo8f23csky9ye9whcn812hqw4 FOREIGN KEY (guest_id)
        REFERENCES public.guests (guest_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS registration_guest_id_key
    ON public.registration(guest_id);


ALTER TABLE IF EXISTS public.rooms
    ADD CONSTRAINT fke5c6xpdwpjoyjr5d6hubmhq9o FOREIGN KEY (room_status_id)
        REFERENCES public.rooms_status (room_status_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS rooms_room_status_id_key
    ON public.rooms(room_status_id);


ALTER TABLE IF EXISTS public.rooms
    ADD CONSTRAINT fknhnlyd1avw7y03dmlkk1bn1q0 FOREIGN KEY (room_type_id)
        REFERENCES public.rooms_type (room_type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS rooms_room_type_id_key
    ON public.rooms(room_type_id);
