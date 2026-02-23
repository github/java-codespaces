# Contributing

Thanks for your interest in improving this project.

## Prerequisites

- Java 25
- Maven 3.9+
- VS Code (recommended)

## Local development

1. Compile the app:

   ```bash
   mvn compile -f sample-app/pom.xml
   ```

2. Run the app:

   ```bash
   java --module-path sample-app/target/classes --module com.example.app/com.example.app.Application
   ```

3. Open http://localhost:8080

## Project conventions

- Keep the code framework-agnostic (no Spring or other web frameworks).
- Use Java module system (`module-info.java`) patterns already in the project.
- Prefer small, focused classes and methods.
- Keep frontend changes in `sample-app/src/main/resources/static/`.

## Pull requests

- Use a clear title and description explaining the problem and solution.
- Keep PRs scoped to one concern when possible.
- Update documentation (`README.md`, this file) when behavior or commands change.
- Ensure the project builds before submitting:

  ```bash
  mvn verify -f sample-app/pom.xml
  ```

## Code of conduct

Please be respectful and constructive in discussions and reviews.

## License

By contributing, you agree that your contributions will be licensed under the MIT License in this repository.
