package umc.spring.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Region;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.repository.RegionRepository.RegionRepository;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        if(filteredStores==null) {
            filteredStores=new ArrayList<>();
        }

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
    @Transactional
    public Store addStore(String regionName, String storeName, String storeAddress, Float score) {
        // 1.지역 조회
        Region region = regionRepository.findByName(regionName)
                .orElseThrow(() -> new IllegalArgumentException("해당 지역을 찾을 수 없습니다: " + regionName));

        // 2. 가게 생성
        Store store = Store.builder()
                .name(storeName)
                .address(storeAddress)
                .score(score)
                .region(region)
                .build();

        // 3. 가게 저장
        return storeRepository.save(store);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }


}

