package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.MemberMissionService.MemberMissionService;
import umc.spring.study.web.dto.MemberMissionResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;


    // 내가 진행중인 미션 목록 조회하기
    @GetMapping("/{memberId}/missions")
    public ResponseEntity<ApiResponse<List<MemberMissionResponseDto>>> getInProgressMissions(@PathVariable("memberId") Long memberId) {
        List<MemberMissionResponseDto> missions = memberMissionService.getInProgressMissions(memberId);

        return ResponseEntity.ok(
                ApiResponse.<List<MemberMissionResponseDto>>builder()
                        .isSuccess(true)
                        .code("MISSION200")
                        .message("진행 중인 미션 목록을 성공적으로 가져왔습니다.")
                        .result(missions)
                        .build()
        );
    }
}
