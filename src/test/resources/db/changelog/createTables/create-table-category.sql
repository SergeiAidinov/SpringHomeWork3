--liquibase formatted sql
--changeset sergei:8ec5c873-17b1-4f83-8b39-5f308410509d

CREATE TABLE category(
id BIGINT PRIMARY KEY AUTO_INCREMENT, 
description VARCHAR(25) UNIQUE NOT NULL

);

--rollback DROP TABLE category;