package io.spring.swagger.domain.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class MemberControllerTest {

    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;
    @Mock MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입이 정상적으로 성공한다.")
    void join() throws Exception {
        // given
        JoinRequestDto requestDto = JoinRequestDto.builder()
                .username("minsu")
                .password("1234")
                .address("guro")
                .age(30)
                .build();
        String requestBody = objectMapper.writeValueAsString(requestDto);

        // when
        ResultActions resultActions = mvc
                .perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        // then
        resultActions.andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("id로 특정 사용자가 정상적으로 조회된다.")
    void geMember() throws Exception {
        // given
        Member newMember = Member.builder()
                .id(1)
                .username("minsu")
                .password("1234")
                .address("guro")
                .age(30)
                .build();

        memberRepository.save(newMember);

        String id = String.valueOf(newMember.getId());

        // when
        ResultActions resultActions = mvc
                .perform(post("members/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(id));

        // then
        resultActions.andExpect(status().is2xxSuccessful());
    }

}
