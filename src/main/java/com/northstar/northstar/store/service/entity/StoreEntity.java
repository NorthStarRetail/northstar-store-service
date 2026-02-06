package com.northstar.northstar.store.service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ns_stores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false, length = 36)
    private String uid;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    private String address;

    private String region;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;

    @PrePersist
    private void generateUid() {
        if (uid == null) {
            uid = UUID.randomUUID().toString();
        }
    }
}
