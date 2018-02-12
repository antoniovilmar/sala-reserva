CREATE TABLE reserva (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email_responsavel VARCHAR(200) NOT NULL,
  data_hora_inicio DATETIME,
  data_hora_fim DATETIME,
  sala VARCHAR(200) NOT NULL,
  PRIMARY KEY (id));