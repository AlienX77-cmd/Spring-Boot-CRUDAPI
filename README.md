**Path 0:**

**Spring-Boot-CRUDAPI/crudapi/src/main/java/com/kittipak/crudapi/entity/User.java**

**Detail:** User.java - User Class Object (Define Type and Data Model)

**Path 1:**

**Spring-Boot-CRUDAPI/crudapi/src/main/java/com/kittipak/crudapi/services/UserService.java**

**Detail:** UserService.java - กำหนด Interface of method

**Path 2:**

**Spring-Boot-CRUDAPI/crudapi/src/main/java/com/kittipak/crudapi/services/UserServiceAction.java**

**Detail:** UserServiceAction.java - Implements method in UserService และนำคุณสมบัติจาก JPA Repository จาก userRepository (ที่ extend JPA) มาใช้

**Path 3:**

**Spring-Boot-CRUDAPI/crudapi/src/main/java/com/kittipak/crudapi/repository/UserRepository.java**

**Detail:** UserRepository - extends JPA Repository Method

**Path 4:**

**Spring-Boot-CRUDAPI/crudapi/src/main/java/com/kittipak/crudapi/controllers/UserController.java**

**Detail:** UserController กำหนด path endpoint (API endpoint) และใช้งาน UserService.java ในแต่ละ endpoint (Post, Get, Get by id, Delete, Put)


**Run the app via: CrudapiApplication.java**
