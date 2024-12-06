package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.domain.Store;
import umc.spring.study.service.StoreService.StoreQueryServiceImpl;
import umc.spring.study.web.dto.AddStoreRequest;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreQueryServiceImpl storeService;

    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody AddStoreRequest request) {

        Store store = storeService.addStore(
                request.getRegionName(),
                request.getStoreName(),
                request.getStoreAddress(),
                request.getScore()
        );
        return ResponseEntity.ok(store);

    }

//    @GetMapping
//    public ResponseEntity<List<Store>> getAllStores() {
//        List<Store> stores=storeService.getAllStores();
//        return ResponseEntity.ok(stores);
//    }


}
