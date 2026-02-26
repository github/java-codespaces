package com.example.app;

import java.io.IOException;

public class Application {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws IOException {
        int port = resolvePort();

        var forecastController = new WeatherForecastService();
        var server = new WeatherHttpServer(port, forecastController);

        server.start();
    }

    private static int resolvePort() {
        String portValue = System.getenv("PORT");
        if (portValue == null || portValue.isBlank()) {
            return DEFAULT_PORT;
        }

        try {
            return Integer.parseInt(portValue);
        } catch (NumberFormatException ignored) {
            return DEFAULT_PORT;
        }
    }
}
