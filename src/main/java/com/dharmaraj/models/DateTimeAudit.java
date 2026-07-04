package com.dharmaraj.models;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateTimeAudit extends BaseModel {

    private LocalDateTime createdAt;

    @PrePersist
    public void setCreatedAt() {

        this.createdAt = LocalDateTime.now();
    }
}
