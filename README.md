greetings project
=================
[![Build Status](https://travis-ci.org/OlexiyZh/home_projects.png)](https://travis-ci.org/OlexiyZh/home_projects)

---
##### greetingsSimple project
This project implements the same functionality and don't use Spring Framework and ResourceBundle.

---

#### Task description:

Write a console application on java using maven.

The application should display a welcome message depending on the current time of day:
* Good morning, World! 06:00 - 9:00
* Good day, World! 09:00 - 19:00
* Good evening, World! 19:00 - 23:00
* Good night, World! 23:00 - 06:00

The code should include all possible unit tests and generate a readable log file.
Messages output to the console must be received from the message resource and depend on the user's system locale. Make a translation into Russian.

Code solutions should be published on GitHub'e without mentioning the name of the company.
The README file should contains the status of the assembly by [Travis CI](https://docs.travis-ci.com/user/status-images/) or [Circle CI](https://circleci.com/docs/status-badges) as a badge - link to the assembly page. The assembly should be successful. Tests should pass during the assembly. Sample project with badges - https://github.com/codecentric/spring-boot-admin
