package com.coursemanagement.dto.mapper;

import com.coursemanagement.dto.requestDTOs.RegisterStudentRequest;
import com.coursemanagement.dto.responseDTOs.LoginResponse;
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


    public static StudentResponse toResponse(Student student) {
        if (student == null) {
            return null;
        }

        return new StudentResponse(student.getId(),student.getFullName(),student.getEmail(),student.getRole(),student.isActive(),student.getCreatedAt());
    }

    public static LoginResponse toLoginResponse(Student student, String message) {
    if (student == null) {
        return null;
    }

    return new LoginResponse(student.getId(),student.getFullName(),student.getEmail(),student.getRole(),message);
    }
}