package umc.spring.study.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.repository.MemberRepository.MemberRepository;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;
import umc.spring.study.web.dto.ReviewRequest;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MemberRepository memberRepository, StoreRepository storeRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.storeRepository = storeRepository;
    }

    public void addReview(ReviewRequest reviewRequest) {
        // Member 검증 및 조회
        Member member = memberRepository.findById(reviewRequest.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        // Store 검증은 @StoreExists 어노테이션으로 처리됨

        // Review 생성 및 저장
        Review review = Review.builder()
                .body(reviewRequest.getBody())
                .score(reviewRequest.getScore())
                .store(storeRepository.getReferenceById(reviewRequest.getStoreId()))
                .member(member)
                .build();

        reviewRepository.save(review);
    }
}
