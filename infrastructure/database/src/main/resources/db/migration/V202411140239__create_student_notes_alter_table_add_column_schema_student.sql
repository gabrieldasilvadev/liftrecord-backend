CREATE TABLE IF NOT EXISTS student_notes (
    id VARCHAR (26) PRIMARY KEY,
    student_id VARCHAR(26) NOT NULL UNIQUE,
    note VARCHAR(255) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE student
ADD COLUMN goal VARCHAR(100) NOT NULL,
ADD COLUMN enrollment_date DATE NOT NULL,
ADD COLUMN subscription_end_date DATE,
ADD COLUMN gym_registration_status VARCHAR(25) NOT NULL,
ADD COLUMN medical_conditions VARCHAR(255),
ADD CONSTRAINT chk_student_gym_registration_status CHECK (gym_registration_status IN (
    'REGISTERED',
    'WITHOUT_REGISTRATION',
    'PENDING_CANCELLATION'
));
