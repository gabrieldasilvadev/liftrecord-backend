CREATE TABLE address (
    id VARCHAR(26) PRIMARY KEY,
    state VARCHAR(2) NOT NULL,
    city VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    number VARCHAR(10) NOT NULL,
    complement VARCHAR(50) NOT NULL,
    zip_code VARCHAR(8) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE student (
	id VARCHAR(26) PRIMARY KEY,
	cellphone VARCHAR(20) NULL,
	email VARCHAR(100) NULL,
	"name" VARCHAR(85) NULL,
	address_id VARCHAR(26),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NULL DEFAULT NULL,
	FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE body_metrics (
    id VARCHAR(26) PRIMARY KEY,
    weight DOUBLE PRECISION NOT NULL,
    height DOUBLE PRECISION NOT NULL,
    waist_circumference DOUBLE PRECISION NOT NULL,
    abdomen_circumference DOUBLE PRECISION NOT NULL,
    chest_circumference DOUBLE PRECISION NOT NULL,
    arm_circumference DOUBLE PRECISION NOT NULL,
    thigh_circumference DOUBLE PRECISION NOT NULL,
    hips_circumference DOUBLE PRECISION NOT NULL,
    bmi DOUBLE PRECISION NOT NULL,
    basal_metabolic_rate DOUBLE PRECISION NOT NULL,
    is_current BOOLEAN NOT NULL,
    student_id VARCHAR(26) NOT NULL,
    measurement_date DATE NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);

-- Create indexes
CREATE INDEX idx_student_name ON student(name);
CREATE INDEX idx_student_created_at ON student(created_at);
CREATE INDEX idx_body_metrics_is_current ON body_metrics(is_current);
CREATE INDEX idx_body_metrics_measurement_date ON body_metrics(measurement_date);