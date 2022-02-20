# Medical Management System
Medical Management System (MMS) - Integrated system for Medical Professionals to monitorize and check patients' health situations, mostly focused on patients who are in the intensive care unit.

Final grade: 17


# Project team:

| Role          | Nome          | **Email**            | NMEC  |
| ------------- | ------------- | -------------------- | ----- |
| DevOps        | Artur Romão   | artur.romao@ua.pt    | 98470 |
| Product Owner | Diogo Cruz    | diogophc@ua.pt       | 98595 |
| Team Manager  | Mariana Rosa  | marianarosa@ua.pt    | 98390 |
| Architect     | Paulo Pereira | paulogspereira@ua.pt | 98430 |



### Project resources:

Atlassian Scrum Board: https://medicalmanagementsystem.atlassian.net/jira/software/projects/MMS/boards/1

API Documentation: https://documenter.getpostman.com/view/18915431/UVeAu8XZ

VM Link :http://192.168.160.209:6767/



### Run the website locally

```bash
./run.sh (localhost:6767)
[OPTIONAL] ./mvnw spring-boot:run (localhost:8080, used for faster testing purposes)
```



### To create *jar* file

Inside the */medmanagesystem* folder:

```bash
mvn clean package -DskipTests
```



### Access to the website

| Role            | Profissional CC  | Password         |
| ----------------|------------------|------------------|
| Doctor          | 75766646         | 7576664675766646 |
| Nurse           | 60411478         | 6041147860411478 |
| Admin (manager) | 0                | admin            |

