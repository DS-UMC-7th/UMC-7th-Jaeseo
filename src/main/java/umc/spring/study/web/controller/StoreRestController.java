package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.service.StoreService.StoreQueryService;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    // Operation은 이 api에 대한 설명을 넣게 됨. summary, description으로 설명을 적음
    // ApiResponses로 api의 응답을 담게 되고 내부적으로 @ApiResponse로 각각의 응답들을 담게 됨
    // 스웨거를 통한 api 명세를 하는 중임

    private final StoreQueryService storeQueryService;

//    @GetMapping("/{storeId}/reviews")
//    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
//    })
//
//    @Parameters({
//            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
//    })
//    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
//        storeQueryService.getReviewList(storeId,page);
//        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
//    }
}

