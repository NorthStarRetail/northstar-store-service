package com.northstar.northstar.store.service.mapper;

import com.northstar.northstar.store.service.dto.StoreRequest;
import com.northstar.northstar.store.service.dto.StoreResponse;
import com.northstar.northstar.store.service.entity.StoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreEntity createStoreEntityFromRequest(StoreRequest request);

    void updateStoreEntityFromRequest(StoreRequest request, @MappingTarget StoreEntity entity);

    StoreResponse createStoreResponseFromEntity(StoreEntity entity);
}
