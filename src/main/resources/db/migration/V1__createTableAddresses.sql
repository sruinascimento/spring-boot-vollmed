create table addresses
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    street       VARCHAR(100) NOT NULL,
    number       VARCHAR(10)  NOT NULL,
    complement   VARCHAR(100),
    neighborhood VARCHAR(100) NOT NULL,
    city         VARCHAR(100) NOT NULL,
    state        VARCHAR(100) NOT NULL,
    zip_code     VARCHAR(30)  NOT NULL
);