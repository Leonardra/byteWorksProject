# ServByte

ServByte helps users with the options of accessing different service categories including food, laundry, pharmacy, and grocery. This application enables users to search for restaurants by city and purchase meals from their restaurant of choice.


# Installation

## Prerequisites
* Java 8 and above
* Maven > 3.8
* Spring Initializer
* H2 database for testing
* IDE (IntelliJ or Eclipse or VSCode)

## Steps
* Clone the repo from [here](https://github.com/Leonardra/byteWorksProject
* cd byteWorksProject
```bash
cd byteWorksProject\servByteBackend
```
* Run the following command to build
```bash
mvn clean install
```
* To run, the following command:
```bash
java -jar ./target/servByte.jar
```

## Rest API Usage
### Search Restaurant By City
## GET: (http://localhost:8081/api/v1/restaurants/{city})

### Description: The value is passed as a query parameter. It returns a list of restaurants in the city. If the city does not exist in the database, it returns a Bad_Request error.

### Example Response - Success

```shell
 "status": "Success",
    "data": {
        "restaurants": [
            {
                "id": 2,
                "restaurantName": "Crunchies",
                "emailAddress": "crunchiesng@yahoo.com",
                "phoneNumber": "09068685949",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "city": "LAGOS",
                "logoUrl": "https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Crunchies_jl7sbn.png"
            },
            {
                "id": 3,
                "restaurantName": "The Real Jollof Co.",
                "emailAddress": "thejollofco@gmail.com",
                "phoneNumber": "09126363732",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "city": "LAGOS",
                "logoUrl": "https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_Real_Jollof_Co_aeeny5.png"
            },
            {
                "id": 5,
                "restaurantName": "The Place",
                "emailAddress": "theplace@gmail.com",
                "phoneNumber": "091263637880",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "city": "LAGOS",
                "logoUrl": "https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_place_jxuckq.png"
            }

         ]
     }
}
```

### Example Error Response

```shell
{
    "timestamp": "2022-05-19T16:17:37.072+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/api/v1/restaurants/lag"
}
```

### Get all meals in a Restaurant
## GET: http://localhost:8081/api/v1/restaurant/{restaurantId}/meals)

### Description: The value is passed as a path variable. It returns a list of meals offered by a restaurant in the city.

```shell
{
    "status": "success",
    "data": {
        "totalNumberOfMeals": 2,
        "meals": [
            {
                "id": 13,
                "mealName": "Semo and Egusi",
                "imageUrl": "https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/4_px9t0w.jpg",
                "price": 15000.00,
                "preparationTimeInMinutes": 30,
                "description": "The soup is made with pieces of beef, ponmo, goat meat, dry fish and stockfish. Medium heat and very tasty too. This is a perfect meal combo for swallow lovers!",
                "restaurant": {
                    "id": 2,
                    "restaurantName": "Crunchies",
                    "emailAddress": "crunchiesng@yahoo.com",
                    "phoneNumber": "09068685949",
                    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    "city": "LAGOS",
                    "logoUrl": "https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Crunchies_jl7sbn.png"
                }
            },
            {
                "id": 14,
                "mealName": "Jollof Rice",
                "imageUrl": "https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/2_ik2r6f.jpg",
                "price": 20000.00,
                "preparationTimeInMinutes": 30,
                "description": "Jollof, or jollof rice, is a rice dish from Senegal. The dish is typically made with long-grain rice, tomatoes, onions, spices, vegetables and meat in a single pot, although its ingredients and preparation methods vary across different regions",
                "restaurant": {
                    "id": 2,
                    "restaurantName": "Crunchies",
                    "emailAddress": "crunchiesng@yahoo.com",
                    "phoneNumber": "09068685949",
                    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    "city": "LAGOS",
                    "logoUrl": "https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Crunchies_jl7sbn.png"
                }
            }
        ]
    }
}
```


### Make Payment
## POST: (http://localhost:8081/api/v1/initializeTransaction)
### Description: This endpoint makes a post request to a payment gateway to initialize an order payment. The price in kobo and the email of the customer are passed as an object. The response contains an authorization URL that the user is redirected to.


### Example request
```shell
{
    "amount":20000,
    "email":"example@gmail.com"
}
```

### Example Response

```shell
{
    "status": "true",
    "message": "Authorization URL created",
    "data": {
        "authorization_url": "https://checkout.paystack.com/7f3n18y2ggqe9lm",
        "access_code": "xxxxxxxx",
        "reference": "iffj4xm0qp"
    }
}
```
