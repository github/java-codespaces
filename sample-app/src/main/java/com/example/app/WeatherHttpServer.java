package com.example.app;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class WeatherHttpServer {

    private final int port;
    private final WeatherForecastService forecastController;

    public WeatherHttpServer(int port, WeatherForecastService forecastController) {
        this.port = port;
        this.forecastController = forecastController;
    }

    public void start() throws IOException {
        var server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/api/weatherforecast", new WeatherApiHandler());
        server.createContext("/", new StaticFileHandler());
        server.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        server.start();

        IO.println("Server running at http://localhost:" + port);
    }

    private final class WeatherApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                sendJson(exchange, 405, """
                        {
                          "error": "Method Not Allowed"
                        }
                        """);
                return;
            }

            var payload = forecastController.getWeatherForecast()
                    .stream()
                    .map(WeatherHttpServer::toJson)
                    .collect(Collectors.joining(",\n", "[\n", "\n]"));

            sendJson(exchange, 200, payload);
        }
    }

    private static String toJson(WeatherForecast forecast) {
        return """
                {
                  "date": "%s",
                  "temperatureC": %d,
                  "temperatureF": %d,
                  "summary": "%s"
                }
                """.formatted(
                forecast.date(),
                forecast.temperatureC(),
                forecast.temperatureF(),
                escapeJson(forecast.summary()));
    }

    private static void sendJson(HttpExchange exchange, int statusCode, String payload) throws IOException {
        byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(statusCode, bytes.length);
        try (var responseBody = exchange.getResponseBody()) {
            responseBody.write(bytes);
        }
    }

    private static String escapeJson(String input) {
        return input.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}