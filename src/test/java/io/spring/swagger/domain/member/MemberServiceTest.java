package io.spring.swagger.domain.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    void save() {
        // given
        JoinRequestDto request = new JoinRequestDto("jdk", "1234", "guro", 30);

        // when
        int result = memberService.join(request);

        // then
        assertThat(result).isEqualTo(1);
    }

}