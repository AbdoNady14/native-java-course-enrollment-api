package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Student;
import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    public static void save(Student student);

    public static Student findById(UUID id);

    public static Student findByEmail(String email);

    public static List<Student> findAll();

    public static boolean existsByEmail(String email);

    public static void deleteById(UUID id);

}
