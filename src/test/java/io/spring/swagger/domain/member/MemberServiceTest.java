package io.spring.swagger.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    
    @AfterEach
    void deleteAll() {
        memberRepository.deleteAll();
    }
    
    @Test
    @DisplayName("회원가입이 정상적으로 성공한다.")
    void save() {
        // given
        JoinRequestDto request = new JoinRequestDto("jdk", "1234", "guro", 30);

        // when
        int result = memberService.join(request);

        // then
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    @DisplayName("id로 특정 사용자가 정상적으로 조회된다.")
    void getMember() {
        // given
        Member newMember = Member.builder()
            .id(1)
            .username("minsu")
            .password("1234")
            .address("guro")
            .age(30)
            .build();
        
        memberRepository.save(newMember);
        
        // when
        Member member = memberService.getMember(newMember.getId());
        
        // then
        assertThat(member).isEqualTo(newMember);
        
    }

}