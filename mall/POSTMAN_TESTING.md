# Postman Testing Guide

Base URL: `http://localhost:8080`

## 1. Mall Controller
**Endpoint:** `/mall`

### Add Mall (POST)
```json
{
  "mallName": "Grand Plaza Mall",
  "location": "Downtown",
  "categories": "Fashion, Electronics, Food"
}
```

### Update Mall (PUT)
```json
{
  "id": 1,
  "mallName": "Grand Plaza Mall Update",
  "location": "Downtown Area",
  "categories": "Fashion, Electronics, Food, Cinema"
}
```

---

## 2. Shop Controller
**Endpoint:** `/shop`

### Add Shop (POST)
**Note:** You must have a Mall created first with ID 1.
```json
{
  "shopCategory": "Electronics",
  "shopName": "Tech World",
  "customers": "All",
  "shopStatus": "Open",
  "leaseStatus": "Active",
  "mall": {
    "id": 1
  }
}
```

---

## 3. Employee Controller
**Endpoint:** `/employee`

### Add Employee (POST)
**Note:** Linked to Shop ID 1
```json
{
  "name": "John Doe",
  "dob": "1990-05-15",
  "salary": 50000.0,
  "address": "123 Main St",
  "designation": "Manager",
  "shop": {
    "shopId": 1
  }
}
```

---

## 4. ShopOwner Controller
**Endpoint:** `/shopOwner`

### Add ShopOwner (POST)
**Note:** Linked to Shop ID 1
```json
{
  "name": "Alice Smith",
  "dob": "1985-08-20",
  "address": "456 Oak Ave",
  "shop": {
    "shopId": 1
  }
}
```

---

## 5. Customer Controller
**Endpoint:** `/customer`

### Add Customer (POST)
```json
{
  "name": "Bob Johnson",
  "phone": "555-0101",
  "email": "bob@example.com"
}
```

---

## 6. User Controller
**Endpoint:** `/user`

### Add User (POST)
**Note:** Linked to Customer ID 1
```json
{
  "name": "bobjohnson",
  "type": "CUSTOMER",
  "password": "securePass123",
  "customer": {
    "id": 1
  }
}
```

---

## 7. Item Controller
**Endpoint:** `/item`

### Add Item (POST)
**Note:** Linked to Mall ID 1
```json
{
  "name": "Smartphone X",
  "manufacturing": "2023-01-01",
  "expiry": "2030-01-01",
  "price": 999.99,
  "category": "Electronics",
  "mall": {
    "id": 1
  }
}
```

---

## 8. OrderDetails Controller
**Endpoint:** `/order`

### Add Order (POST)
**Note:** Linked to Customer ID 1 and Shop ID 1
```json
{
  "dateOfPurchase": "2023-10-25T14:30:00",
  "total": 120.50,
  "paymentMode": "Credit Card",
  "customer": {
    "id": 1
  },
  "shop": {
    "shopId": 1
  }
}
```
