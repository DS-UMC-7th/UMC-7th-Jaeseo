package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.service.MissionService.MissionService;
import umc.spring.study.web.dto.MissionChallengeRequest;

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
}
