---------------- Sequência Lógica de Criação:

-- 1. turma
-- 2. pessoa
-- 3. academia
-- 4. treino
-- 5. programacao
-- 6. frequencia
-- 7. exercicio
-- 8. treino_exercicio

--------------------------------------------

DROP TABLE IF EXISTS turma CASCADE;

CREATE TABLE turma (
    id     INTEGER NOT NULL,
  nome VARCHAR(11) NOT NULL,

  CONSTRAINT turma_pkey PRIMARY KEY (id)
);

--------------------------------------------

DROP TABLE IF EXISTS pessoa CASCADE;

CREATE TABLE pessoa (
        id     INTEGER NOT NULL,
       cpf VARCHAR(11) NOT NULL,
      nome VARCHAR(60) NOT NULL,
  turma_id     INTEGER NOT NULL,

  CONSTRAINT  pessoa_pkey PRIMARY KEY       (id),
  CONSTRAINT pessoa_turma FOREIGN KEY (turma_id) REFERENCES turma(id)
);

--------------------------------------------

DROP TABLE IF EXISTS academia CASCADE;

CREATE TABLE academia (
        id     INTEGER NOT NULL,
      nome VARCHAR(30) NOT NULL,
  endereco VARCHAR(50) NOT NULL,

 CONSTRAINT academia_pkey PRIMARY KEY (id)
);

--------------------------------------------

DROP TABLE IF EXISTS treino CASCADE;

CREATE TABLE treino (
                  id     INTEGER NOT NULL,
                nome VARCHAR(30) NOT NULL,
           pessoa_id     INTEGER,
  academia_origem_id     INTEGER NOT NULL,

  CONSTRAINT        treino_pkey  PRIMARY KEY                 (id),
  CONSTRAINT   treino_pessoa_fk  FOREIGN KEY          (pessoa_id) REFERENCES   pessoa(id),
  CONSTRAINT treino_academia_fk  FOREIGN KEY (academia_origem_id) REFERENCES academia(id)
);

--------------------------------------------

DROP TABLE IF EXISTS programacao CASCADE;

CREATE TABLE programacao (
                     id INTEGER NOT NULL,
          data_execucao TIMESTAMP,
              treino_id INTEGER NOT NULL,

  CONSTRAINT      programacao_pkey PRIMARY KEY                    (id),
  CONSTRAINT programacao_treino_fk FOREIGN KEY             (treino_id) REFERENCES treino(id)
);

--------------------------------------------

DROP TABLE IF EXISTS frequencia CASCADE;

CREATE TABLE frequencia (
            id   INTEGER NOT NULL,
     pessoa_id   INTEGER,
 data_registro TIMESTAMP,

  CONSTRAINT frequencia_pkey      PRIMARY KEY        (id),
  CONSTRAINT frequencia_pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

--------------------------------------------

DROP TABLE IF EXISTS exercicio CASCADE;

CREATE TABLE exercicio (
         id     INTEGER NOT NULL,
       nome VARCHAR(30) NOT NULL,

  CONSTRAINT exercicio_pkey PRIMARY KEY (id)
);

--------------------------------------------

DROP TABLE IF EXISTS treino_exercicio CASCADE;

CREATE TABLE treino_exercicio (
            id INTEGER NOT NULL,
     treino_id INTEGER NOT NULL,
  exercicio_id INTEGER NOT NULL,
         serie INTEGER NOT NULL,
     repeticao INTEGER NOT NULL,

  CONSTRAINT treino_exercicio_pkey PRIMARY KEY           (id),
  CONSTRAINT             treino_fk FOREIGN KEY    (treino_id) REFERENCES    treino(id),
  CONSTRAINT          exercicio_fk FOREIGN KEY (exercicio_id) REFERENCES exercicio(id)
);

--------------------------------------------