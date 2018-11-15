---------------- Resumo do Cenário:

-- A pessoa 1 (Aurélio) possui: 3 treinos e 1 frequência.
-- A pessoa 2 (Bruno) possui: 1 treino e 3 frequências.
-- A pessoa 3 (Carlos) não possui treinos e nem frequências.

--------------------------------------------

INSERT INTO turma
 (id, nome)
VALUES
 (1, 'Turma A'),
 (2, 'Turma B'),
 (3, 'Turma C')
;

--------------------------------------------

INSERT INTO pessoa
 (id, nome, cpf, turma_id)
VALUES
 (1, 'Aurélio', 111111111, 1),
 (2,   'Bruno', 111111112, 1),
 (3,  'Carlos', 111111113, 3)
;

--------------------------------------------

INSERT INTO frequencia
 (id, pessoa_id, data_registro)
VALUES
 (1, 1, '25/10/2018 20:30:00'),
 (2, 2, '26/10/2018 20:30:00'),
 (3, 2, '27/10/2018 20:30:00'),
 (4, 2, '28/10/2018 20:30:00')
;

--------------------------------------------

INSERT INTO academia
 (id, nome, endereco)
VALUES
 (1,         'Fit', 'Rua A'),
 (2, 'HealthyLife', 'Rua B'),
 (3,     'Workout', 'Rua C')
;

--------------------------------------------

INSERT INTO treino
 (id, nome, pessoa_id, academia_origem_id)
VALUES
 (1,          'Treino Leve', 1, 2),
 (2,      'Treino Moderado', 1, 2),
 (3, 'Treino Intermediário', 1, 2),
 (4,  'Treino Profissional', 2, 3)
;

--------------------------------------------

INSERT INTO programacao
 (id, data_execucao, treino_id)
VALUES
 (1, '25/10/2018 20:30:00', 1),
 (2, '26/10/2018 20:30:00', 4),
 (3, '27/10/2018 20:30:00', 2),
 (4, '28/10/2018 20:30:00', 4)
;

--------------------------------------------

INSERT INTO exercicio
 (id, nome)
VALUES
 (1,  'Supino Reto'),
 (2,  'Polichinelo'),
 (3,  'Agachamento'),
 (4, 'Rosca Direta')
;

--------------------------------------------

INSERT INTO treino_exercicio
 (id, treino_id, exercicio_id, repeticao, serie)
VALUES
 (1, 1, 1, 10, 3),
 (2, 1, 2, 10, 3),
 (3, 1, 3, 10, 3),
 (4, 2, 1, 10, 3),
 (5, 2, 4, 10, 3),
 (6, 3, 1, 15, 3),
 (7, 4, 1, 15, 3),
 (8, 4, 2, 15, 3)
;

--------------------------------------------