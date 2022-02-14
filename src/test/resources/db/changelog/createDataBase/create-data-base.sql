--liquibase formatted sql
--changeset sergei:3ed1314a-67c5-4c33-ab30-d0ae063b6290

CREATE DATABASE IF NOT EXISTS hw4;
USE DATABASE hw4;

--rollback DROP DATABASE hw4;