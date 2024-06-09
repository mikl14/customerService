create schema IF NOT EXISTS mtsbank;

CREATE TABLE IF NOT EXISTS mtsbank.bank_account (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    sum bigint
);

CREATE TABLE IF NOT EXISTS mtsbank.bank_user (
    id bigint NOT NULL,
    password character varying(255),
    username character varying(255),
    bank_account_id bigint
);
CREATE TABLE IF NOT EXISTS mtsbank.bank_contribution (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    closed_date date,
    contribution_account character varying(255),
    open_date date,
    pay_period date,
    period character varying(255),
    persent integer NOT NULL,
    product_code character varying(255),
    return_code character varying(255),
    sum bigint,
    bank_user bigint
);


CREATE TABLE IF NOT EXISTS mtsbank.contribution_contribution_type (
   id_contribution bigint NOT NULL,
   id_contribution_type bigint
);


CREATE TABLE IF NOT EXISTS mtsbank.contribution_type (
    id BIGINT PRIMARY KEY,
    type character varying(255)
);

CREATE TABLE IF NOT EXISTS mtsbank.bank_operation (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    date date,
    sum numeric(19,2),
    type character varying(255),
    bank_account bigint
);

CREATE TABLE IF NOT EXISTS mtsbank.role (
     id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
     role_name character varying(255)
);

CREATE TABLE IF NOT EXISTS mtsbank.user_roles (
     user_id BIGINT NOT NULL,
     role_id BIGINT NOT NULL
);
