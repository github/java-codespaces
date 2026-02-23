# GitHub Codespaces ♥️ Java

This repository is a weather app built on the JDK 25 built-in HTTP server.

It serves:
- a REST API at `/api/weatherforecast`
- static frontend assets (`index.html`, CSS, JavaScript)

## Run

1. Compile:

    mvn compile -f sample-app/pom.xml

2. Start:

    java --module-path sample-app/target/classes --module com.example.app/com.example.app.Application

3. Open in browser:

    http://localhost:8080

## API

- `GET /api/weatherforecast` returns a 5-day forecast JSON payload.

## Project Structure

```
sample-app/
├── pom.xml
└── src/main/
     ├── java/com/example/app/
     │   ├── Application.java
     │   ├── StaticFileHandler.java
     │   ├── WeatherForecast.java
     │   ├── WeatherForecastService.java
     │   └── WeatherHttpServer.java
     └── resources/static/
          ├── index.html
          ├── css/site.css
          └── js/app.js
```

## Tech Stack

- Java 25
- JDK `HttpServer` (`jdk.httpserver` module)
- Vanilla JavaScript + Bootstrap 5
- Apache Maven
