--liquibase formatted sql
--changeset abed:0001-01
CREATE TABLE IF NOT EXISTS user_tb (
    id integer PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    mobile_number VARCHAR(255)
    );
-- rollback DROP TABLE user_tb;
