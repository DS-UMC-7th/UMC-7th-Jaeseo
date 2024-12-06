package umc.spring.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;

import java.util.List;
import java.util.Optional;


public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long StoreId, Integer page);

    // Page는 Spring Data JPA에서 제공하는 Paging을 위한 추상화를 제공한다.

}
