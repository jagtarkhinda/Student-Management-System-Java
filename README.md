# Student Management Syste Java
#### This repo contains student management system program created using java and Eclipse IDE.


#### Below is summary of what functionality this project provides.

1. Application should be able to accept Student data from the user and add the information in MySQL
2. Student Data should include the following
   - StudentID
   - FirstName 
   - LastName
   - Major
   - Phone
   - GPA 
   - Date of Birth (create a Date class containing Day, Month, Year as fields)

- Example:
  - 100222444
  - James
  - Bond
  - T127 
  - 416-222-2222
  - 3.88
  - October 15th, 1970
  
3. Application should provide the functionality to **display** the student data as needed.

4. Application should also provide **sorting capabilities**, at least by First Name, Last Name and Major.

5. Application should also provide a functionality to **search** for a specific student by:
   - StudentID
   - Last-Name
   - Major
   
6. Application should allow **modification** of any student data by providing proper UI.

**Note: The project has comments as needed in all the files to understand the code properly.**

#### Requirements
- [] As the project is using MySQL databse, you need to download and install sql-connector library from [here](https://dev.mysql.com/downloads/connector/j/5.1.html) to make the connection.
- [] Create a database with name 'studata' (as defined in file) and then import 'sdata.sql' (given) to create table.

