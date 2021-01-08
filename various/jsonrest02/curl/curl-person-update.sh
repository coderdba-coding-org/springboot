curl -i \
-H "Accept: application/json" \
-H "Content-Type: application/json" \
-X POST --data \
  '{"id": 2,"name": "name2"}' "http://localhost:8080/persons/updatePerson"
