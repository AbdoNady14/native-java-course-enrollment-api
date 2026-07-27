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
        for (Payment payment : paymentList) {
            if (payment.getId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public java.util.List<Payment> findByEnrollmentId(UUID enrollmentId) {
        for (Payment payment : paymentList) {
            if (payment.getEnrollmentId().equals(enrollmentId)) {
                List<Payment> payments = new ArrayList<>();
                payments.add(payment);
                return payments;
            }
        }
        return null;
    }

    @Override
    public java.util.List<Payment> findAll() {
        return new ArrayList<>(paymentList);
    }

}
