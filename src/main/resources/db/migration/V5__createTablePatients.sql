CREATE TABLE patients
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100)        NOT NULL,
    email      VARCHAR(100) UNIQUE NOT NULL,
    phone      VARCHAR(25)         NOT NULL,
    cpf        VARCHAR(11) UNIQUE  NOT NULL,
    address_id BIGINT              NOT NULL,
    FOREIGN KEY (address_id) REFERENCES addresses (id)
);