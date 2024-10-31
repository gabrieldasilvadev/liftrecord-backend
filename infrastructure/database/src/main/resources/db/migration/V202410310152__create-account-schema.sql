CREATE TABLE IF NOT EXISTS account (
    id VARCHAR(26) PRIMARY KEY,
    name VARCHAR(85) NOT NULL,
    email VARCHAR(100) NULL UNIQUE,
    cellphone VARCHAR(20) NULL UNIQUE,
    password VARCHAR(255) NULL,
    status VARCHAR(25) NOT NULL,
    CONSTRAINT chk_student_status CHECK (status IN ('ACTIVE', 'INACTIVE', 'PENDING_ACTIVATION')),
    address_id VARCHAR(26),
    FOREIGN KEY (address_id) REFERENCES address(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL
);

-- create indexes
CREATE INDEX idx_account_email ON account(email);
CREATE INDEX idx_account_status ON account(status);