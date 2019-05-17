# sparring

This project hosts the code for sparring app which is an app that allows to turn on and off performance issues.

## Build

To build the project is required [java 8+](https://www.java.com/es/download/), [maven 3.5+](https://maven.apache.org/index.html) and [docker 18+](https://www.docker.com/).



To build the project just run `mvn clean package` and docker images (in local registry) will be generated for each component of the application.

## Running

Since the build process generates docker images for each webapp and the database, and we already include a [docker-compose.yml](docker-compose.yml) file, you only have to run `docker-compose up` to get all webapps and db running.

Once all services are up you can access the `web` webapp by accessing `http://localhost:8080` from a browser and the `admin` webapp by accessing `http://localhost:8081`.

Database is accessible through any MySQL client connecting to `localhost` and port `3306` with `root` and `abstracta` credentials.

