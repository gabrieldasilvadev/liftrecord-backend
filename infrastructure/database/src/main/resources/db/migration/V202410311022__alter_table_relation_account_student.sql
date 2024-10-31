ALTER TABLE student
ADD COLUMN account_id VARCHAR(26) UNIQUE,
ADD CONSTRAINT fk_account
FOREIGN KEY (account_id) REFERENCES account(id);
