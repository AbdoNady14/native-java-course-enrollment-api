package com.coursemanagement.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Enrollment {
    private UUID id;
    private UUID studentId;
    private UUID courseId;
    private BigDecimal originalPrice;
    private Double discountAmount;
    private BigDecimal finalPrice;
    private EnrollmentStatus status;
    private LocalDateTime enrollmentDate;

    public Enrollment() {
    }

    public Enrollment(UUID studentId, UUID courseId, BigDecimal originalPrice, Double discountAmount, BigDecimal finalPrice, EnrollmentStatus status) {
        this.id = UUID.randomUUID();
        this.studentId = studentId;
        this.courseId = courseId;
        this.originalPrice = originalPrice;
        this.discountAmount = discountAmount;
        this.finalPrice = finalPrice;
        this.status = status;
        this.enrollmentDate = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollment{id=" + id +", studentId=" + studentId +", courseId=" + courseId +", originalPrice=" + originalPrice +", discountAmount=" + discountAmount +", finalPrice=" + finalPrice +", status=" + status +", enrollmentDate=" + enrollmentDate +"}";
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Enrollment enrollment)) return false;
        return this.id.equals(enrollment.getId())&& this.studentId.equals(enrollment.getStudentId())&& this.courseId.equals(enrollment.getCourseId())&& this.originalPrice.equals(enrollment.getOriginalPrice())&& this.discountAmount.equals(enrollment.getDiscountAmount())&& this.finalPrice.equals(enrollment.getFinalPrice())&& this.status.equals(enrollment.getStatus());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
