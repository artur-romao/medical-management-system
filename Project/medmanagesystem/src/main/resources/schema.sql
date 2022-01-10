CREATE TABLE IF NOT EXISTS Pessoa(
   pessoa_cc      INTEGER  NOT NULL PRIMARY KEY 
  ,nome           VARCHAR(19) NOT NULL
  ,email          VARCHAR(33) NOT NULL
  ,telemovel      INTEGER  NOT NULL
  ,morada         VARCHAR(32) NOT NULL
  ,datanascimento VARCHAR(33)  NOT NULL
);

CREATE TABLE IF NOT EXISTS Area(
   idArea INTEGER  NOT NULL PRIMARY KEY ,
   name   VARCHAR(23) NOT NULL
);

CREATE TABLE IF NOT EXISTS Consulta(
   id        INTEGER  NOT NULL PRIMARY KEY 
  ,paciente  INTEGER  NOT NULL
  ,medico    INTEGER  NOT NULL
  ,motivo    VARCHAR(32) NOT NULL
  ,data      DATE  NOT NULL
  ,anotacoes VARCHAR(30)
);