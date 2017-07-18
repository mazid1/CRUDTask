# CRUDTask
Simple CRUD project using JSP and mySQL

## Prerquisite
* [db.properties](https://github.com/mazid1/CRUDTask/blob/master/src/db.properties) file should contain actual properties of your system.
* Database table was created using this script:
```mySQL
CREATE TABLE `tasks` (
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(25) NULL,
 `description` varchar(45) NULL,
 `dateCreated` date NULL,
 `dateUpdated` date NULL,
 PRIMARY KEY (`id`));
```

## Work flow
* [me.mazid.util.DBUtil](https://github.com/mazid1/CRUDTask/blob/master/src/me/mazid/util/DBUtil.java) class is responsible for loading [db.properties](https://github.com/mazid1/CRUDTask/blob/master/src/db.properties) file and setting connection to MySQL server.
* [me.mazid.model.Task](https://github.com/mazid1/CRUDTask/blob/master/src/me/mazid/model/Task.java) class represents database table 'tasks'.
* [me.mazid.dao.TaskDAO](https://github.com/mazid1/CRUDTask/blob/master/src/me/mazid/dao/TaskDAO.java) is the interface of Data Access Object.
* [me.mazid.dao.TaskDAOImplementation](https://github.com/mazid1/CRUDTask/blob/master/src/me/mazid/dao/TaskDAOImplementation.java) is the implementation of Data Access Object. Database access is handled using this class.
* [me.mazid.controller.TaskController](https://github.com/mazid1/CRUDTask/blob/master/src/me/mazid/controller/TaskController.java) only servlet is responsible for http requests and responses.

## Screenshots
![Home](http://i.imgur.com/2Kf6GGs.png)
![TaskEditor](http://i.imgur.com/P8qrXMo.png)
![ListAllTasks](http://i.imgur.com/TrAFA1l.png)
