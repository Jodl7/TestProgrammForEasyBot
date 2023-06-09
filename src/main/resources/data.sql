Insert into product_type (type)
VALUES ('настольный компьютер'),
       ('ноутбук'),
       ('монитор'),
       ('жесткий диск');
Insert into unique_properties(property_name, property_value, product_type_id)
VALUES ('форм-фактор', 'десктоп', 1),
       ('форм-фактор', 'неттоп', 1),
       ('форм-фактор', 'моноблок', 1),
       ('диагональ ноутбука', '13"', 2),
       ('диагональ ноутбука', '14"', 2),
       ('диагональ ноутбука', '15"', 2),
       ('диагональ ноутбука', '17"', 2),
       ('диагональ монитора', '19"', 3),
       ('диагональ монитора', '27"', 3),
       ('диагональ монитора', '24"', 3),
       ('объем жесткого диска', '500Гб', 4),
       ('объем жесткого диска', '1Тб', 4),
       ('объем жесткого диска', '2Тб', 4);