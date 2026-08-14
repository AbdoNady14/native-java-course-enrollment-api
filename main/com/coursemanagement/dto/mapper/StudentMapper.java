package com.coursemanagement.dto.mapper;

import com.coursemanagement.dto.requestDTOs.RegisterStudentRequest;
import com.coursemanagement.dto.responseDTOs.StudentResponse;
import com.coursemanagement.model.Student;
import com.coursemanagement.model.enums.Role;

public class StudentMapper {

    public static Student toEntity(RegisterStudentRequest request) {
        if (request == null) {
            return null;
        }

        return new Student(request.getFullName(),request.getEmail(),request.getPassword(),Role.STUDENT,true);
    }

    // البيانات الخارجه بدون الباسورد
    public static StudentResponse toResponse(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFullName(student.getFullName());
        response.setEmail(student.getEmail());
        response.setRole(student.getRole());
        response.setActive(student.isActive());
        response.setCreatedAt(student.getCreatedAt());

        return response;
    }
}