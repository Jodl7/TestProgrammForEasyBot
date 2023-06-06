CREATE SEQUENCE type_seq START WITH 1;
CREATE SEQUENCE prop_seq START WITH 1;
Insert into product_type (id, type)
VALUES (NEXTVAL('type_seq'),'настольный компьютер'),
       (NEXTVAL('type_seq'),'ноутбук'),
       (NEXTVAL('type_seq'),'монитор'),
       (NEXTVAL('type_seq'),'жесткий диск');
Insert into unique_properties(id, property_name, property_value, product_type_id)
VALUES (NEXTVAL('prop_seq'),'форм-фактор', 'десктоп', 1),
       (NEXTVAL('prop_seq'),'форм-фактор', 'неттоп', 1),
       (NEXTVAL('prop_seq'),'форм-фактор', 'моноблок', 1),
       (NEXTVAL('prop_seq'),'диагональ ноутбука', '13"', 2),
       (NEXTVAL('prop_seq'),'диагональ ноутбука', '14"', 2),
       (NEXTVAL('prop_seq'),'диагональ ноутбука', '15"', 2),
       (NEXTVAL('prop_seq'),'диагональ ноутбука', '17"', 2),
       (NEXTVAL('prop_seq'),'диагональ монитора', '19"', 3),
       (NEXTVAL('prop_seq'),'диагональ монитора', '27"', 3),
       (NEXTVAL('prop_seq'),'диагональ монитора', '24"', 3),
       (NEXTVAL('prop_seq'),'объем жесткого диска', '500Гб', 4),
       (NEXTVAL('prop_seq'),'объем жесткого диска', '1Тб', 4),
       (NEXTVAL('prop_seq'),'объем жесткого диска', '2Тб', 4);