CREATE TABLE topico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(500) NOT NULL,
    data_criacao DATETIME NOT NULL,
    curso_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(curso_id) REFERENCES curso(id),
    FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);
