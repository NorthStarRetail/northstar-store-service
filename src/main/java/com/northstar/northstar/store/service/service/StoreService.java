package com.northstar.northstar.store.service.service;

import com.northstar.northstar.store.service.dto.StoreRequest;
import com.northstar.northstar.store.service.dto.StoreResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    StoreResponse createStore(StoreRequest request);

    StoreResponse updateStoreById(String id, StoreRequest request);

    StoreResponse getStoreById(String id);

    List<StoreResponse> getAllStores(Pageable pageable);

    List<StoreResponse> getStoresByName(String name, Pageable pageable);

    List<StoreResponse> getStoresByRegion(String region, Pageable pageable);

    void deleteStoreById(String id);
}
