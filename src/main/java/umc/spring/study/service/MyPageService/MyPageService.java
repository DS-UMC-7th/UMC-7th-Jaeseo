package umc.spring.study.service.MyPageService;

import org.springframework.beans.factory.annotation.Autowired;
import umc.spring.study.Dto.MyPageDto;
import umc.spring.study.repository.MemberRepository.MemberRepository;

public class MyPageService {

    private final MemberRepository memberRepository;

    @Autowired
    public MyPageService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MyPageDto getMyPageInfo(Long memberId) {
        return memberRepository.findMyPageInfo(memberId);
    }
}
