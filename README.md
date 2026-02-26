# GitHub Codespaces ♥️ Java

Want to try out Java for web development?

This repo builds a Weather API and a web frontend in a single Java project using the JDK 25 built-in HTTP server (`jdk.httpserver`).

You get both backend and frontend in one place, and where you go from here is up to you.

Everything you do here is contained within this one codespace. There is no repository on GitHub yet. If and when you’re ready you can click "Publish Branch" and we’ll create your repository and push up your project. If you were just exploring then and have no further need for this code then you can simply delete your codespace and it’s gone forever.

### Run Options

[![Open in GitHub Codespaces](https://img.shields.io/static/v1?style=for-the-badge&label=GitHub+Codespaces&message=Open&color=lightgrey&logo=github)](https://codespaces.new/github/java-codespaces)
[![Open in Dev Container](https://img.shields.io/static/v1?style=for-the-badge&label=Dev+Container&message=Open&color=blue&logo=visualstudiocode)](https://vscode.dev/redirect?url=vscode://ms-vscode-remote.remote-containers/cloneInVolume?url=https://github.com/github/java-codespaces)

You can also run this repository locally by following these instructions:
1. Clone the repo to your local machine `git clone https://github.com/github/java-codespaces`
1. Open repo in VS Code

## Getting started

1. **📤 One-click setup**: [Open a new Codespace](https://codespaces.new/github/java-codespaces), giving you a fully configured cloud developer environment.
2. **▶️ Build and run**:
   - Compile: `mvn compile -f sample-app/pom.xml`
   - Start: `java --module-path sample-app/target/classes --module com.example.app/com.example.app.Application`
3. Open the forwarded port **8080** in your browser.
   - Web app: `/`
   - API endpoint: `/api/weatherforecast`
4. **🔄 Iterate quickly:** Update Java, HTML, CSS, or JavaScript files and rerun as needed while using VS Code debugging tools.
5. To stop running, return to VS Code and stop the running process/task.

## Project Structure

```
sample-app/
├── pom.xml
└── src/main/
    ├── java/
    │   ├── module-info.java
    │   └── com/example/app/
    │       ├── Application.java
    │       ├── StaticFileHandler.java
    │       ├── WeatherForecast.java
    │       ├── WeatherForecastService.java
    │       └── WeatherHttpServer.java
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

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for contribution guidelines, local setup, and PR expectations.

## License

This project is licensed under the [MIT License](LICENSE).

## Security

For reporting vulnerabilities and security policy details, see [SECURITY.md](SECURITY.md).

## Support

For support channels and issue-reporting guidance, see [SUPPORT.md](SUPPORT.md).

## Code of Conduct

This project follows the [Code of Conduct](CODE_OF_CONDUCT.md).
