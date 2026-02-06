package com.northstar.northstar.store.service.controller;

import com.northstar.northstar.store.service.dto.StoreRequest;
import com.northstar.northstar.store.service.dto.StoreResponse;
import com.northstar.northstar.store.service.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/stores")
@Tag(name = "Stores", description = "Store Management API")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "Create a new store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Store created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<StoreResponse> createStore(@Valid @RequestBody StoreRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.createStore(request));
    }

    @Operation(summary = "Update an existing store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Store updated"),
            @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<StoreResponse> updateStore(@PathVariable String id, @Valid @RequestBody StoreRequest request) {
        return ResponseEntity.ok(storeService.updateStoreById(id, request));
    }

    @Operation(summary = "Get store by ID")
    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> getStore(@PathVariable String id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    @Operation(summary = "Get all stores")
    @GetMapping
    public ResponseEntity<List<StoreResponse>> getAllStores(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(storeService.getAllStores(PageRequest.of(page, size)));
    }

    @Operation(summary = "Get stores by name")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<StoreResponse>> getStoresByName(@PathVariable String name,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(storeService.getStoresByName(name, PageRequest.of(page, size)));
    }

    @Operation(summary = "Get stores by region")
    @GetMapping("/region/{region}")
    public ResponseEntity<List<StoreResponse>> getStoresByRegion(@PathVariable String region,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(storeService.getStoresByRegion(region, PageRequest.of(page, size)));
    }

    @Operation(summary = "Delete a store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Store deleted"),
            @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable String id) {
        storeService.deleteStoreById(id);
        return ResponseEntity.noContent().build();
    }
}
