CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(200),
    PRIMARY KEY(id)
);

INSERT INTO usuario (id, nome, email) VALUES (1, 'Jp Reis', 'jpreis@email.com');
INSERT INTO usuario (id, nome, email) VALUES (2, 'Lana KMF', 'lanakmf@email.com');