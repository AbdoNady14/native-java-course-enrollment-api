package com.coursemanagement.handler;

import com.coursemanagement.dto.requestDTOs.RegisterStudentRequest;
import com.coursemanagement.dto.responseDTOs.StudentResponse;
import com.coursemanagement.service.StudentService;
import com.coursemanagement.util.HttpUtil;
import com.coursemanagement.util.JsonUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.UUID;

public class StudentHandler implements HttpHandler {

    private final StudentService studentService;

    public StudentHandler(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String pathId = HttpUtil.extractPathVariable(exchange, "/api/students");

        if ("POST".equalsIgnoreCase(method) && pathId == null) {
            handleRegister(exchange);
        } else if ("GET".equalsIgnoreCase(method) && pathId != null) {
            handleFindById(exchange, pathId);
        } else {
            HttpUtil.sendEmptyResponse(exchange, 405); // Method Not Allowed
        }
    }

    private void handleRegister(HttpExchange exchange) throws IOException {
        String body = HttpUtil.readRequestBody(exchange);

        String fullName = JsonUtil.getString(body, "fullName");
        String email = JsonUtil.getString(body, "email");
        String password = JsonUtil.getString(body, "password");


        if (fullName == null || email == null || password == null) {
            HttpUtil.sendJsonResponse(exchange, 400, JsonUtil.toErrorJson("Missing required fields"));
            return;
        }

        RegisterStudentRequest request = new RegisterStudentRequest(fullName, email, password);
        StudentResponse response = studentService.registerStudent(request);

        if (response == null) {
            HttpUtil.sendJsonResponse(exchange, 400, JsonUtil.toErrorJson("Invalid input or duplicate email"));
            return;
        }

        HttpUtil.sendJsonResponse(exchange, 201, JsonUtil.toJson(response));
    }

    private void handleFindById(HttpExchange exchange, String idStr) throws IOException {
        try {
            UUID id = UUID.fromString(idStr);
            StudentResponse response = studentService.findStudentById(id);

            if (response == null) {
                HttpUtil.sendJsonResponse(exchange, 404, JsonUtil.toErrorJson("Student not found"));
                return;
            }

            HttpUtil.sendJsonResponse(exchange, 200, JsonUtil.toJson(response));
        } catch (IllegalArgumentException e) {
            HttpUtil.sendJsonResponse(exchange, 400, JsonUtil.toErrorJson("Invalid UUID format"));
        }
    }
}