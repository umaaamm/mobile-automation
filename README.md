# Mobile Automation Framework

Mobile Automation Framework menggunakan:

* Java 17/25
* Appium
* Cucumber (BDD)
* JUnit 5
* Maven
* Allure Report

Framework ini dirancang untuk melakukan automation testing pada aplikasi **Flutter** menggunakan **Appium** dengan arsitektur **Page Object Model (POM)** dan **Flow Pattern**.

## Requirements

Pastikan telah menginstal:

* Java 17+
* Maven 3.9+
* Android SDK
* Appium Server
* Android Emulator atau Physical Device
* Allure CLI (opsional, untuk melihat report)

## Menjalankan Appium

```bash
appium
```

Pastikan Appium Server berjalan di:

```
http://127.0.0.1:4723
```

## Menjalankan Automation

Menjalankan seluruh scenario:

```bash
mvn clean test
```

Menjalankan berdasarkan tag:

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

```bash
mvn clean test -Dcucumber.filter.tags="@sanity"
```

Menjalankan runner tertentu:

```bash
mvn clean test -Dtest=RunSmokeTest
```

## Allure Report

Menampilkan report setelah test selesai:

```bash
allure serve allure-results
```

Atau generate report HTML:

```bash
allure generate allure-results --clean
allure open allure-report
```

## Features

* Appium Automation
* Flutter Automation
* Cucumber BDD
* Page Object Model (POM)
* Flow Pattern
* Screenshot on Failure
* Allure Report
* Logging
* Config Management
