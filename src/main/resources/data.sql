INSERT INTO departments (id, name_departments, city, principal_activity) VALUES
(1, 'Departamento de Investigación de Amazon', 'Medellín', 'Investigación en tecnologías de la información'),
(2, 'Departamento de Desarrollo de Microsoft', 'Bogotá', 'Desarrollo de software y aplicaciones'),
(3, 'Departamento de QA de Eficacia', 'Cali', 'Estrategias de calidad en el desarrollo de software');

INSERT INTO students (id, university_id, name_student, email, career, city_expedition) VALUES
(1061709167, 20230001, 'Juan David Vela Coronado', 'juanvela@unicauca.edu.co', 'Ingeniería de Sistemas', 'Popayán'),
(1061709168, 20230002, 'Ana Sofia Arango Yanza', 'anasofia@unicauca.edu.co', 'Ingeniería de Sistemas', 'Bogotá'),
(1061709169, 20230003, 'Carlos Andrés Martínez', 'carlosmartinez@unicauca.edu.co', 'Ingeniería de Sistemas', 'Cali');

INSERT INTO acceptance_letters (id, company_name, role_advisor, total_hours, contract_number, department_id) VALUES
(1, 'Eficacia', 'Practicante de Desarrollo', 960, 'CT-2026-001', 3);

INSERT INTO proposals (
	id,
	proposal_type,
	state_proposal,
	title,
	general_objective,
	contributions,
	estimated_time,
	delivery_conditions,
	required_resources,
	funding_sources,
	observations,
	university_director_name,
	company_advisor_name,
	acceptance_letter_id
) VALUES
(1, 'RESEARCH', 'FORMULATED', 'Sistema de recomendacion academica', 'Disenar un sistema de recomendacion para planes de estudio', 'Mejora en la planeacion academica', '6 meses', 'Entrega de informe y prototipo', 'Acceso a datos historicos y entorno de pruebas', 'Universidad del Cauca', NULL, 'Dra. Maria Perez', NULL, NULL),
(2, 'PRACTICE', 'FORMULATED', 'Automatizacion de pruebas QA', 'Implementar pruebas automatizadas para servicios internos', 'Reduccion de errores en despliegues', '4 meses', 'Entrega de scripts y documentacion', 'Repositorio, CI/CD y ambientes de prueba', 'Empresa receptora', 'Pendiente validacion final', 'Ing. Carlos Ruiz', 'Laura Gomez', 1);

INSERT INTO proposal_students (proposal_id, student_id) VALUES
(1, 1061709167),
(1, 1061709168),
(2, 1061709169);

INSERT INTO proposal_specific_objectives (proposal_id, objective_order, objective_text) VALUES
(1, 1, 'Analizar historicos academicos para identificar patrones de seleccion'),
(1, 2, 'Construir un prototipo de recomendacion con metricas de precision'),
(2, 1, 'Definir escenarios criticos para pruebas automatizadas'),
(2, 2, 'Integrar ejecucion de pruebas en el pipeline de integracion continua');