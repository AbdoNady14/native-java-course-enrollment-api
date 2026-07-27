package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Student;
import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    void save(Student student);

    Student findById(UUID id);

    Student findByEmail(String email);

    List<Student> findAll();

    boolean existsByEmail(String email);

    void deleteById(UUID id);

}
