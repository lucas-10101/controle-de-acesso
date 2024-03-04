INSERT INTO locatarios (nome, dominio, esquema_sgbd) VALUES ('Locatario de teste', 'teste.local', 'public')

INSERT INTO usuarios (email, id_locatario) VALUES ('teste@teste.local', 1)

INSERT INTO grupos (nome, id_locatario) VALUES ('grupo 1', 1)
INSERT INTO grupos (nome, id_locatario) VALUES ('grupo 2', 1)
INSERT INTO grupos (nome, id_locatario) VALUES ('grupo 3', 1)

INSERT INTO permissoes (nome) VALUES ('ROLE_A')
INSERT INTO permissoes (nome) VALUES ('ROLE_B')
INSERT INTO permissoes (nome) VALUES ('ROLE_C')

INSERT INTO grupo_usuario (id_grupo, id_usuario) VALUES (1, 1)
INSERT INTO grupo_usuario (id_grupo, id_usuario) VALUES (2, 1)
INSERT INTO grupo_usuario (id_grupo, id_usuario) VALUES (3, 1)

INSERT INTO permissao_usuario (id_permissao, id_usuario) VALUES (1, 1)
INSERT INTO permissao_usuario (id_permissao, id_usuario) VALUES (2, 1)
INSERT INTO permissao_usuario (id_permissao, id_usuario) VALUES (3, 1)

INSERT INTO permissao_grupo (id_permissao, id_grupo) VALUES (1, 1)
INSERT INTO permissao_grupo (id_permissao, id_grupo) VALUES (2, 2)
INSERT INTO permissao_grupo (id_permissao, id_grupo) VALUES (3, 3)

INSERT INTO permissao_grupo_usuario (id_permissao, id_grupo, id_usuario) VALUES (1, 1, 1)
INSERT INTO permissao_grupo_usuario (id_permissao, id_grupo, id_usuario) VALUES (2, 2, 1)
INSERT INTO permissao_grupo_usuario (id_permissao, id_grupo, id_usuario) VALUES (3, 3, 1)