-- CREATE TABLE resposta (
--     id BIGINT NOT NULL AUTO_INCREMENT,
--     usuario_id BIGINT NOT NULL,
--     datacriacao DATETIME NOT NULL,
--     mensagem VARCHAR(500) NOT NULL,
--     id_topico BIGINT NOT NULL,
--     solucao BOOLEAN NOT NULL,
--     PRIMARY KEY(id),
--     FOREIGN KEY(id_topico) REFERENCES topico(id),
--     FOREIGN KEY(usuario_id) REFERENCES usuario(id)
-- )
create table resposta(
     id bigint not null auto_increment,
     mensagem varchar(300) not null,
     data_criacao datetime not null,
     topico_id bigint not null,
     autor_id bigint not null,
     solucao int(1) not null,
     primary key(id),
     foreign key(topico_id) references topico(id),
     foreign key(autor_id) references usuario(id)
);