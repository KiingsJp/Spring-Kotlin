CREATE TABLE curso (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    categoria VARCHAR(100),
    PRIMARY KEY(id)
);

INSERT INTO curso (id, nome, categoria) VALUES (1, 'Kotlin & Spring', 'Programação');
INSERT INTO curso (id, nome, categoria) VALUES (2, 'Banco de Dados', 'Programação');
INSERT INTO curso (id, NOME, categoria) VALUES (3, 'Java', 'Programação');