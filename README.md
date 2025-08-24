# BorgoApp API

This is a Spring Boot REST API for the Borgo food ordering application. It provides endpoints for user authentication, menu management, order processing, and category management.

## Features

- User registration and login with JWT authentication
- CRUD operations for users, menu items, categories, and orders
- Role-based access control (secured endpoints)
- MySQL database integration
- CORS enabled for frontend development

## Technologies Used

- Java 21
- Spring Boot 3
- Spring Security (JWT)
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 21+
- Maven
- MySQL

### Setup

1. **Clone the repository**

   ```sh
   git clone https://github.com/ChouMonyrith/BorgoApi.git
   cd BorgoApi
   ```

2. **Configure the database**

   Update `src/main/resources/application.properties` with your MySQL credentials:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/borgo_db
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   ```

3. **Build and run the application**

   ```sh
   ./mvnw spring-boot:run
   ```

   The API will be available at `http://localhost:8081`.

## API Endpoints

### Authentication

- `POST /api/auth/signup` - Register a new user
- `POST /api/auth/login` - Login and receive JWT token

### Users

- `GET /api/users` - List all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Menu Items

- `GET /api/menu-items` - List all menu items
- `GET /api/menu-items/{id}` - Get menu item by ID
- `POST /api/menu-items` - Create menu item
- `PUT /api/menu-items/{id}` - Update menu item
- `DELETE /api/menu-items/{id}` - Delete menu item
- `GET /api/menu-items/category/{categoryId}` - Get menu items by category

### Categories

- `GET /api/categories` - List all categories
- `GET /api/categories/{id}` - Get category by ID
- `POST /api/categories` - Create category
- `PUT /api/categories/{id}` - Update category
- `DELETE /api/categories/{id}` - Delete category

### Orders

- `GET /api/orders` - List orders for authenticated user
- `GET /api/orders/{id}` - Get order by ID (for authenticated user)
- `POST /api/orders` - Create order
- `PUT /api/orders/{id}` - Update order
- `DELETE /api/orders/{id}` - Delete order

## License

This project is licensed under the Apache License 2.0.
