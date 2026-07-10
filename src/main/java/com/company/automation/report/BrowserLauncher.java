package com.company.automation.report;

import com.sun.net.httpserver.HttpServer;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public final class BrowserLauncher {

    private BrowserLauncher() {
    }

    public static void open() throws Exception {
        startServer();
        Desktop.getDesktop().browse(
                new java.net.URI("http://localhost:8080")
        );
    }

    private static void startServer() throws IOException {
        HttpServer server =
                HttpServer.create(
                        new InetSocketAddress(8080),
                        0
                );

        server.createContext("/", exchange -> {
            Path root =
                    Path.of("reports");
            String request =
                    exchange.getRequestURI().getPath();

            if (request.equals("/")) {
                request = "/index.html";
            }

            Path file =
                    root.resolve(
                            request.substring(1)
                    );

            if (!Files.exists(file)) {
                exchange.sendResponseHeaders(404, -1);
                return;
            }

            byte[] bytes =
                    Files.readAllBytes(file);
            exchange.sendResponseHeaders(
                    200,
                    bytes.length
            );

            try (OutputStream os =
                         exchange.getResponseBody()) {

                os.write(bytes);
            }
        });

        server.start();

        System.out.println(
                "Dashboard running at http://localhost:8080"
        );
    }
}