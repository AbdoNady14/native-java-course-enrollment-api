package com.coursemanagement.dto.mapper;

import com.coursemanagement.dto.requestDTOs.CreateCourseRequest;
import com.coursemanagement.dto.responseDTOs.CourseResponse;
import com.coursemanagement.model.Course;

public class CourseMapper {

    public static Course toEntity(CreateCourseRequest request) {
        if (request == null) {
            return null;
        }

        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setCapacity(request.getCapacity());

        return course;
    }

    public static CourseResponse toResponse(Course course) {
        if (course == null) {
            return null;
        }

        return new CourseResponse(
            course.getId(),
            course.getTitle(),
            course.getDescription(),
            course.getPrice(),
            course.getCapacity(),
            course.getAvailableSeats(),
            course.getStatus(),
            course.getCreatedAt()
        );
    }
}