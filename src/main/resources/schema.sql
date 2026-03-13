DROP TABLE IF EXISTS proposal_specific_objectives;
DROP TABLE IF EXISTS proposal_students;
DROP TABLE IF EXISTS proposals;
DROP TABLE IF EXISTS acceptance_letters;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
	id BIGINT PRIMARY KEY,
	name_departments VARCHAR(150),
	city VARCHAR(120),
	principal_activity VARCHAR(255)
);

CREATE TABLE students (
	id BIGINT PRIMARY KEY,
	university_id BIGINT,
	name_student VARCHAR(150),
	email VARCHAR(180),
	career VARCHAR(150),
	city_expedition VARCHAR(120)
);

CREATE TABLE acceptance_letters (
	id BIGINT PRIMARY KEY,
	company_name VARCHAR(180),
	role_advisor VARCHAR(150),
	total_hours INT,
	contract_number VARCHAR(100),
	department_id BIGINT,
	CONSTRAINT fk_acceptance_department
		FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE proposals (
	id BIGINT PRIMARY KEY,
	proposal_type VARCHAR(20) NOT NULL,
	state_proposal VARCHAR(40) NOT NULL DEFAULT 'FORMULATED',
	title VARCHAR(255),
	general_objective VARCHAR(1000),
	contributions VARCHAR(1200),
	estimated_time VARCHAR(120),
	delivery_conditions VARCHAR(1000),
	required_resources VARCHAR(1000),
	funding_sources VARCHAR(500),
	observations VARCHAR(1000),
	university_director_name VARCHAR(180),
	company_advisor_name VARCHAR(180),
	acceptance_letter_id BIGINT,
	CONSTRAINT chk_proposal_type
		CHECK (proposal_type IN ('RESEARCH', 'PRACTICE')),
	CONSTRAINT chk_proposal_state
		CHECK (state_proposal IN ('FORMULATED', 'IN_EVALUATION', 'FORMULATED_WITH_OBSERVATIONS', 'APPROVED', 'NOT_APPROVED')),
	CONSTRAINT fk_proposal_acceptance_letter
		FOREIGN KEY (acceptance_letter_id) REFERENCES acceptance_letters(id),
	CONSTRAINT uq_proposal_acceptance_letter
		UNIQUE (acceptance_letter_id)
);

CREATE TABLE proposal_students (
	proposal_id BIGINT NOT NULL,
	student_id BIGINT NOT NULL,
	PRIMARY KEY (proposal_id, student_id),
	CONSTRAINT fk_proposal_students_proposal
		FOREIGN KEY (proposal_id) REFERENCES proposals(id) ON DELETE CASCADE,
	CONSTRAINT fk_proposal_students_student
		FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE proposal_specific_objectives (
	proposal_id BIGINT NOT NULL,
	objective_order INT NOT NULL,
	objective_text VARCHAR(1000) NOT NULL,
	PRIMARY KEY (proposal_id, objective_order),
	CONSTRAINT fk_specific_objective_proposal
		FOREIGN KEY (proposal_id) REFERENCES proposals(id) ON DELETE CASCADE
);
