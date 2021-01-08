curl -i \
-H "Accept: application/json" \
-H "Content-Type: application/json" \
-X POST --data \
  '{"id": 1,"name": "name1"}' "http://localhost:8080/persons/createPerson"
