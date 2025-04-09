# Microservicio - Facultad

Este microservicio gestiona la información de las facultades de una universidad.

## 📦 Base Endpoint

```
http://localhost:8080/api/v1/facultad-service
```

---

## 📄 Modelo de Datos

```json
{
  "id": Long,
  "idDecano": Long,
  "nombre": String (2-50 caracteres)
}
```

---

## 📋 Endpoints

### 🔍 Obtener todas las facultades

**GET** `/facultads`

```bash
curl -X GET http://localhost:8080/api/v1/facultad-service/facultads
```

---

### 📄 Obtener facultades paginadas

**GET** `/facultad/page/{page}`

```bash
curl -X GET http://localhost:8080/api/v1/facultad-service/facultad/page/0
```

---

### 🔎 Buscar facultad por ID

**GET** `/facultads/{id}`

```bash
curl -X GET http://localhost:8080/api/v1/facultad-service/facultads/3
```

---

### ➕ Crear nueva facultad

**POST** `/facultads`

```bash
curl -X POST http://localhost:8080/api/v1/facultad-service/facultads -H "Content-Type: application/json" -d "{\"nombre\":\"Facultad de Psicología\",\"idDecano\":20}"
```

---

### ✏️ Actualizar facultad

**PUT** `/facultads`

```bash
curl -X PUT http://localhost:8080/api/v1/facultad-service/facultads -H "Content-Type: application/json" -d "{\"id\":2,\"nombre\":\"Facultad de Ciencias Naturales\",\"idDecano\":22}"
```

---

### ❌ Eliminar facultad

**DELETE** `/facultads`

```bash
curl -X DELETE http://localhost:8080/api/v1/facultad-service/facultads -H "Content-Type: application/json" -d "{\"id\":5,\"nombre\":\"Facultad de Derecho\",\"idDecano\":18}"
```

---

## ⚠️ Validaciones

- `idDecano`: no puede ser nulo.
- `nombre`: requerido, entre 2 y 50 caracteres.

---

## 🧪 Datos de ejemplo (`import.sql`)

```sql
-- Facultades de ejemplo
INSERT INTO facultad (nombre, id_decano) VALUES ('Facultad de Ingeniería', 10);
INSERT INTO facultad (nombre, id_decano) VALUES ('Facultad de Ciencias', 12);
INSERT INTO facultad (nombre, id_decano) VALUES ('Facultad de Artes', 14);
INSERT INTO facultad (nombre, id_decano) VALUES ('Facultad de Medicina', 15);
INSERT INTO facultad (nombre, id_decano) VALUES ('Facultad de Derecho', 18);
```

---
