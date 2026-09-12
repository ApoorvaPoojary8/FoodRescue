# 🍱 FoodRescue

> A full-stack platform for reducing food waste by connecting food donors with organizations and individuals who can make use of surplus food.

---

## 📌 Overview

FoodRescue is a food redistribution platform designed to make surplus food donation simple, secure, and accessible.

The platform allows users to register, authenticate securely, and donate surplus food. Each donation is associated with the authenticated donor and stored in a PostgreSQL database.

The project is currently under active development, with additional food requesting, pickup, notification, and frontend features planned.

---

## ✨ Current Features

- 🔐 Secure user authentication using JWT
- 🔑 BCrypt password encryption
- 👤 User registration and login
- 🛡️ Protected REST APIs using Spring Security
- 🍱 Create food donations
- 🔗 Automatically associate donations with the logged-in donor
- 📋 Retrieve available food donations
- ✅ Request validation
- 🗄️ PostgreSQL database integration
- 🧪 REST API testing with Postman

---

## 🛠️ Tech Stack

### Backend

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring%20Security-7.x-brightgreen?style=for-the-badge&logo=springsecurity)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-brown?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

### Database

![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-blue?style=for-the-badge&logo=postgresql)

### Frontend

![React](https://img.shields.io/badge/React.js-Coming%20Soon-61DAFB?style=for-the-badge&logo=react)
![Vite](https://img.shields.io/badge/Vite-Coming%20Soon-646CFF?style=for-the-badge&logo=vite)

### Tools

![Postman](https://img.shields.io/badge/Postman-API%20Testing-orange?style=for-the-badge&logo=postman)
![Git](https://img.shields.io/badge/Git-Version%20Control-F05032?style=for-the-badge&logo=git)
![GitHub](https://img.shields.io/badge/GitHub-Repository-181717?style=for-the-badge&logo=github)

---

## 🏗️ Architecture

```text
                   ┌───────────────┐
                   │    Client     │
                   │ React / API   │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │ REST API      │
                   │ Spring Boot   │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │   Security    │
                   │ JWT + BCrypt  │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │   Service     │
                   │    Layer      │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │ Repository    │
                   │   JPA         │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │  PostgreSQL   │
                   └───────────────┘