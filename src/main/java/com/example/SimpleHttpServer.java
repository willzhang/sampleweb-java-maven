package com.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        // 创建 HTTP 服务器，监听端口 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 设置处理路径和处理器
        server.createContext("/", new RootHandler());

        // 启动服务器
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // 构建响应内容，使用 Gson 将对象转换为 JSON
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("message", "Hello, World!");

            Gson gson = new Gson();
            String jsonResponse = gson.toJson(responseMap);

            // 设置响应头和状态码
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

            // 发送响应
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(jsonResponse.getBytes());
            }
        }
    }
}
