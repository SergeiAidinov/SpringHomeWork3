--liquibase formatted sql
--changeset sergei:73cae835-c615-4337-83e8-33baa165efff

ALTER TABLE link_product_category ADD CONSTRAINT fk_category
FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE RESTRICT;

--rollback DROP FOREIGN KEY fk_category;