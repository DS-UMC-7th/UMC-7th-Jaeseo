package umc.spring.study.repository.MemberRepository;

import umc.spring.study.web.dto.MyPageDto;

public interface MemberRepositoryCustom {
    MyPageDto findMyPageInfo(Long memberId);
}
