# rest_api

## Документация REST API ##
### Описание
Данная документация описывает REST API на основе Spring Framework с использованием языка программирования Java. API включает в себя один контроллер, обрабатывающий GET-запрос с параметром, передаваемым через тело запроса.

### Контроллер
#### Получение данных ####
Метод: GET
Путь: *`/symbolsFrequency`*

Тело запроса (тип: application/json):

```json
{
 "str": "value"
}
```

Пример запроса:
```
POST /api/data
Content-Type: application/json

{
   "str": "aaashhqqqqq"
}
```

Пример ответа:
```json
{
   "str": "|q|: 5, |a|: 3, |h|: 2, |s|: 1"
}
```

### Запуск приложения
1. Убедитесь, что на вашем компьютере установлен Java Development Kit (JDK).

2. Склонируйте репозиторий с проектом:
```bash
git clone https://github.com/sheepleader941/rest_api
```
3. Перейдите в каталог проекта
4. Откройте проект в вашей среде разработки (например, IntelliJ IDEA) или выполните сборку с помощью Maven:
```bash
./mvnw clean install
```
5. Запустите приложение
```bash
./mvnw spring-boot:run
```
6. Приложение будет доступно по адресу:
```
http://localhost:8080
```
Теперь вы можете отправлять POST-запросы на *`http://localhost:8080/symbolsFrequency`* с параметром `str` в теле запроса и получать соответствующий ответ.
