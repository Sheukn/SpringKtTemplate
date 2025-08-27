# SpringKt CRUD Template

Simple Spring Boot + Kotlin template for CRUD applications.

## Quick Start

1. **Clone and rename**
```bash
git clone https://github.com/Sheukn/SpringKtTemplate.git your-project
cd your-project
```

2. **Start database**
```bash
docker-compose up -d
```

3. **Run application**
```bash
./gradlew bootRun
```

## What's Included

- ✅ Spring Boot + Kotlin
- ✅ PostgreSQL database
- ✅ Complete User CRUD (Create, Read, Update, Delete)
- ✅ Clean architecture: Controller → Service → Repository
- ✅ Error handling with proper HTTP status codes
- ✅ Docker setup

## Project Structure

```
src/main/kotlin/com/springktskeleton/
├── controller/     # REST endpoints
├── service/        # Business logic  
├── repository/     # Database access
├── entity/         # Database models
├── dto/           # API models
└── mapper/        # Conversions
```

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create user |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

## Example Usage

**Create user:**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"username": "john", "email": "john@example.com"}'
```

**Get all users:**
```bash
curl http://localhost:8080/api/users
```

## Error Handling

- **404 Not Found** - When user doesn't exist
- **201 Created** - User successfully created
- **200 OK** - Successful operations

## Customize for Your Project

1. **Rename package:** Change `com.springktskeleton` to `com.yourproject`
2. **Add new entities:** Copy the User files and modify for your domain
3. **Update database name** in `application.yml`