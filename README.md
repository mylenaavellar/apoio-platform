# APOIO Platform - Backend API

> **APOIO** (Post-Occupancy Integrated Assessment Oriented to Urbanism) is a citizen auditing platform for urban projects. The system allows citizens and technicians to evaluate the performance of public spaces (squares, parks, pedestrian areas) in use, crossing human perception data with urban planning.

This repository contains the **REST API** of the ecosystem, developed with a focus on high cohesion, low coupling, and scalable architecture.

---

## Technologies and Tools

The ecosystem was designed using industry standards for corporate applications and microservices:

* **Java 17** - Robust language with modern features.
* **Spring Boot 3.x** - Base framework for building the REST API.
* **Spring Data JPA** - Data persistence abstraction.
* **PostgreSQL** - Relational database for secure and robust storage.
* **Docker & Docker Compose** - Full application containerization.
* **Git & GitHub** - Version control using a professional branching workflow.

---

## Architecture and Best Practices

The project was structured following the **Package by Layer** pattern, ensuring a clear separation of responsibilities:

* **Controllers:** REST endpoint exposure and HTTP response handling.
* **Services:** Isolated business layer containing the ecosystem's rules and validations.
* **Repositories:** Query routing and persistence with the database through Spring Data.
* **DTOs (Data Transfer Objects):** Use of **Java Records** for data input and output, shielding database entities and preventing sensitive data leakage (e.g. passwords).

### Implemented Technical Highlights:
* **Constructor-based Dependency Injection:** Guarantees component immutability and facilitates unit testing.
* **Automatic Auditing (Spring Auditing):** Centralized creation and modification logs (`createdAt` and `updatedAt`) through inheritance with `@MappedSuperclass` (`Auditable`).
* **Complex Relationships:** Database modeling mapping entities in a performant way (`@ManyToOne`).

---

## Data Model (Domains)

The system manages three fundamental pillars, tailored for Architecture and Urbanism concepts:

1. **User:** Citizens or technical auditors of the space.
2. **Urban Project:** Urban spaces and interventions categorized by type (Squares, Parks, etc.).
3. **Evaluation (Post-Occupancy Assessment):** Multifactorial diagnosis focused on the project's real performance:
    * *Comfort Score* (Thermal/spatial comfort)
    * *Security Score* (Perception of safety)
    * *Lighting Score* (Public lighting quality)
    * *Accessibility Score* (Universal accessibility)
    * *Furniture Score* (Urban furniture condition)

---

## Running the Project Locally

### Prerequisites
* Docker / Docker Compose installed and running.

### 1. Clone the repository
```
git clone https://github.com/mylenaavellar/apoio-platform.git
```
### 2. Start the application
```
docker compose up --build
```
The API will be available at http://localhost:8080.

### Useful commands

Run in background:
```
docker compose up -d --build
```
View logs:
```
docker compose logs -f server
```
Stop:
```
docker compose down
```

---

## Testing the API

Requests can be validated using HTTP clients such as **Postman** or **Insomnia**.

### Users
* `POST /users` - Register a new user
* `GET /users` - List all users
* `GET /users/{id}` - Find a specific user by ID
* `PUT /users/{id}` - Update user data
* `DELETE /users/{id}` - Remove a user from the system

### Urban Projects
* `POST /urban-projects` - Register a new urban project
* `GET /urban-projects` - List all urban projects
* `GET /urban-projects/{id}` - Find a specific project by ID
* `PUT /urban-projects/{id}` - Update project data
* `DELETE /urban-projects/{id}` - Remove a project from the system

### Evaluations
* `POST /evaluations` - Submit an evaluation
* `GET /evaluations` - List all evaluations
* `GET /evaluations/{id}` - Find a specific evaluation by ID
* `PUT /evaluations/{id}` - Update scores or comments of an evaluation
* `DELETE /evaluations/{id}` - Remove an existing evaluation

> **Full API Documentation:** With the application running locally, you can access the interactive **Swagger UI** at: `http://localhost:8080/swagger-ui.html` to test the endpoints directly in the browser.

---

## Commit Convention

To keep the repository history clean and readable, this project adopts the **Conventional Commits** standard:

* `feat(...)`: Addition of new features.
* `refactor(...)`: Code changes that improve readability or structure without changing behavior.
* `chore(...)`: Build updates, project configuration, or Maven dependency changes.
