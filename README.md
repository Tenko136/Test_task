
## **Проект работы банковского приложения.** 
### **Релизована логика работы клиентов с кредитными счетами банка.** 
<br>
Использована БД MySQL в контейнере Docker. Настройки контейнера указаны в файле *docker-compose.yml* 

Запуск Docker-compose по команде:

> docker-compose up

<br>
<br>

Liquibase файл *db.changelod-master.yaml*, запускается при старте приложения

<br>
<br>

- Сохранение транзакций:
> /save-operation
```java
TransactionController.saveTransaction
```
<br>

- Ежедневная загрузка актуального курса валют USD-KZT и USD-RUB с сайта [openexchangerates.org](https://openexchangerates.org):
```java
TransactionServiceImpl.addCurrencyRate
```
<br>

- Ежемесячное обновление лимитов в размере 1000 USD по категориям "service" и "product" для всех клиентов:
```java
ClientServiceImpl.updateAllLimitsEveryMonth
```
<br>

- Обновление лимита клиента:
> /client/new-limit
```java
ClientController.limitNew
```
<br>

- Получить список всех лимитов клиента:
> /client/all-limits
```java
ClientController.getAllLimits
```
<br>

- Получить список транзакций, превысивших/не привысивших лимит:
> /client/transactions
```java
ClientController.getTransactionExceedingLimit
```
<br>


Настройки подключения к БД в файле *application.properties*

Подключен [swagger](http://localhost:8080/swagger-ui/index.html)

Подробное описание задачи в файле *BackEnd_Test_Assignment.pdf*

