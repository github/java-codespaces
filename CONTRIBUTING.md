# Contributing

Thanks for your interest in improving this project. Below you'll find everything you need to get started.

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

4. Verify the build (compile + test):

   ```bash
   mvn verify -f sample-app/pom.xml
   ```

## Project conventions

- Keep the code framework-agnostic (no Spring or other web frameworks).
- Use Java module system (`module-info.java`) patterns already in the project.
- Prefer small, focused classes and methods.
- Keep frontend changes in `sample-app/src/main/resources/static/`.

## Reporting issues

Before opening a new issue, please search existing issues to avoid duplicates.

Use the appropriate issue template:

- **Bug report** – something isn't working as expected.
- **Feature request** – you have an idea for an improvement or new capability.

Provide as much context as possible: steps to reproduce, expected vs. actual behavior, Java and Maven versions, and any relevant logs or screenshots.

## Pull request process

1. Fork the repository and create a branch from `main` (e.g. `fix/my-bug` or `feat/my-feature`).
2. Make your changes, keeping the PR scoped to a single concern.
3. Ensure the project builds and tests pass:

   ```bash
   mvn verify -f sample-app/pom.xml
   ```

4. Update `README.md` or this file if behavior or commands change.
5. Open the pull request against `main`, fill in the PR template, and link any related issues.
6. A maintainer will review your PR. Please respond to review comments promptly; PRs with no activity for 30 days may be closed.

## Code of conduct

This project follows the [Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md). Please be respectful and constructive in all discussions and reviews.

## License

By contributing, you agree that your contributions will be licensed under the MIT License in this repository.
