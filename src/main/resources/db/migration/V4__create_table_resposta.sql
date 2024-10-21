CREATE TABLE RESPOSTA (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    USUARIO_ID BIGINT NOT NULL,
    DATACRIACAO DATETIME NOT NULL,
    MENSAGEM VARCHAR(500) NOT NULL,
    ID_TOPICO BIGINT NOT NULL,
    SOLUCAO BOOLEAN NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(ID_TOPICO) REFERENCES TOPICO(ID),
    FOREIGN KEY(USUARIO_ID) REFERENCES USUARIO(ID)
)