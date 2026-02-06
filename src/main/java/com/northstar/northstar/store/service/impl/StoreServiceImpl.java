package com.northstar.northstar.store.service.impl;

import com.northstar.northstar.store.service.dto.StoreRequest;
import com.northstar.northstar.store.service.dto.StoreResponse;
import com.northstar.northstar.store.service.entity.StoreEntity;
import com.northstar.northstar.store.service.exception.StoreNotFoundException;
import com.northstar.northstar.store.service.mapper.StoreMapper;
import com.northstar.northstar.store.service.repository.StoreRepository;
import com.northstar.northstar.store.service.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    @Override
    public StoreResponse createStore(StoreRequest request) {
        StoreEntity entity = storeMapper.createStoreEntityFromRequest(request);
        StoreEntity saved = storeRepository.save(entity);
        return storeMapper.createStoreResponseFromEntity(saved);
    }

    @Override
    public StoreResponse updateStoreById(String id, StoreRequest request) {
        StoreEntity entity = storeRepository.findByUid(id)
                .orElseThrow(() -> new StoreNotFoundException("Store not found with uid: " + id));
        storeMapper.updateStoreEntityFromRequest(request, entity);
        return storeMapper.createStoreResponseFromEntity(storeRepository.save(entity));
    }

    @Override
    public StoreResponse getStoreById(String id) {
        return storeRepository.findByUid(id)
                .map(storeMapper::createStoreResponseFromEntity)
                .orElseThrow(() -> new StoreNotFoundException("Store not found with uid: " + id));
    }

    @Override
    public List<StoreResponse> getAllStores(Pageable pageable) {
        return storeRepository.findAll(pageable).getContent()
                .stream().map(storeMapper::createStoreResponseFromEntity).toList();
    }

    @Override
    public List<StoreResponse> getStoresByName(String name, Pageable pageable) {
        return storeRepository.findByNameContainingIgnoreCase(name, pageable).getContent()
                .stream().map(storeMapper::createStoreResponseFromEntity).toList();
    }

    @Override
    public List<StoreResponse> getStoresByRegion(String region, Pageable pageable) {
        return storeRepository.findByRegionContainingIgnoreCase(region, pageable).getContent()
                .stream().map(storeMapper::createStoreResponseFromEntity).toList();
    }

    @Override
    public void deleteStoreById(String id) {
        StoreEntity entity = storeRepository.findByUid(id)
                .orElseThrow(() -> new StoreNotFoundException("Store not found with uid: " + id));
        storeRepository.delete(entity);
    }
}
