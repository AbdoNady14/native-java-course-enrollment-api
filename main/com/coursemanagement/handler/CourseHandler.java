package com.coursemanagement.handler;

import com.coursemanagement.dto.requestDTOs.CreateCourseRequest;
import com.coursemanagement.dto.responseDTOs.CourseResponse;
import com.coursemanagement.service.CourseService;
import com.coursemanagement.util.HttpUtil;
import com.coursemanagement.util.JsonUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseHandler implements HttpHandler {

    private final CourseService courseService;

    public CourseHandler(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String pathId = HttpUtil.extractPathVariable(exchange, "/api/courses");

        if ("POST".equalsIgnoreCase(method) && pathId == null) {
            handleCreateCourse(exchange);
        } else if ("GET".equalsIgnoreCase(method) && pathId == null) {
            handleGetAllCourses(exchange);
        } else if ("GET".equalsIgnoreCase(method) && pathId != null) {
            handleGetCourseById(exchange, pathId);
        } else {
            HttpUtil.sendEmptyResponse(exchange, 405);
        }
    }

    private void handleCreateCourse(HttpExchange exchange) throws IOException {
        String body = HttpUtil.readRequestBody(exchange);

        String title = JsonUtil.getString(body, "title");
        String description = JsonUtil.getString(body, "description");
        String priceStr = JsonUtil.getString(body, "price");
        BigDecimal price = priceStr != null ? new BigDecimal(priceStr) : null;
        Integer capacity = JsonUtil.getInt(body, "capacity");

        if (title == null || description == null || price == null || capacity == null) {
            HttpUtil.sendJsonResponse(exchange, 400, JsonUtil.toErrorJson("Missing required course fields"));
            return;
        }

        CreateCourseRequest request = new CreateCourseRequest(title, description, price, capacity);
        CourseResponse response = courseService.createCourse(request);

        if (response == null) {
            HttpUtil.sendJsonResponse(exchange, 400, JsonUtil.toErrorJson("Invalid course data"));
            return;
        }

        exchange.getResponseHeaders().set("Location", "/api/courses/" + response.getId());
        HttpUtil.sendJsonResponse(exchange, 201, JsonUtil.toJson(response));
    }

    private void handleGetAllCourses(HttpExchange exchange) throws IOException {
        List<CourseResponse> courses = courseService.findAllCourses();
        HttpUtil.sendJsonResponse(exchange, 200, JsonUtil.courseListToJson(courses));
    }

    private void handleGetCourseById(HttpExchange exchange, String idStr) throws IOException {
        try {
            UUID id = UUID.fromString(idStr);
            CourseResponse response = courseService.findCourseById(id);

            if (response == null) {
                HttpUtil.sendJsonResponse(exchange, 404, JsonUtil.toErrorJson("Course not found"));
                return;
            }

            HttpUtil.sendJsonResponse(exchange, 200, JsonUtil.toJson(response));
        } catch (IllegalArgumentException e) {
            HttpUtil.sendJsonResponse(exchange, 400, JsonUtil.toErrorJson("Invalid UUID format"));
        }
    }
}