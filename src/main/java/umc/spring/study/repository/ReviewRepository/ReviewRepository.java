package umc.spring.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> , ReviewRepositoryCustom {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    // 스프링 데이터 jpa에서 메서드 이름만으로 sql을 만들어주는 기능 활용
    // PageRequest는 페이징과 관련된 옵션이 포함됨

    // 특정 회원의 리뷰 최신순으로 조회하기
    List<Review> findByMember_IdOrderByCreatedAtDesc(Long memberId);
}
