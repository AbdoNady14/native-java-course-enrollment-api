package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Enrollment;
import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository {
    public void save(Enrollment enrollment);

    public Enrollment findById(UUID id);

    public List<Enrollment> findAll();

    public List<Enrollment> findByStudentId(UUID studentId);

    public boolean existsByStudentIdAndCourseId(UUID studentId, UUID courseId);

    public void deleteById(UUID id);

}
