ALTER TABLE student
DROP CONSTRAINT chk_student_gym_registration_status;

ALTER TABLE student
ADD CONSTRAINT chk_student_gym_registration_status
CHECK (gym_registration_status::text = ANY (ARRAY['REGISTERED'::character varying,
                                                'WITHOUT_REGISTRATION'::character varying,
                                                'PENDING_CANCELLATION'::character varying,
                                                'PENDING_ACTIVATION'::character varying]::text[]));