package com.coursemanagement.dto.requestDTOs;

import com.coursemanagement.model.enums.CourseStatus;

public class UpdateCourseStatusRequest {
    private CourseStatus status;

    public UpdateCourseStatusRequest() {
    }

    public UpdateCourseStatusRequest(CourseStatus status) {
        this.status = status;
    }

    public CourseStatus getStatus() { return status; }
    public void setStatus(CourseStatus status) { this.status = status; }
}