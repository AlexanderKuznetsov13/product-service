# **Product Service**

- [ ] put tables into README.md
- [ ] UML diagram of database
    - [ ] draw UML diagram
    - [ ] check all fields and refactor
- [ ] liquibase scripts for tables
    - [ ] product 
    - [ ] currency 
    - [ ] product_currency 
    - [ ] language 
    - [ ] name_description_translation 
- [ ] add rest controller
- [ ] \(Optional) define test sql queries
- [ ] \(Optional) define prod sql queries
- [ ] \(Optional) check and refactor README.md and UML diagram

[Условие](#task_condition)

## Swagger
http://localhost:8080/v3/api-docs
http://localhost:8080/swagger-ui/index.html


<a name="db_schema_table_list"></a>
## DB Schema
* [product](#db_schema_table_product)
* [currency](#db_schema_table_currency)
* [product_currency](#db_schema_table_product_currency)
* [language](#db_schema_table_language)
* [name_description_translation](#db_schema_table_name_description_translation)


<a name="db_schema_table_product"></a>
### product
[Back to table list](#db_schema_table_list)

#### List of products

| Name    | Column                 |   Type    | Nullable | Default | Example | Comments          |
|---------|------------------------|:---------:|:--------:|---------|---------|-------------------|
| product | id                     |  INTEGER  |  false   |         |         | PRIMARY KEY       |
| product | creation_date          | TIMESTAMP |  false   |         |         | date of creation  |
| product | last_modification_date | TIMESTAMP |  false   |         |         | last modification |


<a name="db_schema_table_currency"></a>
### currency
[Back to table list](#db_schema_table_list)

#### List of currencies

| Name     | Column |     Type     | Nullable | Default | Example | Comments         |
|----------|--------|:------------:|:--------:|---------|---------|------------------|
| currency | id     |   INTEGER    |  false   |         |         | PRIMARY KEY      |
| currency | name   | VARCHAR(100) |  false   |         |         | Name of currency |


<a name="db_schema_table_product_currency"></a>
### product_currency
[Back to table list](#db_schema_table_list)

#### List of products with different currencies

| Name             | Column      |  Type   | Nullable | Default | Example | Comments    |
|------------------|-------------|:-------:|:--------:|---------|---------|-------------|
| product_currency | id          | INTEGER |  false   |         |         | PRIMARY KEY |
| product_currency | product_id  | INTEGER |  false   |         |         | product id  |
| product_currency | currency_id | INTEGER |  false   |         |         | currency id |
| product_currency | price       |  REAL   |  false   |         |         | price       |



<a name="db_schema_table_language"></a>
### language
[Back to table list](#db_schema_table_list)

#### List of languages

| Name     | Column |     Type     | Nullable | Default | Example | Comments         |
|----------|--------|:------------:|:--------:|---------|---------|------------------|
| language | id     |   INTEGER    |  false   |         |         | PRIMARY KEY      |
| language | name   | VARCHAR(100) |  false   |         |         | Name of language |


<a name="db_schema_table_name_description_translation"></a>
### name_description_translation
[Back to table list](#db_schema_table_list)

#### List of translations for product name/description.

| Name                         | Column      |     Type      | Nullable | Default | Example | Comments               |
|------------------------------|-------------|:-------------:|:--------:|---------|---------|------------------------|
| name_description_translation | id          |    INTEGER    |  false   |         |         | PRIMARY KEY            |
| name_description_translation | product_id  |    INTEGER    |  false   |         |         | product id             |
| name_description_translation | language_id |    INTEGER    |  false   |         |         | language id            |
| name_description_translation | name        | VARCHAR(100)  |  false   |         |         | name of product        |
| name_description_translation | description | VARCHAR(1000) |  false   |         |         | description of product |





<a name="task_condition"></a>
### Условие
1. Создать простое приложение с использованием Spring Boot.
   Приложение должно предоставлять администраторский REST CRUD интерфейс для
   управления продуктами.
   В качестве инструмента для сборки и управления проектом использовать Maven.
   Для хранения данных можно использовать PostgreSQL или in-memory DB.
   Продукт должен иметь уникальный идентификатор, название и описание, цену, дату
   создания и дату модификации.
   При запросе продукта по идентификатору, если продукт не найден, возвращать пустой
   результат со статусом 404.
2. Расширить доменную модель и методы REST API так, чтобы цену продукта можно
   было указывать в разных валютах, а название продукта и его описание - в разных языках.
3. Добавить валидацию на создании и модификации продукта.
   Входные данные нужно валидировать следующим образом:
   Название продукта - обязательное поле, не должно быть пустым.
   Цена продукта - обязательное поле, должна быть больше 0.
4. Добавить в приложение второй REST ресурс, предназначенный для получения
   продуктов клиентами, ProductClientResource.


   В новом ресурсе создать следующие методы:
- метод для поиска продуктов по имени или описанию.
- метод для получения всего списка продуктов.
  В случае, когда продукт не имеет данных в указанном языке и/или валюте, такой продукт
  не должен попадать в результирующий список.
- метод для получения продукта по идентификатору.
  Списки продуктов должны возвращаться постранично.
  Если у полученного по идентификатору продукта нет данных в указанном языке и/или
  валюте, кидать специальное исключение.
  Для этого ресурса ошибки при получении продукта (404 + новое исключение) должны
  быть обработаны и возвращены клиенту в виде простого объекта с полями errorCode и
  errorMessage.
  Для преобразования исключения в объект ошибки использовать обработчик на основе
  аннотации @ExceptionHandler.
  Исключительные ситуации должны быть залогированы.
  Все методы этого ресурса должны требовать указания конкретного языка и валюты.
  Примечания.
  Рекомендуется использовать трёхуровневую (трёхслойную) архитектуру приложения.
  Для логирования использовать log4j либо logback в связке с SLF4J.
  Если возникнут проблемы с логированием можно использовать System.out.println().
  Допускается использование не указанных в техническом задании технологий и сторонних
  библиотек. Например: Swagger, Liquibase


Задание подразумевает наличие базовых знаний языка java, а также базовые знания
фреймворка Spring и предоставляемых им инструментов.

Тест состоит из четырёх пунктов, первый из которых является обязательным к
исполнению, а остальные на нём базируются, добавляя сложности к разрабатываемому
приложению.

Задание нацелено на проверку следующих знаний и умений кандидата:
- Пункт 1:
Умение пользоваться фреймворком Spring.
Способность создать проект с нуля.
Понимание архитектурного стиля REST.
Навыки использования инструмента для сборки и управления проектом.
Умение подключения и работы с персистентными хранилищами, БД.
Минимальные навыки по обработке ошибок.

- Пункт 2.
Умение связывать персистентные сущности путём указания отношений между ними (либо
же понимание как хранить и использовать данные альтернативным способом, например в
JSON).
Понимание различий в назначении между сущностями доменной модели и объектами
представления.

- Пункт 3.
Знание Bean Validation и умение пользоваться соответствующими аннотациями.

- Пункт 4.
Умение написания запросов на получение персистентных данных по предоставленным
критериям.
Навык использования PagingAndSortingRepository для постраничного отображения
данных.
Обработка и управление ошибками в REST интерфейсе