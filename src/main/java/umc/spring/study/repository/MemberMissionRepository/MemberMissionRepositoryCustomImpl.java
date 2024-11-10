package umc.spring.study.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import umc.spring.study.Dto.MemberMissionDto;
import umc.spring.study.domain.QMission;
import umc.spring.study.domain.QRegion;
import umc.spring.study.domain.QStore;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.QMemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepositoryCustom;

import java.util.List;

public class MemberMissionRepositoryCustomImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberMissionRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory=queryFactory;
    }

    public List<MemberMissionDto> findMemberMissions(Long memberId, int limit, int offset) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        return queryFactory
                .select(Projections.constructor(MemberMissionDto.class,
                        memberMission.id.as("memberMissionId"),
                        mission.id.as("missionId"),
                        memberMission.status,
                        mission.reward,
                        mission.deadline,
                        memberMission.createdAt.as("missionStartDate"),
                        store.name.as("storeName"),
                        region.name.as("regionName")
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETE)
                )
                .orderBy(memberMission.createdAt.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }

}
