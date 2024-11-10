package umc.spring.study.repository.MemberRepository;

import umc.spring.study.Dto.MyPageDto;

public interface MemberRepositoryCustom {
    MyPageDto findMyPageInfo(Long memberId);
}
