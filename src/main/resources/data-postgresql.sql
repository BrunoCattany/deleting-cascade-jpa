---------------- Resumo do Cenário:

-- A pessoa 1 (Aurélio) possui: 3 treinos e 1 frequência.
-- A pessoa 2 (Bruno)   possui: 2 treinos e 3 frequências.
-- A pessoa 3 (Carlos)  possui: 1 treino  e nenhuma frequência.
-- A pessoa 4 (José)    possui: 2 treinos e nenhuma frequência.

--------------------------------------------

INSERT INTO turma
 (nome)
VALUES
 ('Turma A'),
 ('Turma B'),
 ('Turma C')
;

--------------------------------------------

INSERT INTO pessoa
 (nome, cpf, turma_id)
VALUES
 ('Aurélio', 111111111, 1),
 (  'Bruno', 111111112, 1),
 ( 'Carlos', 111111113, 3),
 (   'José', 111111114, 3)
;

--------------------------------------------

INSERT INTO frequencia
 (pessoa_id, data_registro)
VALUES
 (1, '25/10/2018 20:30:00'),
 (2, '26/10/2018 20:30:00'),
 (2, '27/10/2018 20:30:00'),
 (2, '28/10/2018 20:30:00')
;

--------------------------------------------

INSERT INTO academia
 (nome, endereco)
VALUES
 (        'Fit', 'Rua A'),
 ('HealthyLife', 'Rua B'),
 (    'Workout', 'Rua C')
;

--------------------------------------------

INSERT INTO treino
 (nome, pessoa_id, academia_origem_id)
VALUES
 (         'Treino Leve', 1, 2),
 (     'Treino Moderado', 1, 2),
 ('Treino Intermediário', 1, 2),

 (   'Treino Muito Leve', 2, 3),
 ( 'Treino Profissional', 2, 3),

 (    'Treino de Atleta', 3, 3),

 (   'Treino de Corrida', 4, 3),
 (       'Treino Sprint', 4, 3)
;

--------------------------------------------

INSERT INTO programacao
 (data_execucao, treino_id)
VALUES
 ('25/10/2018 20:30:00', 1),
 ('26/10/2018 20:30:00', 4),
 ('27/10/2018 20:30:00', 2),
 ('28/10/2018 20:30:00', 4)
;

--------------------------------------------

INSERT INTO exercicio
 (nome)
VALUES
 ( 'Supino Reto'),
 ( 'Polichinelo'),
 ( 'Agachamento'),
 ('Rosca Direta')
;

--------------------------------------------

INSERT INTO treino_exercicio
 (treino_id, exercicio_id, repeticao, serie)
VALUES
 (1, 1, 10, 3),
 (1, 2, 10, 3),
 (1, 3, 10, 3),
 (2, 1, 10, 3),
 (2, 4, 10, 3),
 (3, 1, 15, 3),
 (4, 1, 15, 3),
 (4, 2, 15, 3),
 (5, 2, 15, 3),
 (6, 2, 15, 3),
 (7, 2, 15, 3),
 (8, 2, 15, 3)
;

--------------------------------------------