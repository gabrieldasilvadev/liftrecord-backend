ALTER TABLE account
RENAME COLUMN name TO first_name;

ALTER TABLE account
ADD COLUMN last_name VARCHAR(100) NOT NULL,
ADD COLUMN biological_sex VARCHAR(10) NOT NULL,
ADD COLUMN gender VARCHAR(60) NOT NULL,
ADD CONSTRAINT check_biological_sex CHECK (biological_sex IN ('MALE', 'FEMALE'));
