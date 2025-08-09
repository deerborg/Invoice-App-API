
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

| Field   | Type    |
|---------|---------|
| status  | boolean |
| message | string  |
| data    | UserResponse |

---

### UserResponse

| Field    | Type    |
|----------|---------|
| userId   | string  |
| createAt | string (date-time) |

---

### CreateInvoiceRequest

| Field          | Type   |
|----------------|--------|
| customerName   | string |
| customerEmail  | string |
| totalAmount    | number (double) |
| taxAmount      | number (double) |
| subTotal       | number (double) |
| details        | string |
| userId         | string |

---

### ApiResponseInvoiceDetailsResponse

| Field   | Type    |
|---------|---------|
| status  | boolean |
| message | string  |
| data    | InvoiceDetailsResponse |

---

### InvoiceDetailsResponse

| Field         | Type            |
|---------------|-----------------|
| invoiceId     | integer (int64) |
| customerName  | string          |
| customerEmail | string          |
| totalAmount   | number (double) |
| taxAmount     | number (double) |
| subTotal      | number (double) |
| details       | string          |
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

| Field   | Type    |
|---------|---------|
| status  | boolean |
| message | string  |
| data    | Array of InvoiceDetailsResponse |

