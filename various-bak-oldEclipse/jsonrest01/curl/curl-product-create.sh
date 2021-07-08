curl -i \
-H "Accept: application/json" \
-H "Content-Type: application/json" \
-X POST --data \
  '{"id": 1,"name": "Asus Zenbook","price": 800}' "http://localhost:8080/products/create"
