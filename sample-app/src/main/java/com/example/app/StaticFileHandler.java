package com.example.app;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class StaticFileHandler implements HttpHandler {

    private static final Map<String, String> MIME_TYPES = Map.of(
            "html", "text/html; charset=utf-8",
            "css", "text/css; charset=utf-8",
            "js", "application/javascript; charset=utf-8",
            "json", "application/json; charset=utf-8",
            "png", "image/png",
            "svg", "image/svg+xml",
            "ico", "image/x-icon");

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            sendText(exchange, 405, "Method Not Allowed");
            return;
        }

        var requestUri = exchange.getRequestURI();
        var rawPath = requestUri.getPath();
        var path = (rawPath == null || "/".equals(rawPath)) ? "/index.html" : rawPath;

        if (path.contains("..")) {
            sendText(exchange, 400, "Bad Request");
            return;
        }

        var resourcePath = "/static" + path;
        try (InputStream stream = StaticFileHandler.class.getResourceAsStream(resourcePath)) {
            if (stream == null) {
                sendText(exchange, 404, "Not Found");
                return;
            }

            var bytes = stream.readAllBytes();
            var headers = exchange.getResponseHeaders();
            headers.set("Content-Type", resolveMimeType(path));
            exchange.sendResponseHeaders(200, bytes.length);
            try (var output = exchange.getResponseBody()) {
                output.write(bytes);
            }
        }
    }

    private static void sendText(HttpExchange exchange, int statusCode, String payload) throws IOException {
        var bytes = payload.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
        exchange.sendResponseHeaders(statusCode, bytes.length);
        try (var responseBody = exchange.getResponseBody()) {
            responseBody.write(bytes);
        }
    }

    private static String resolveMimeType(String path) {
        int extensionIndex = path.lastIndexOf('.');
        if (extensionIndex < 0 || extensionIndex == path.length() - 1) {
            return "application/octet-stream";
        }
        var extension = path.substring(extensionIndex + 1).toLowerCase();
        return MIME_TYPES.getOrDefault(extension, "application/octet-stream");
    }
}
