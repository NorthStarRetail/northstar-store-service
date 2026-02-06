package com.northstar.northstar.store.service.mapper;

import com.northstar.northstar.store.service.dto.StoreRequest;
import com.northstar.northstar.store.service.dto.StoreResponse;
import com.northstar.northstar.store.service.entity.StoreEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-06T15:49:55+0000",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Azul Systems, Inc.)"
)
@Component
public class StoreMapperImpl implements StoreMapper {

    @Override
    public StoreEntity createStoreEntityFromRequest(StoreRequest request) {
        if ( request == null ) {
            return null;
        }

        StoreEntity.StoreEntityBuilder storeEntity = StoreEntity.builder();

        storeEntity.name( request.getName() );
        storeEntity.address( request.getAddress() );
        storeEntity.region( request.getRegion() );

        return storeEntity.build();
    }

    @Override
    public void updateStoreEntityFromRequest(StoreRequest request, StoreEntity entity) {
        if ( request == null ) {
            return;
        }

        entity.setName( request.getName() );
        entity.setAddress( request.getAddress() );
        entity.setRegion( request.getRegion() );
    }

    @Override
    public StoreResponse createStoreResponseFromEntity(StoreEntity entity) {
        if ( entity == null ) {
            return null;
        }

        StoreResponse.StoreResponseBuilder storeResponse = StoreResponse.builder();

        storeResponse.id( entity.getId() );
        storeResponse.uid( entity.getUid() );
        storeResponse.name( entity.getName() );
        storeResponse.address( entity.getAddress() );
        storeResponse.region( entity.getRegion() );
        storeResponse.creationTime( entity.getCreationTime() );

        return storeResponse.build();
    }
}
