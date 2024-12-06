package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.ReviewService.ReviewService;
import umc.spring.study.web.dto.ReviewRequest;
import umc.spring.study.web.dto.ReviewResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 작성 API
    @PostMapping
    public ResponseEntity<?> addReview(@Valid @RequestBody ReviewRequest reviewRequest) {
        reviewService.addReview(reviewRequest);
        return ResponseEntity.ok("Review added successfully");
    }

//    @GetMapping("/{storeId}/reviews")
//    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReviewList(@ExistStore @PathVariable(name="storeId") Long storeId) {
//        return null;
//    }

    @GetMapping("/my-reviews")
    public ResponseEntity<ApiResponse<List<ReviewResponseDto>>> getMyReviews(
            @RequestParam(name="memberId") Long memberId) {

        List<ReviewResponseDto> reviews = reviewService.getReviewsByMember(memberId);

        if (reviews.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.<List<ReviewResponseDto>>builder()
                            .isSuccess(true)
                            .code("REVIEW204")
                            .message("작성한 리뷰가 없습니다.")
                            .result(reviews)
                            .build()
            );
        }

        return ResponseEntity.ok(
                ApiResponse.<List<ReviewResponseDto>>builder()
                        .isSuccess(true)
                        .code("REVIEW200")
                        .message("리뷰 목록을 성공적으로 가져왔습니다.")
                        .result(reviews)
                        .build()
        );
    }
}
