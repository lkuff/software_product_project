# Проект по автоматизированному тестированию сайта "Программный продукт"

<p align="center">
<img title="Allure Overview" src="images/screenshots/Main_page.png">
</p>

## :bookmark_tabs:    Содержание

➠ [Покрытый функционал](#checkered_flag-покрытый-функционал)

➠ [Технологический стек](#desktop_computer-Технологический-стек)

➠ [Запуск тестов из терминала](#key-запуск-тестов-из-терминала)

➠ [Удаленный запуск тестов в Jenkins](#удаленный-запуск-тестов)

➠ [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-allure-report)

➠ [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)

➠ [Пример запуска теста в Selenoid](#-Пример-запуска-теста-в-Selenoid-из-отчета-Allure)
## <a name="checkered_flag-покрытый-функционал"></a>:checkered_flag: Покрытый функционал

### UI тесты

- [x] Проверка наличия кнопок в хедере в локали EN
- [x] Проверка наличия кнопок в хедере в локали RU
- [x] Проверка открытия страницы вк с группой компании при клике на иконку VK
- [x] Проверка открытия страницы P Labs при клике на иконку P
- [x] Проверка открытия страницы "Рейтинги" из выпадющего меню
- [x] Проверка вакансий тестировщика в Москве
- [x] Проверка наличия кнопки "Контакты" в футере страницы

## <a name="desktop_computer-Технологический стек"></a>:desktop_computer: Технологический стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

```mermaid        
    stateDiagram-v2
        State1: Java & IntelliJ IDEA
        State2: Selenide & JUnit5
        State3: Gradle
        State4: GitHub
        State5: Jenkins
        State6: Selenoid
        State7: Allure Report
        State8: Telegram
        State1 --> State2
        State2 --> State3
        State3 --> State4
        State4 --> State5
        State5 --> State6
        State6 --> State7
        State7 --> State8
        note right of State1 : Написание тестов
        note left of State2 : Фреймворки
        note right of State3 : Сборка проекта
        note left of State4 : Система контроля версий 
        note right of State5 : Параметризация и запуск сборки
        note left of State6 : Контейнеризация
        note right of State7 : Просмотр отчетности
        note left of State8 : Уведомления
```
## :key: Запуск тестов из терминала

### Локальный запуск тестов

```
gradle clean test
```

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Удаленный запуск тестов в Jenkins

> Для запуска тестов используется параметризированная сборка
<p align="center">
<img title="Jenkins" src="images/screenshots/Project_build_in_Jenkins.png">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/C16-leshkakuff-software_product_project/allure/)

### :large_orange_diamond: Главная страница Allure-отчета

<p align="center">
<img title="Allure Overview" src="images/screenshots/Main_page_allure_report.png">
</p>

### :large_orange_diamond: Страница с тестами

<p align="center">
<img title="Allure Behaviors" src="images/screenshots/Tests_of_allure.png">
</p>

> Каждый тест имеет:
> - Скриншот
>- Page source
>- Browser console log
>- Видео

### :large_orange_diamond: Основной дашборд

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/Charts_of_allure.png">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

> По результатам каждой сборки Telegram-бот отправляет отчет в специальный телеграм-чат. 
>
> Информация по настройке и использованию бота <code>https://github.com/qa-guru/allure-notifications</code>

<p align="center">
<img title="Telegram Notifications" src="images/screenshots/Report_of_telegram.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid из отчета Allure

> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/Test_selenoid_video.gif">
</p>

[:arrow_up:Содержание](#Содержание)
