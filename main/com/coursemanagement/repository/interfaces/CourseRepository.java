package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Course;
import java.util.List;
import java.util.UUID;

public interface CourseRepository {
    public void save(Course course);

    public Course findById(UUID id);

    public List<Course> findAll();

    public void deleteById(UUID id);

    public boolean existsById(UUID id);

}
