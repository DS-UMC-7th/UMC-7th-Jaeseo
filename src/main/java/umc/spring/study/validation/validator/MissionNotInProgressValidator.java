package umc.spring.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepositoryCustomImpl;
import umc.spring.study.validation.annotation.MissionNotInProgress;
@Component
@RequiredArgsConstructor
public class MissionNotInProgressValidator implements ConstraintValidator<MissionNotInProgress, Long> {

    private final MemberMissionRepositoryCustomImpl memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {

        // 미션이 이미 도전 중인지 확인
        return !memberMissionRepository.existsByMissionId(missionId);
    }
}
