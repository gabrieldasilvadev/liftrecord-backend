CREATE TABLE IF NOT EXISTS academy(
    id VARCHAR(26) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(14) UNIQUE NOT NULL,
    cellphone VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    address_id VARCHAR(26),
    FOREIGN KEY (address_id) REFERENCES address(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS personal_trainer(
    id VARCHAR(26) PRIMARY KEY,
    account_id VARCHAR(26) UNIQUE NOT NULL,
    address_id VARCHAR(26) NOT NULL,
    education VARCHAR(80) NOT NULL,
    years_of_experience INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(id),
    FOREIGN KEY (address_id) REFERENCES address(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL
);