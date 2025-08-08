# Product Management API

A Spring Boot REST API for managing products, including CRUD operations and image uploads.

## Features

- **Get all products** – Retrieve a list of all products.
- **Get product by ID** – Retrieve a specific product by its ID.
- **Add new product** – Add a product with an image.
- **Update product** – Update an existing product's details and image.
- **Delete product** – Remove a product by ID.
- **Search products** – Search products by keyword.

## Technologies Used

- **Java** (Spring Boot)
- **Spring Web**
- **Spring Data JPA**
- **Multipart file handling**
- **REST API principles**

## Endpoints

| Method | Endpoint                  | Description                              |
|--------|----------------------------|------------------------------------------|
| GET    | `/start`                   | Returns a simple "Hello World" message   |
| GET    | `/products`                 | Get all products                         |
| GET    | `/product/{id}`             | Get a product by ID                      |
| POST   | `/addproduct/`              | Add a new product with an image          |
| PUT    | `/update/{id}`              | Update product details and image         |
| DELETE | `/delete/{id}`              | Delete a product by ID                   |
| GET    | `/product/search?keyword=...` | Search products by keyword               |

## Request Examples

### Add a Product
**POST** `/addproduct/`  
Content-Type: `multipart/form-data`

**Body:**
- `product` – JSON object containing product details
- `image` – image file

```json
// product (as JSON in multipart request)
{
  "name": "Laptop",
  "price": 1200.50,
  "description": "High performance laptop"
}
    
