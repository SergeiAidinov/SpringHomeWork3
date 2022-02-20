--liquibase formatted sql
--changeset sergei:9c935b07-9b21-435c-8ec6-9452951dc316

INSERT INTO category (id, description) VALUES (NULL, 'Book'), (NULL, 'Magasin'), (NULL, 'Stationery');
--rollback DELETE FROM category;