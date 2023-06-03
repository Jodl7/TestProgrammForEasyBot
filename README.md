# TestProgrammForEasyBot
*Информация по базе данных*

Используется in-memmory database H2. 
База данных содержит в себе 3 таблицы: goods, product_type, unique_properties.
Таблица goods содержит в себе все сведенья о товарах, и состоит из следующих столбцов:
ID, MANUFACTURE, PRICE, SERIAL_NUMBER, STOCK, UNIQUE_PROPERTY_ID.
Значения в таблице не должны быть NULL, поле SERIAL_NUMBER должно быть уникальным, поле UNIQUE_PROPERTY_ID содержит внешний ключ на таблицу unique_properties.

Таблица product_type содержит в себе информацию о типах товаров, и состоит из следующих столбцов: ID, TYPE.
Значения в таблице не должны быть NULL.

ID|  	TYPE  
1	|настольный компьютер
2	|ноутбук
3	|монитор
4	|жесткий диск

Таблица unique_properties содержит в себе информацию о уникальных свойствах товаров (формат-фактор, диагональ монитора и тд.), и состоит из следующих столбцов: 
ID, PROPERTY_NAME, PROPERTY_VALUE, PRODUCT_TYPE_ID.
Значения в таблице не должны быть NULL, поле PRODUCT_TYPE_ID содержит внешний ключ на таблицу product_type.

ID|  	PROPERTY_NAME  	    PROPERTY_VALUE  	PRODUCT_TYPE_ID  
1	|форм-фактор	        |десктоп            |1
2	|форм-фактор	        |неттоп	            |1
3	|форм-фактор	        |моноблок           |1
4	|диагональ ноутбука 	|13"	              |2
5	|диагональ ноутбука	  |14"	              |2
6	|диагональ ноутбука	  |15"	              |2
7	|диагональ ноутбука	  |17"	              |2
8	|диагональ монитора	  |19"	              |3
9	|диагональ монитора	  |27"	              |3
10| диагональ монитора  |	24"	              |3
11|	объем жесткого диска|	500Гб	            |4
12|	объем жесткого диска|	1Тб	              |4
13|	объем жесткого диска|	2Тб	              |4

Таблицы product_type и unique_properties заполняются автоматически программы через скрипт в файле /resourses/data.sql

*Работа программы*

1)запускаем приложение из класса TestProgrammForEasyBotApplication
2)для добавления нового товара отправляем POST запрос на http://localhost:8080/goods/create в JSON формате(
{
    "productType":"монитор",
    "serialNumber": "1654543",
    "manufacture": "china",
    "price": 120.0,
    "stock": 5,
    "propertyName":"диагональ монитора",
    "propertyValue":"19\""
})
При удачном выполнении должны получить сообщение (Product saved) и код ответа 200.
Если поле productType не соответствует полю propertyName и наоборот, то получим сообщение "Unique property not found" и код ответа 400.

3) для редактирования товара, отправляем PATCH запрос на http://localhost:8080/goods/update в JSON формате(
{
    "id":"1"
    "productType":"монитор",
    "serialNumber": "1654543",
    "manufacture": "china",
    "price": 120.0,
    "stock": 5,
    "propertyName":"диагональ монитора",
    "propertyValue":"19\""
})
При удачном выполнении должны получить сообщение (Product updated) и код ответа 200.
Если нет товара с указанным id, то получим сообщение "There is no product with such id" и код ответа 400.

4) для просмотра всех существующих товаров по типу, отправляем GET запрос на http://localhost:8080/goods/{id}.
Должны получить ответ в формате JSON (
{
    "id":"1"
    "productType":"монитор",
    "serialNumber": "1654543",
    "manufacture": "china",
    "price": 120.0,
    "stock": 5,
    "propertyName":"диагональ монитора",
    "propertyValue":"19\""
})

5) для просмотра товара по индентификатору, отправляем GET запрос на http://localhost:8080/goods?type={тип товара}
Должны получить ответ в формате JSON (
{
    "id":"1"
    "productType":"монитор",
    "serialNumber": "1654543",
    "manufacture": "china",
    "price": 120.0,
    "stock": 5,
    "propertyName":"диагональ монитора",
    "propertyValue":"19\""
})
При удачном выполнении должны получить код ответа 200.
Если нет товара с указанным id, то получим сообщение "Product not found" и код ответа 400.
