package com.coursemanagement.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private UUID id;
    private UUID enrollmentId;
    private BigDecimal amount;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
    private String transactionReference;
    private LocalDateTime paymentDate;

    public Payment() {
    }

    public Payment(UUID enrollmentId, BigDecimal amount, String paymentMethod, PaymentStatus paymentStatus, String transactionReference) {
        this.id = UUID.randomUUID();
        this.enrollmentId = enrollmentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.transactionReference = transactionReference;
        this.paymentDate = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(UUID enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{id=" + id +", enrollmentId=" + enrollmentId +", amount=" + amount +", paymentMethod='" + paymentMethod + "', paymentStatus=" + paymentStatus +", transactionReference='" + transactionReference + "', paymentDate=" + paymentDate +"}";
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Payment payment)) return false;
        return this.id.equals(payment.getId())&& this.enrollmentId.equals(payment.getEnrollmentId())&& this.amount.equals(payment.getAmount())&& this.paymentMethod.equals(payment.getPaymentMethod())&& this.paymentStatus.equals(payment.getPaymentStatus())&& this.transactionReference.equals(payment.getTransactionReference());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
