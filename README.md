# HW5-otus-wiremock
 
Запуск wiremock:
1. Местонахождение стабов для wiremock C:\2023\dev\HW5-otus-wiremock\WireMock\src\test\resources\stubs
2. Строка запуска в cmd с предварительно поднятым Docker https://wiremock.org/docs/standalone/docker/:
   docker run -it -v "C:\2023\dev\HW5-otus-wiremock\WireMock\src\test\resources\stubs":/home/wiremock --rm -p 8080:8080 --name wiremock wiremock/wiremock:2.35.0
