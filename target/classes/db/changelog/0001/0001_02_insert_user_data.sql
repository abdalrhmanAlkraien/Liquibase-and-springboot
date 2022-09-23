--liquibase formatted sql
--changeset abed:0001-02

INSERT INTO user_tb
(
 first_name,
 last_name,
 mobile_number
)
VALUES
    ('USER_FIRST_A','USER_LAST_A','99625541'),
    ('USER_FIRST_B','USER_LAST_B','99625511'),
    ('USER_FIRST_C','USER_LAST_C','99625555');

-- rollback DELETE FROM product WHERE first_name IN ('USER_FIRST_A', 'USER_FIRST_B', 'USER_FIRST_C');