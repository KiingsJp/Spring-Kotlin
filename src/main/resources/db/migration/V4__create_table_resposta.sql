CREATE TABLE resposta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    usuario_id BIGINT NOT NULL,
    datacriacao DATETIME NOT NULL,
    mensagem VARCHAR(500) NOT NULL,
    id_topico BIGINT NOT NULL,
    solucao BOOLEAN NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_topico) REFERENCES topico(id),
    FOREIGN KEY(usuario_id) REFERENCES usuario(id)
)