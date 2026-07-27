package com.coursemanagement.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Course {
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer capacity;
    private Integer availableSeats;
    private CourseStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Course() {
    }

    public Course(String title, String description, BigDecimal price, Integer capacity, Integer availableSeats, CourseStatus status) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
        this.updatedAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
        this.updatedAt = LocalDateTime.now();
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Course{id=" + id +", title='" + title + "', description='" + description + "', price=" + price +", capacity=" + capacity +", availableSeats=" + availableSeats +", status=" + status +", createdAt=" + createdAt +", updatedAt=" + updatedAt +"}";
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Course course)) return false;
        return this.id.equals(course.getId())&& this.title.equals(course.getTitle())&& this.description.equals(course.getDescription())&& this.price.equals(course.getPrice())&& this.capacity.equals(course.getCapacity())&& this.availableSeats.equals(course.getAvailableSeats())&& this.status.equals(course.getStatus());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
