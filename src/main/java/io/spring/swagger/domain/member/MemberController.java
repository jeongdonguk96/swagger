package io.spring.swagger.domain.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// API 도메인 구분
@Tag(name = "Member", description = "Member API 모음")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // API 설명
    @Operation(summary = "회원가입", description = "신규 회원가입을 한다.")
    // API 응답 규격 명시
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = {@Content(schema = @Schema(implementation = ResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "실패")
    })
    @PostMapping("/members")
    public ResponseDto<Integer> join(
            @RequestBody JoinRequestDto request
    ) {
        int result = memberService.join(request);
        return new ResponseDto<>(HttpStatus.OK.value(), "success", result);
    }

    @GetMapping("/members/{id}")
    public ResponseDto<Integer> getMember(
            @PathVariable int id
    ) {
        Member member = memberService.getMember(id);
        return new ResponseDto<>(HttpStatus.OK.value(), "success", member.getId());
    }

}
