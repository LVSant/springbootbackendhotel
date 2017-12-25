# SpringBoot Backend Hotel
### API for Hotel Management implemented with Spring Boot Maven based project, storing data with MongoDB and deployed at Heroku.

- This project is used to practice full-stack development, using this as a Backend for a Frontend project that will be built using Angular Framework.
- - [Heroku APP](https://springbootbackendhotel.herokuapp.com/)

## Working Routes
| Method | **Route** | **Description** |
|--------|-------|-------------|
| GET  | [[hotels/all](https://springbootbackendhotel.herokuapp.com/hotels/all)] | Return all created hotels |
| POST | [[hotels](https://springbootbackendhotel.herokuapp.com/hotels/)] | Create a new Hotel, with JSON Object with nested objects Address and Comments as described [here](#required-fields-hotel) |



### Required Fields for creating a Hotel
- In order to create a Hotel object, it's necessary to pass an JSON Object like this below
```
{"id":"5a31dadb1c8ac83cf14513a7","name":"Teste Hotel 2","pricePerNight":425,"address":{"city":"Denver","country":"USA"},"reviews":[{"username":"User 2","rating":70,"approved":false}]}
```

