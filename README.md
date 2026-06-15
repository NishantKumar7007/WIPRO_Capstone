# ✈️ BlazeDemo Automation Framework

<div align="center">

![Java](https://img.shields.io/badge/Java-1.8-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=for-the-badge&logo=apachemaven)
![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-yellow?style=for-the-badge&logo=jenkins)

### 🚀 End-to-End Flight Booking Automation Framework

</div>

---

## 📌 Project Overview

This project automates the complete flight booking process of the **BlazeDemo Application** using Selenium WebDriver, Java, TestNG, Maven, and Page Object Model (POM).

🔗 **Application URL:** https://blazedemo.com/

---

## 🎯 Project Objectives

✅ Automate End-to-End Flight Booking

✅ Implement Page Object Model (POM)

✅ Data Driven Testing using Excel

✅ Generate Extent Reports

✅ Capture Screenshots

✅ Integrate Jenkins CI/CD

✅ Maintain Reusable Framework

---

## 🛠️ Technology Stack

| Technology | Usage |
|------------|--------|
| ☕ Java | Programming Language |
| 🌐 Selenium WebDriver | Browser Automation |
| 🧪 TestNG | Test Execution Framework |
| 📦 Maven | Dependency Management |
| 📊 Apache POI | Excel Data Handling |
| 📈 Extent Reports | Reporting |
| 🔄 Jenkins | CI/CD |
| 🐙 Git & GitHub | Version Control |

---

## 📂 Project Structure

```text
BlazeDemo_Capstone
│
├── src/test/java
│   ├── base
│   │   └── BaseClass.java
│   │
│   ├── pages
│   │   ├── HomePage.java
│   │   ├── FlightsPage.java
│   │   ├── PurchasePage.java
│   │   └── ConfirmationPage.java
│   │
│   ├── tests
│   │   └── FlightBookingTest.java
│   │
│   ├── listeners
│   │   └── TestListener.java
│   │
│   └── utils
│       ├── ExcelUtils.java
│       └── ExtentReportManager.java
│
├── src/test/resources
│   └── testdata.xlsx
│
├── Reports
├── Screenshots
├── pom.xml
├── testng.xml
└── Jenkinsfile
```

---

## 🔄 Automation Flow

```text
Open BlazeDemo
      ↓
Select Cities
      ↓
Find Flights
      ↓
Verify Flight List
      ↓
Choose Flight
      ↓
Verify Purchase Page
      ↓
Enter Passenger Details
      ↓
Enter Payment Details
      ↓
Purchase Flight
      ↓
Verify Confirmation
      ↓
Generate Reports & Screenshots
```

---

## 🧪 Test Scenario

### Flight Booking Flow

1️⃣ Launch BlazeDemo Application

2️⃣ Select Departure City

3️⃣ Select Destination City

4️⃣ Click Find Flights

5️⃣ Verify Flight List

6️⃣ Select Flight

7️⃣ Verify Purchase Page

8️⃣ Enter Passenger Details

9️⃣ Enter Payment Details

🔟 Click Purchase Flight

✅ Verify Booking Confirmation

---

## 📊 Data Driven Testing

Test data is stored in:

```text
src/test/resources/testdata.xlsx
```

### Test Data Fields

- Departure City
- Destination City
- Passenger Name
- Address
- City
- State
- Zip Code
- Card Number
- Month
- Year
- Name On Card
- Flight Index

---

## 📈 Reports

### Extent Report

```text
Reports/ExtentReport.html
```

### Screenshots

```text
Screenshots/
```

---

## ⚙️ Jenkins Pipeline

### Pipeline Stages

✅ Checkout Code

✅ Clean Project

✅ Compile Project

✅ Execute TestNG Tests

✅ Archive Reports

✅ Archive Screenshots

---

## 🏆 Framework Highlights

🟢 Page Object Model (POM)

🟢 Data Driven Testing

🟢 Extent Reports

🟢 Screenshot Capture

🟢 Jenkins CI/CD

🟢 Maven Integration

🟢 Reusable Framework

🟢 End-to-End Automation

---

## 👨‍💻 Author

### Nishant Kumar

🔗 GitHub Repository

https://github.com/NishantKumar7007/WIPRO_Capstone

---

<div align="center">

### ⭐ If you like this project, give it a Star ⭐

🚀 Happy Testing 🚀

</div>