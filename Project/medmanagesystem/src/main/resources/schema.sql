CREATE TABLE IF NOT EXISTS Pessoa(
   pessoacc      INTEGER  NOT NULL PRIMARY KEY 
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
  ,profissional    INTEGER  NOT NULL
  ,motivo    VARCHAR(32) NOT NULL
  ,data      DATE  NOT NULL
  ,anotacoes VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS Profissional(
    id_profissional      INTEGER  NOT NULL PRIMARY KEY 
  ,profissional_cc  INTEGER  NOT NULL
  , id_area INTEGER 
  ,pswd VARCHAR(50) NOT NULL
  ,ismedic BOOLEAN NOT NULL
) 

CREATE TABLE IF NOT EXISTS Paciente(
    id      INTEGER  NOT NULL PRIMARY KEY 
  ,paciente_cc  INTEGER  NOT NULL
) 



   {    "id":1,
        "paciente_cc":84563294,
   },
