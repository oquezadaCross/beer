# Beer Provider

A rest application to find store in a determinate area.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You get a copy and run the project you will need

* git
* maven
* mongo
* java 8
* Docker

### Mongo

#### Installing with docker 

Download the latest mongo image from docker hub.

```docker
docker pull mongo:3.4
```
Later build the image:

```docker
docker run --name mongo -e MONGO_INITDB_ROOT_USERNAME=cross -e MONGO_INITDB_ROOT_PASSWORD=cross -p 27017:27017 -d mongo:3.4
```

There you have to set the credentials and the port to make the connection from the application. If you change there, you will need to change it in the properties of the application.

#### Database configuration

Create the database "test" and insert the next document in the "partners" collection:

```json
{
        "tradingName": "Adega da Cerveja - Pinheiros",
        "ownerName": "Zé da Silva",
        "document": "1432132123891/0001",
        "coverageArea": { 
          "type": "MultiPolygon", 
          "coordinates": [
            [[[30, 20], [45, 40], [10, 40], [30, 20]]], 
            [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]
          ]
        },
        "address": { 
          "type": "Point",
          "coordinates": [-46.57421, -21.785741]
        },
    }
```

Finally create the index (ensure you are using test database):
```json
db.partners.createIndex({"address":"2dsphere"})
```

### Running the app (Maven)
In the application directory you have to install the dependencies with the next command:

```maven
mvn install
```

Now you can run the app with the next command:

```maven
mvn spring-boot:run
```

If you need to change some properties, you can do it in the application.yml file in src/main/resources directory.

By default the app run in 8080 port.

### Using the app

##### Create partner (POST: api/v1/partner)

```json
 {
        "tradingName": "Adega da Cerveja - Pinheiros",
        "ownerName": "Zé da Silva",
        "document": "1432132123891/0001",
        "coverageArea": { 
          "type": "MultiPolygon", 
          "coordinates": [
            [
            	[
            		[30, 20], [45, 40], [10, 40], [30, 20]
            	]
            ], 
            [
            	[
            		[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]
            	]
            ]
          ]
        }, 
        "address": { 
          "type": "Point",
          "coordinates": [-46.57421, -21.785741]
    }
 }
```
The app will return the partner with the id.
    
##### Get partner by id (GET: api/v1/partner/{id})

http://localhost:8080/api/v1/partner/5dee6f90d00dee54a0ebef99

##### Search partner (GET: api/v1/partner/{lng}/{lat})

http://localhost:8080/api/v1/partner/13/12

