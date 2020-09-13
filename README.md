# Шаблон selenide проекта

maven, testng, allure

1.Локальный запуск тестов:
```
mvn -P firefox,testhost,noselenoid clean test
```
2.Запуск тестов в selenoid:
```
mvn -P firefox,testhost,selenoid clean test
```
