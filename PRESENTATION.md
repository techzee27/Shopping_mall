# Shopping Mall Management System - Project Overview

## 1. Introduction
The **Shopping Mall Management System** is a comprehensive full-stack web application designed to digitize and streamline the operations of a shopping mall. It serves as a centralized platform to manage malls, shops, employees, items, customers, and orders efficiently.

The system is built using **Spring Boot** for the backend and **Vanilla JavaScript/HTML/CSS** for the frontend, ensuring a lightweight yet powerful architecture.

---

## 2. Core Concepts & Terminologies

### Domain Entities
These are the fundamental objects that the system manages:

- **Mall**: Represents the physical mall entity. It can contain multiple shops.
- **Shop**: Individual stores located within a mall. Each shop has attributes like Category, Lease Status, and Owner.
- **Item**: Products sold by specific shops. Tracks inventory, price, and expiry dates.
- **Employee**: Staff members working at specific shops.
- **Customer**: Registered buyers who purchase items.
- **Order**: A transaction record linking a Customer, a Shop, and the total amount spent.
- **Mall Admin**: The top-level administrator managing the mall infrastructure.
- **Shop Owner**: Individuals responsible for specific shops.

### Technical Terminologies
- **REST API (Representational State Transfer)**: The backend exposes endpoints (URLs) that the frontend talks to (e.g., `GET /shop`, `POST /item`).
- **CRUD**: The four basic operations implemented for every entity - **C**reate, **R**ead, **U**pdate, **D**elete.
- **SPA (Single Page Application) Feel**: Although not using a heavy framework like React, the Javascript logic dynamically swaps content in the main content area without refreshing the page, providing a smooth user experience.
- **ORM (Object-Relational Mapping)**: The technique used to map Java objects (Classes) to Database Tables using Hibernate/JPA.

---

## 3. System Architecture

The application follows the classic **Layered Architecture**:

1.  **Presentation Layer (Frontend)**: 
    - `index.html`, `styles.css`, `script.js`.
    - Handles user interactions and calls APIs.
2.  **Controller Layer (Backend API)**:     
    - `ShopController`, `MallController`, etc.
    - Receives HTTP requests from the frontend and delegates tasks to the Service layer.
3.  **Service Layer (Business Logic)**:
    - Contains the core business rules.
    - Ensures valid data is passed to the database.
4.  **Repository Layer (Data Access)**:
    - Interfaces extending `JpaRepository`.
    - Talks directly to the Database to Fetch/Save data.
5.  **Database Layer**:
    - **PostgreSQL**: Stores the actual data in relational tables.

---

## 4. Technology Stack & Justification

### Backend
-   **Java 17**: A modern, Long-Term Support (LTS) version of Java offering performance and stability.
-   **Spring Boot 3.2.0**: 
    -   *Why?* Rapid application development. It provides built-in servers (Tomcat) and auto-configuration, reducing boilerplate code.
-   **Spring Data JPA (Hibernate)**:
    -   *Why?* Simplifies database interactions. We don't need to write raw SQL queries; methods like `findById()` or `save()` are provided out of the box.
-   **PostgreSQL**:
    -   *Why?* A robust, open-source relational database ideal for handling structured data with complex relationships (Foreign Keys).
-   **Lombok**:
    -   *Why?* Reduces code verbosity by auto-generating Getters, Setters, and Constructors.

### Frontend
-   **HTML5 & CSS3**: For structure and styling.
    -   *Style*: Custom CSS variables and Flexbox/Grid for a modern, responsive "Dashboard" aesthetic.
-   **Vanilla JavaScript (ES6+)**:
    -   *Why?* For this scale, avoiding heavy frameworks (React/Angular) keeps the build process simple and fast. It handles specific tasks like API Fetching and DOM manipulation efficiently.
-   **Chart.js**:
    -   *Why?* Used to render interactive analytics charts on the dashboard.

### Tools
-   **Maven**: Dependency management and build tool.
-   **VS Code / Eclipse**: Development IDE.

---

## 5. How It Works (Workflow)

1.  **Relationship Hierarchy**:
    -   A **Mall** is created first.
    -   A **Shop** is created and assigned to a specific Mall.
    -   **Items** and **Employees** are added and linked to a Shop.
    -   **Customers** place orders, creating **Order** records linked to both the Customer and the Shop.

2.  **User Interaction**:
    -   User clicks "Shops" on the sidebar.
    -   `script.js` calls `GET /shop`.
    -   Data is returned as JSON.
    -   `script.js` dynamically generates the HTML Table to display the data.
    -   When "Add Shop" is clicked, a Modal opens. Submitting the form acts as a `POST /shop` request.

---

## 6. Key Features Demonstrated

1.  **Dynamic Dashboard**:
    -   Real-time statistics (Total Revenue, Active Shops).
    -   Visual Charts (Bar charts for overview, Doughnut charts for status).
2.  **Unified Management**: Single interface to manage all related entities.
3.  **Search & Filtering**: (Implicit in database queries).
4.  **Responsive Design**: Sidebar layout that adapts to screen sizes.

---

## 7. Future Enhancements
-   **Authentication**: Implementing JWT (JSON Web Tokens) for secure login.
-   **Payment Gateway**: Integrating Stripe or PayPal for real order processing.
-   **Advanced Reporting**: Exporting data to PDF/Excel.

