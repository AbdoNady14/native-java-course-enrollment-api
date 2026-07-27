package com.coursemanagement.repository;

import com.coursemanagement.model.Payment;
import com.coursemanagement.repository.interfaces.PaymentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final List<Payment> paymentList = new ArrayList<>();

    @Override
    public void save(Payment payment) {
        paymentList.add(payment);
    }

    @Override
    public Payment findById(UUID id) {      
    // Implementation for finding payment by ID in memory
            return null;
    }

    @Override
    public java.util.List<Payment> findByEnrollmentId(UUID enrollmentId) {
        // Implementation for finding payments by enrollment ID in memory
        return null;
    }

    @Override
    public java.util.List<Payment> findAll() {
        // Implementation for finding all payments in memory
        return null;
    }

}
