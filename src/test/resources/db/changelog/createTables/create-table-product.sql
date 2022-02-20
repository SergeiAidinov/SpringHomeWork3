--liquibase formatted sql
--changeset sergei:3fa68a7a-87a0-4010-a8f3-5320c5e03c54

CREATE TABLE product(
id BIGINT AUTO_INCREMENT, 
name VARCHAR(45) UNIQUE NOT NULL,
price SMALLINT NOT NULL,
PRIMARY KEY (id)
);

--rollback DROP TABLE product;