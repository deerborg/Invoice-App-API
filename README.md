# Invoice API

> ⚠️ This project is currently under active development. APIs and features are subject to change.

---

### Technologies and Libraries Used

- **Spring Boot 3.5.4** — Main application framework.
- **Java 17** — Language level.
- **Spring Starters:**
    - `spring-boot-starter-web` — REST API development.
    - `spring-boot-starter-data-jpa` — Database interaction using JPA.
    - `spring-boot-starter-security` — Authentication and authorization.
    - `spring-boot-starter-mail` — Sending emails.
    - `spring-boot-starter-amqp` — Messaging with RabbitMQ.
- **Database:** PostgreSQL (`org.postgresql:postgresql`) — runtime driver.
- **JWT:** `jjwt-api`, `jjwt-impl`, `jjwt-jackson` — Token authentication.
- **API Documentation:** `springdoc-openapi-starter-webmvc-ui` — OpenAPI/Swagger.

---

## Additional Integrations

- **RabbitMQ:** Used for asynchronous message handling and audit logging.
- **Email Service:** Sends notification emails upon important events like invoice creation.

*Note: Integration with RabbitMQ and Email service is currently under development and will be added soon.*

---

## pom.xml Summary

```xml
<properties>
    <java.version>17</java.version>
</properties>

<dependencies>
<!-- Spring Boot Starter Dependencies -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>

<!-- Database -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.6</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>

<!-- OpenAPI / Swagger -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>

<!-- Testing -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.amqp</groupId>
    <artifactId>spring-rabbit-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
</dependency>
</dependencies>

```



# API Documentation

---

## User Controller

### POST /api/users/private/register

**Request Body:**

```json
{
  "username": "string",
  "email": "string",
  "password": "string"
}
```

**Response:**

```json
{
  "status": true,
  "message": "string",
  "data": {
    "userId": "string",
    "createAt": "2025-08-09T18:11:16.935Z"
  }
}
```

---

## Invoice Controller

### POST /api/invoices/private

**Request Body:**

```json
{
  "customerName": "string",
  "customerEmail": "string",
  "totalAmount": 0,
  "taxAmount": 0,
  "subTotal": 0,
  "details": "string",
  "userId": "string"
}
```

**Response:**

```json
{
  "status": true,
  "message": "string",
  "data": {
    "invoiceId": 0,
    "customerName": "string",
    "customerEmail": "string",
    "totalAmount": 0,
    "taxAmount": 0,
    "subTotal": 0,
    "details": "string",
    "createdAt": "2025-08-09T18:11:16.936Z"
  }
}
```

---

### GET /api/invoices/private/user/{userId}

**Path Parameter:**

| Name   | Type   | Description |
|--------|--------|-------------|
| userId | string | userId      |

**Response:**

```json
{
  "status": true,
  "message": "string",
  "data": [
    {
      "invoiceId": 0,
      "customerName": "string",
      "customerEmail": "string",
      "totalAmount": 0,
      "taxAmount": 0,
      "subTotal": 0,
      "details": "string",
      "createdAt": "2025-08-09T18:11:16.938Z"
    }
  ]
}
```

---

## Auth Controller

### POST /api/auth/public/authenticate

**Request Body:**

```json
{
  "username": "string",
  "password": "string"
}
```

**Response:**

```json
{
  "token": "string"
}
```

---

## Schemas

### CreateUserRequest

| Field    | Type   |
|----------|--------|
| username | string |
| email    | string |
| password | string |

---

### ApiResponseUserResponse

| Field   | Type         |
|---------|--------------|
| status  | boolean      |
| message | string       |
| data    | UserResponse |

---

### UserResponse

| Field    | Type               |
|----------|--------------------|
| userId   | string             |
| createAt | string (date-time) |

---

### CreateInvoiceRequest

| Field         | Type            |
|---------------|-----------------|
| customerName  | string          |
| customerEmail | string          |
| totalAmount   | number (double) |
| taxAmount     | number (double) |
| subTotal      | number (double) |
| details       | string          |
| userId        | string          |

---

### ApiResponseInvoiceDetailsResponse

| Field   | Type                   |
|---------|------------------------|
| status  | boolean                |
| message | string                 |
| data    | InvoiceDetailsResponse |

---

### InvoiceDetailsResponse

| Field         | Type               |
|---------------|--------------------|
| invoiceId     | integer (int64)    |
| customerName  | string             |
| customerEmail | string             |
| totalAmount   | number (double)    |
| taxAmount     | number (double)    |
| subTotal      | number (double)    |
| details       | string             |
| createdAt     | string (date-time) |

---

### AuthRequest

| Field    | Type   |
|----------|--------|
| username | string |
| password | string |

---

### AuthResponse

| Field | Type   |
|-------|--------|
| token | string |

---

### ApiResponseListInvoiceDetailsResponse

| Field   | Type                            |
|---------|---------------------------------|
| status  | boolean                         |
| message | string                          |
| data    | Array of InvoiceDetailsResponse |

