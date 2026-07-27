package com.coursemanagement.repository;

import com.coursemanagement.model.Course;
import com.coursemanagement.repository.interfaces.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryCourseRepository implements CourseRepository {
    private static List<Course> courseList = new ArrayList<>();

    @Override
    public void save(Course course) {
        courseList.add(course);
    }

    @Override
    public Course findById(UUID id) {
        for (Course course : courseList) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courseList);
    }

    @Override
    public void deleteById(UUID id) {
        for (Course course : courseList) {
            if (course.getId().equals(id)) {
                courseList.remove(course);
                break;
            }
        }
    }

    @Override
    public boolean existsById(UUID id) {
        for (Course course : courseList) {
            if (course.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
