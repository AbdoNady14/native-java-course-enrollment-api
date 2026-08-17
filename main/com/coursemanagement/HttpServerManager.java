package com.coursemanagement;

import com.coursemanagement.handler.*;
import com.coursemanagement.service.*;
import com.coursemanagement.util.HttpUtil;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager {

    private final HttpServer server;

    public HttpServerManager(StudentService studentService, CourseService courseService) throws IOException {
        server = HttpServer.create(new InetSocketAddress(8094), 0);

        server.createContext("/api/health", exchange -> {
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                String healthJson = "{\"status\":\"UP\",\"application\":\"Course Enrollment API\"}";
                HttpUtil.sendJsonResponse(exchange, 200, healthJson);
            } else {
                HttpUtil.sendEmptyResponse(exchange, 405);
            }
        });


        server.createContext("/api/students", new StudentHandler(studentService));
        server.createContext("/api/courses", new CourseHandler(courseService));
        server.createContext("/api/auth", exchange -> HttpUtil.sendEmptyResponse(exchange, 405));
        server.createContext("/api/enrollments", exchange -> HttpUtil.sendEmptyResponse(exchange, 405));
        server.createContext("/api/payments", exchange -> HttpUtil.sendEmptyResponse(exchange, 405));

        server.setExecutor(null);
    }

    public void start() {
        server.start();
        System.out.println("Server started successfully on http://localhost:8094");
    }
}