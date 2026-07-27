package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Enrollment;
import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository {
    void save(Enrollment enrollment);

    Enrollment findById(UUID id);

    List<Enrollment> findAll();

    List<Enrollment> findByStudentId(UUID studentId);

    boolean existsByStudentIdAndCourseId(UUID studentId, UUID courseId);

    void deleteById(UUID id);

}
