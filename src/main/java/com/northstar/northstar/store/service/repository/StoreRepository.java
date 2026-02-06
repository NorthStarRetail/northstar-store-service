package com.northstar.northstar.store.service.repository;

import com.northstar.northstar.store.service.entity.StoreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

    Optional<StoreEntity> findByUid(String uid);

    Page<StoreEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<StoreEntity> findByRegionContainingIgnoreCase(String region, Pageable pageable);
}
