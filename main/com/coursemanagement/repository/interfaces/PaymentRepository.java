package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Payment;
import java.util.List;
import java.util.UUID;

public interface PaymentRepository {
    void save(Payment payment);

    Payment findById(UUID id);

    List<Payment> findByEnrollmentId(UUID enrollmentId);

    List<Payment> findAll();

}
