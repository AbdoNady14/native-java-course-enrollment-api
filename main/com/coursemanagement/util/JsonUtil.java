package com.coursemanagement.util;

import com.coursemanagement.dto.responseDTOs.CourseResponse;
import com.coursemanagement.dto.responseDTOs.StudentResponse;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtil {

    public static String getString(String json, String key) {
        Pattern pattern = Pattern.compile("\"" + key + "\":\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(json);
        return matcher.find() ? unescape(matcher.group(1)) : null;
    }

    public static Integer getInt(String json, String key) {
        Pattern pattern = Pattern.compile("\"" + key + "\":\\s*(\\d+)");
        Matcher matcher = pattern.matcher(json);
        return matcher.find() ? Integer.parseInt(matcher.group(1)) : null;
    }

    public static Double getDouble(String json, String key) {
        Pattern pattern = Pattern.compile("\"" + key + "\":\\s*(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(json);
        return matcher.find() ? Double.parseDouble(matcher.group(1)) : null;
    }

    public static String escape(String input) {
        if (input == null) return "";
        return input.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r");
    }

    private static String unescape(String input) {
        return input.replace("\\\"", "\"").replace("\\\\", "\\");
    }

    public static String toErrorJson(String message) {
        return "{\"error\":\"" + escape(message) + "\"}";
    }


    public static String toJson(StudentResponse student) {
        if (student == null) return "{}";
        return String.format(
            "{\"id\":\"%s\",\"fullName\":\"%s\",\"email\":\"%s\"}",
            student.getId(), escape(student.getFullName()), escape(student.getEmail())
        );
    }

    public static String toJson(CourseResponse course) {
        if (course == null) return "{}";
        return String.format(
            "{\"id\":\"%s\",\"title\":\"%s\",\"description\":\"%s\",\"price\":%.2f,\"capacity\":%d,\"availableSeats\":%d,\"status\":\"%s\"}",
            course.getId(), escape(course.getTitle()), escape(course.getDescription()),
            course.getPrice(), course.getCapacity(), course.getAvailableSeats(), course.getStatus()
        );
    }


    public static String courseListToJson(List<CourseResponse> courses) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < courses.size(); i++) {
            sb.append(toJson(courses.get(i)));
            if (i < courses.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}