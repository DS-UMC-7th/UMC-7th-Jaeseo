package umc.spring.study.repository.MemberMissionRepository;

import umc.spring.study.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {

    List<MemberMissionDto> findMemberMissions(Long memberId, int limit, int offset);

    /* 특정 회원의 진행 중인 또는 진행 완료인 미션을 조회 */

    boolean existsByMissionId(Long missionId);



}
