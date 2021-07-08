# This works
curl http://localhost:8080/products/getfromstring?productString=%7B%22id%22%3A%201%2C%22name%22%3A%20%22Asus%20Zenbook%22%2C%22price%22%3A%201800%7D 

#{"id": 1,"name": "Asus Zenbook","price": 800}
#{\"id\": 1,\"name\": \"Asus Zenbook\",\"price\": 800}
#"{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
#productString=%7B%22id%22%3A%201%2C%22name%22%3A%20%22Asus%20Zenbook%22%2C%22price%22%3A%20800%7D
