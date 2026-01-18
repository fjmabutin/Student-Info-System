💾 # Student Information System
Java desktop application for managing student information using JDBC and MySQL.

This system allows users to input their personal, academic, and emergency contact details for students.  

✨ Features
- **Personal Information:** Full name, age, gender, date of birth, email, home address, contact number.  
- **Academic Information:** Student number, enrollment date, section, school year, status.  
- **Emergency Contact:** Guardian name, relationship, and contact number.  
- **Buttons:**  
  - **Save:** Review entered information in a text area.  
  - **Delete:** Clear all fields.  
  - **Confirm:** Save data confirmation popup and save into database created.  
- Scrollable GUI for easy navigation.  

🚀 How to Run
1. Make sure you have **Java JDK** installed.  
2. Open the project in any Java IDE (e.g., Eclipse, NetBeans, VS Code).  
3. Compile and run `StudentInformationSystem.java`.  

📝 Notes
- Database; minor refinements and verification steps are pending before full functionality is finalized.

---

Created by: 
**Francine Joy D. Mabutin**  

## 🛢️ MySQL Schema

```sql
CREATE DATABASE IF NOT EXISTS student_system;
USE student_system;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,

    full_name VARCHAR(150) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    dob VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL,
    address VARCHAR(255) NOT NULL,
    contact VARCHAR(50) NOT NULL,

    student_number VARCHAR(50) NOT NULL,
    enrollment_date VARCHAR(50) NOT NULL,
    section VARCHAR(50) NOT NULL,
    school_year VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,

    guardian_name VARCHAR(150) NOT NULL,
    relationship VARCHAR(50) NOT NULL,
    guardian_contact VARCHAR(50) NOT NULL
);
