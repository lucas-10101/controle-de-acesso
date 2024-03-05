INSERT INTO tenants (name, domain, schema_dbms) VALUES ('Locatario de teste', 'teste.local', 'public')

INSERT INTO users (email, tenant_id) VALUES ('teste@teste.local', 1)

INSERT INTO groups (name, tenant_id) VALUES ('grupo 1', 1)
INSERT INTO groups (name, tenant_id) VALUES ('grupo 2', 1)
INSERT INTO groups (name, tenant_id) VALUES ('grupo 3', 1)

INSERT INTO roles (name, role) VALUES ('Application Role A', 'ROLE_A')
INSERT INTO roles (name, role) VALUES ('Application Role B', 'ROLE_B')
INSERT INTO roles (name, role) VALUES ('Application Role C', 'ROLE_C')

INSERT INTO user_groups (group_id, user_id) VALUES (1, 1)
INSERT INTO user_groups (group_id, user_id) VALUES (2, 1)
INSERT INTO user_groups (group_id, user_id) VALUES (3, 1)

INSERT INTO user_roles (role_id, user_id) VALUES (1, 1)
INSERT INTO user_roles (role_id, user_id) VALUES (2, 1)
INSERT INTO user_roles (role_id, user_id) VALUES (3, 1)

INSERT INTO group_roles (role_id, group_id) VALUES (1, 1)
INSERT INTO group_roles (role_id, group_id) VALUES (2, 2)
INSERT INTO group_roles (role_id, group_id) VALUES (3, 3)

INSERT INTO user_group_roles (role_id, group_id, user_id) VALUES (1, 1, 1)
INSERT INTO user_group_roles (role_id, group_id, user_id) VALUES (2, 2, 1)
INSERT INTO user_group_roles (role_id, group_id, user_id) VALUES (3, 3, 1)