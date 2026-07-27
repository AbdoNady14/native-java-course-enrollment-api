package com.coursemanagement.repository.interfaces;

import com.coursemanagement.model.Payment;
import java.util.List;
import java.util.UUID;

public interface PaymentRepository {
    public void save(Payment payment);

    public Payment findById(UUID id);

    public List<Payment> findByEnrollmentId(UUID enrollmentId);

    public List<Payment> findAll();

}
