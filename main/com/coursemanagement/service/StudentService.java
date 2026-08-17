package com.coursemanagement.service;

import com.coursemanagement.dto.mapper.StudentMapper;
import com.coursemanagement.dto.requestDTOs.RegisterStudentRequest;
import com.coursemanagement.dto.responseDTOs.StudentResponse;
import com.coursemanagement.model.Student;
import com.coursemanagement.repository.InMemoryStudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentService {

    private final InMemoryStudentRepository studentRepository;

    public StudentService(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse registerStudent(RegisterStudentRequest request) {
        // Validation
        if (request.getFullName() == null||request.getFullName().isBlank()
        ||request.getEmail().isBlank()||request.getEmail() == null||!request.getEmail().contains("@")
        ||studentRepository.existsByEmail(request.getEmail())
        ||request.getPassword() == null||request.getPassword().length() < 6) {
            return null;
        }
        // Mapping and saving
        Student student = StudentMapper.toEntity(request);
        Student savedStudent = studentRepository.save(student);

        // Response
        return StudentMapper.toResponse(savedStudent);
    }

    public StudentResponse findStudentById(UUID id) {
        if (id == null) return null;

        Student student = studentRepository.findById(id);
        if (student == null) return null;

        return StudentMapper.toResponse(student);
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        if (students == null) return new ArrayList<>();

        return students.stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

}
