package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.MissionService.MissionService;
import umc.spring.study.web.dto.MissionChallengeRequest;
import umc.spring.study.web.dto.MissionResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;



    @PostMapping("/challenge")
    public ResponseEntity<String> challengeMission(@RequestBody @Valid MissionChallengeRequest request) {
        // MissionService의 challengeMission 호출
        missionService.challengeMission(request.getMemberId(), request.getMissionId());

        return ResponseEntity.status(HttpStatus.CREATED).body("미션 도전에 성공했습니다.");
    }

    // 특정 가게의 미션 목록 조회
    @GetMapping("/{storeId}")
    public ResponseEntity<ApiResponse<List<MissionResponseDto>>> getMissionsByStore(@PathVariable("storeId") Long storeId) {
        List<MissionResponseDto> missions = missionService.getMissionsByStore(storeId);

        return ResponseEntity.ok(
                ApiResponse.<List<MissionResponseDto>>builder()
                        .isSuccess(true)
                        .code("MISSION200")
                        .message("미션 목록을 성공적으로 가져왔습니다.")
                        .result(missions)
                        .build()
        );
    }
}
