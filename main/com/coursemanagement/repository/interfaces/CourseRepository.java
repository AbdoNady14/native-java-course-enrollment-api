package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Course;
import java.util.List;
import java.util.UUID;

public interface CourseRepository {
    void save(Course course);

    Course findById(UUID id);

    List<Course> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);

}
