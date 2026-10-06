INSERT INTO tb_category (id, name) VALUES (1, 'Notebooks');
INSERT INTO tb_category (id, name) VALUES (2, 'Celulares');
INSERT INTO tb_category (id, name) VALUES (3, 'Perifericos');
INSERT INTO tb_category (id, name) VALUES (4, 'Monitores');
INSERT INTO tb_category (id, name) VALUES (5, 'Armazenamento');

INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (1, 'Notebook Lenovo IdeaPad 3', 'Notebook para estudos e trabalho.', 2899.90, 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853', 1);
INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (2, 'Samsung Galaxy A55', 'Smartphone com bom desempenho.', 1899.90, 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9', 2);
INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (3, 'Mouse Gamer', 'Mouse gamer com sensor de alta precisao.', 149.90, 'https://images.unsplash.com/photo-1527814050087-3793815479db', 3);
INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (4, 'Teclado Mecanico', 'Teclado mecanico para jogos e produtividade.', 299.90, 'https://images.unsplash.com/photo-1587829741301-dc798b83add3', 3);
INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (5, 'Monitor Gamer 24 Polegadas', 'Monitor Full HD para jogos e trabalho.', 799.90, 'https://images.unsplash.com/photo-1527443224154-c4a3942d3acf', 4);
INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (6, 'SSD NVMe 500GB', 'SSD NVMe de 500GB para armazenamento.', 329.90, 'https://images.unsplash.com/photo-1597872200969-2b65d56bd16b', 5);
INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (7, 'Headset Gamer', 'Headset com microfone para jogos e chamadas.', 199.90, 'https://images.unsplash.com/photo-1599669454699-248893623440', 3);
INSERT INTO tb_product (id, name, description, price, url_image, category_id) VALUES (8, 'Webcam Full HD', 'Webcam Full HD para aulas e reunioes.', 249.90, 'https://images.unsplash.com/photo-1587825140708-dfaf72ae4b04', 3);

INSERT INTO tb_user (id, display_name, username, password, email) VALUES (1, 'Kaio Ribeiro', 'kaio', '$2y$10$tL2pzIMAE5wtvFBmR14LPOO.SeYLnW6itfeLil6kZCjFCYwaeOudy', 'kaio@email.com');
INSERT INTO tb_user (id, display_name, username, password, email) VALUES (2, 'Emmanuel Silva', 'emmanuel', '$2y$10$tL2pzIMAE5wtvFBmR14LPOO.SeYLnW6itfeLil6kZCjFCYwaeOudy', 'emmanuel@email.com');
INSERT INTO tb_user (id, display_name, username, password, email) VALUES (3, 'Lucas Martins', 'lucas', '$2y$10$tL2pzIMAE5wtvFBmR14LPOO.SeYLnW6itfeLil6kZCjFCYwaeOudy', 'lucas@email.com');
INSERT INTO tb_address (id, street, city, state, zipcode, number, complement, user_id) VALUES (1, 'Rua Itabira', 'Pato Branco', 'PR', '85501-000', 120, 'Apartamento 101', 1);
INSERT INTO tb_address (id, street, city, state, zipcode, number, complement, user_id) VALUES (2, 'Rua Tocantins', 'Pato Branco', 'PR', '85501-010', 450, 'Casa', 1);
INSERT INTO tb_address (id, street, city, state, zipcode, number, complement, user_id) VALUES (3, 'Rua Guarani', 'Pato Branco', 'PR', '85501-020', 300, 'Apartamento 202', 2);
INSERT INTO tb_address (id, street, city, state, zipcode, number, complement, user_id) VALUES (4, 'Rua Paraná', 'Pato Branco', 'PR', '85501-030', 85, 'Casa', 3);

INSERT INTO tb_order (id, date_time, user_id, address_id) VALUES (1, '2026-10-01T14:30:00', 1, 1);
INSERT INTO tb_order (id, date_time, user_id, address_id) VALUES (2, '2026-10-03T18:45:00', 1, 2);
INSERT INTO tb_order (id, date_time, user_id, address_id) VALUES (3, '2026-10-04T10:15:00', 2, 3);
INSERT INTO tb_order (id, date_time, user_id, address_id) VALUES (4, '2026-10-05T16:20:00', 3, 4);

INSERT INTO tb_order_itens (id, quantity, price, product_id, order_id) VALUES (1, 1, 2899.90, 1, 1);
INSERT INTO tb_order_itens (id, quantity, price, product_id, order_id) VALUES (2, 1, 149.90, 3, 1);
INSERT INTO tb_order_itens (id, quantity, price, product_id, order_id) VALUES (3, 1, 299.90, 4, 2);
INSERT INTO tb_order_itens (id, quantity, price, product_id, order_id) VALUES (4, 2, 199.90, 7, 2);
INSERT INTO tb_order_itens (id, quantity, price, product_id, order_id) VALUES (5, 1, 1899.90, 2, 3);
INSERT INTO tb_order_itens (id, quantity, price, product_id, order_id) VALUES (6, 1, 799.90, 5, 4);
INSERT INTO tb_order_itens (id, quantity, price, product_id, order_id) VALUES (7, 1, 329.90, 6, 4);