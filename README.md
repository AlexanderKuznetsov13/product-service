# **Product Service**

- [ ] put tables into README.md
- [ ] UML diagram of database
    - [ ] draw UML diagram
    - [ ] check all fields and refactor
- [ ] liquibase scripts for tables
    - [ ] table1 
- [ ] add rest controller
- [ ] \(Optional) define test sql queries
- [ ] \(Optional) define prod sql queries
- [ ] \(Optional) check and refactor README.md and UML diagram

<a name="db_schema_table_list"></a>
## DB Schema
* [table_name1](#db_schema_table_name1)
* [table_name2](#db_schema_table_name2)



<a name="db_schema_table_name1"></a>
### user
[Back to table list](#db_schema_table_list)

#### List of table1

| Name | Column      |     Type     | Nullable | Default | Example | Comments            |
|------|-------------|:------------:|:--------:|---------|---------|---------------------|
| user | id          |   INTEGER    |  false   |         |         | PRIMARY KEY         |
| user | login       | VARCHAR(100) |  false   |         |         | PRIMARY KEY         |


<a name="db_schema_table_name2"></a>
### topic
[Back to table list](#db_schema_table_list)

#### List of table2

| Name  | Column      |     Type     | Nullable  | Default | Example | Comments      |
|-------|-------------|:------------:|:---------:|---------|---------|---------------|
| topic | id          |   INTEGER    |   false   |         |         | PRIMARY KEY   |
| topic | name        | VARCHAR(100) |   false   |         |         | Name of topic |
