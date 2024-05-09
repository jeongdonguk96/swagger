package io.spring.swagger.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입한다.
    public int join(JoinRequestDto request) {
        Member newMember = request.toEntity();
        return memberRepository.save(newMember);
    }

    // 사용자를 조회한다.
    public Member getMember(int id) {
        return memberRepository.findById(id);
    }
}
