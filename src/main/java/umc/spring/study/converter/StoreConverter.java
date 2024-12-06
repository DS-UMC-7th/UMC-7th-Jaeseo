package umc.spring.study.converter;

import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    // 기타 코드 (8주차 미션 중 리뷰 추가.. 나는 이렇게 안 만든 듯..)

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
//    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
//
//        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
//                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());
//
//        return StoreResponseDTO.ReviewPreViewListDTO.builder()
//                .isLast(reviewList.isLast())
//                .isFirst(reviewList.isFirst())
//                .totalPage(reviewList.getTotalPages())
//                .totalElements(reviewList.getTotalElements())
//                .listSize(reviewPreViewDTOList.size())
//                .reviewList(reviewPreViewDTOList)
//                .build();
//    }
}
