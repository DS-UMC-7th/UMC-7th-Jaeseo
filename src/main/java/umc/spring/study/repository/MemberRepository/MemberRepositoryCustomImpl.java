package umc.spring.study.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import umc.spring.study.domain.QMember;
import umc.spring.study.web.dto.MyPageDto;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryCustomImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public MyPageDto findMyPageInfo(Long memberId) {
        QMember member = QMember.member;

        return queryFactory
                .select(Projections.constructor(MyPageDto.class,
                        member.name,
                        member.email,
                        member.point
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
