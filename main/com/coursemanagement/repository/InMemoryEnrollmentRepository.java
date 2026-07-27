package com.coursemanagement.repository;

import com.coursemanagement.model.Enrollment;
import com.coursemanagement.repository.interfaces.EnrollmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryEnrollmentRepository implements EnrollmentRepository {
    private static List<Enrollment> enrollmentList = new ArrayList<>();

    @Override
    public void save(Enrollment enrollment) {
        if (findById(enrollment.getId()) != null) {
            System.out.println("Enrollment already exists");
            return;
        }
        enrollmentList.add(enrollment);
    }   

    @Override
    public Enrollment findById(UUID id) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getId().equals(id)) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollmentList);
    }

    @Override
    public List<Enrollment> findByStudentId(UUID studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getStudentId().equals(studentId)) {
                result.add(enrollment);
            }
        }
        return result;
    }

    @Override
    public boolean existsByStudentIdAndCourseId(UUID studentId, UUID courseId) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getStudentId().equals(studentId) && enrollment.getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(UUID id) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getId().equals(id)) {
                enrollmentList.remove(enrollment);
                break;
            }
        }
    }

}