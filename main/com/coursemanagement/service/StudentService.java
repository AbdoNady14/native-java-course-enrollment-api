package com.coursemanagement.service;

import com.coursemanagement.dto.mapper.StudentMapper;
import com.coursemanagement.dto.requestDTOs.RegisterStudentRequest;
import com.coursemanagement.dto.responseDTOs.StudentResponse;
import com.coursemanagement.model.Student;
import com.coursemanagement.repository.InMemoryStudentRepository;

public class StudentService {

    private final InMemoryStudentRepository studentRepository;

    public StudentService(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse registerStudent(RegisterStudentRequest request) {
        // Validation
        if (request.getFullName() == null || request.getFullName().isBlank()) {
            throw new IllegalArgumentException("Full name is required.");
        }
        if (request.getEmail() == null || !request.getEmail().contains("@")) {
            throw new IllegalArgumentException("Valid email is required.");
        }
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }
        if (request.getPassword() == null || request.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }

        // Mapping and saving
        Student student = StudentMapper.toEntity(request);
        Student savedStudent = studentRepository.save(student);

        // Response
        return StudentMapper.toResponse(savedStudent);
    }
}