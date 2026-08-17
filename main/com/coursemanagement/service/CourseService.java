package com.coursemanagement.service;

import com.coursemanagement.dto.mapper.CourseMapper;
import com.coursemanagement.dto.requestDTOs.CreateCourseRequest;
import com.coursemanagement.dto.requestDTOs.UpdateCourseRequest;
import com.coursemanagement.dto.requestDTOs.UpdateCourseStatusRequest;
import com.coursemanagement.dto.responseDTOs.CourseResponse;
import com.coursemanagement.model.Course;
import com.coursemanagement.repository.interfaces.CourseRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse createCourse(CreateCourseRequest request) {
        if (request == null) return null;

        if (request.getTitle() == null || request.getTitle().isBlank()) return null;
        if (request.getDescription() == null || request.getDescription().isBlank()) return null; 
        if (request.getPrice() == null || request.getPrice().compareTo(BigDecimal.ZERO) <= 0) return null;
        if (request.getCapacity() <= 0) return null;

        Course course = CourseMapper.toEntity(request);


        course.setAvailableSeats(request.getCapacity());

        Course savedCourse = courseRepository.save(course);
        return CourseMapper.toResponse(savedCourse);
    }

    public CourseResponse findCourseById(UUID id) {
        if (id == null) return null;

        Course course = courseRepository.findById(id);
        if (course == null) return null;

        return CourseMapper.toResponse(course);
    }

    public List<CourseResponse> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses == null) return new ArrayList<>();

        return courses.stream()
                .map(CourseMapper::toResponse)
                .toList();
    }

    public CourseResponse replaceCourse(UUID id, UpdateCourseRequest request) {
        if (id == null || request == null) return null;

        Course existingCourse = courseRepository.findById(id);
        if (existingCourse == null) return null;

        if (request.getTitle() == null || request.getTitle().isBlank()) return null;
        if (request.getDescription() == null || request.getDescription().isBlank()) return null;
        if (request.getPrice() == null || request.getPrice().compareTo(BigDecimal.ZERO) <= 0) return null;
        if (request.getCapacity() <= 0) return null;

        if (existingCourse.getAvailableSeats() > request.getCapacity()) return null;

        existingCourse.setTitle(request.getTitle());
        existingCourse.setDescription(request.getDescription());
        existingCourse.setPrice(request.getPrice());
        existingCourse.setCapacity(request.getCapacity());

        Course updatedCourse = courseRepository.save(existingCourse);
        return CourseMapper.toResponse(updatedCourse);
    }

    public CourseResponse updateCourseStatus(UUID id, UpdateCourseStatusRequest request) {
        if (id == null || request == null || request.getStatus() == null) return null;

        Course existingCourse = courseRepository.findById(id);
        if (existingCourse == null) return null;

        existingCourse.setStatus(request.getStatus());

        Course updatedCourse = courseRepository.save(existingCourse);
        return CourseMapper.toResponse(updatedCourse);
    }

    public boolean deleteCourse(UUID id) {
        if (id == null) return false;

        Course existingCourse = courseRepository.findById(id);
        if (existingCourse == null) return false;

        courseRepository.deleteById(id);
        return true;
    }
}