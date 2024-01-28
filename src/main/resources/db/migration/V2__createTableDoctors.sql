CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    crm VARCHAR(25) NOT NULL NOT NULL,
    specialty VARCHAR(50),
    address_id BIGINT NOT NULL,
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);