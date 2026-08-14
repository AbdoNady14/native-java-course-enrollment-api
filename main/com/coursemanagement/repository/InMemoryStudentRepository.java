package com.coursemanagement.repository;

import com.coursemanagement.model.Student;
import com.coursemanagement.repository.interfaces.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryStudentRepository implements StudentRepository {

    private static final List<Student> studentList = new ArrayList<>();

    @Override
    public Student save(Student student) {
        studentList.add(student);
        return student;
    }

    @Override
    public Student findById(UUID id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student findByEmail(String email) {   
        for (Student student : studentList) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList);
    }

    @Override
    public boolean existsByEmail(String email) {
        for (Student student : studentList) {
            if (student.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(UUID id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                break;
            }
        }
    }

}
