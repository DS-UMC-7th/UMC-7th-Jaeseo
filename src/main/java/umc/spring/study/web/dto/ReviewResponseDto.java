package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.study.domain.Review;

import java.time.LocalDateTime;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {

    private Long id; // 리뷰 ID
    private String body; // 리뷰 내용
    private Float score; //별점
    private String storeName; // 가게 이름
    private String memberName;
    private LocalDateTime createdAt; //생성일

    public static ReviewResponseDto fromEntity(Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .body(review.getBody())
                .score(review.getScore())
                .storeName(review.getStore().getName()) // Store 엔티티의 이름
                .memberName(review.getMember().getName()) // Member 엔티티의 이름
                .createdAt(review.getCreatedAt())
                .build();
    }

}
