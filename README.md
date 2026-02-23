# GitHub Codespaces ♥️ Java

Want to try out Java for web development?

This repo builds a Weather App with a REST API (with OpenAPI/Swagger UI) and a web frontend, all in a single Spring Boot application using Thymeleaf.

Everything you do here is contained within this one codespace. There is no repository on GitHub yet. If and when you're ready you can click "Publish Branch" and we'll create your repository and push up your project. If you were just exploring then and have no further need for this code then you can simply delete your codespace and it's gone forever.

### Run Options

[![Open in GitHub Codespaces](https://img.shields.io/static/v1?style=for-the-badge&label=GitHub+Codespaces&message=Open&color=lightgrey&logo=github)](https://codespaces.new/github/java-codespaces)
[![Open in Dev Container](https://img.shields.io/static/v1?style=for-the-badge&label=Dev+Container&message=Open&color=blue&logo=visualstudiocode)](https://vscode.dev/redirect?url=vscode://ms-vscode-remote.remote-containers/cloneInVolume?url=https://github.com/github/java-codespaces)

You can also run this repository locally by following these instructions:
1. Clone the repo to your local machine `git clone https://github.com/github/java-codespaces`
1. Open repo in VS Code

## Getting started

1. **📤 One-click setup**: [Open a new Codespace](https://codespaces.new/github/java-codespaces), giving you a fully configured cloud developer environment.
2. **▶️ Run all, one-click again**: Use VS Code's built-in *Run* command and open the forwarded port *8080* in your browser.

3. The web app will be available on port **8080**. Navigate to **/swagger-ui** for interactive API documentation.

4. **🔄 Iterate quickly:** Codespaces updates the server on each save, and VS Code's debugger lets you dig into the code execution.

5. To stop running, return to VS Code, and click Stop in the debug toolbar.

## Project Structure

```
sample-app/
├── pom.xml              # Maven project
└── src/main/
    ├── java/com/example/app/
    │   ├── Application.java
    │   ├── WeatherForecast.java
    │   ├── WeatherForecastController.java
    │   └── WeatherController.java
    └── resources/
        ├── application.properties
        ├── templates/
        │   ├── index.html
        │   └── error.html
        └── static/css/site.css
```

## Tech Stack

- **Java 25** with Spring Boot 3.5
- **API**: Spring Web + springdoc-openapi (Swagger UI)
- **Web UI**: Thymeleaf + Bootstrap 5
- **Build**: Maven
