package io.spring.swagger.domain.member;

import io.spring.swagger.domain.util.StringUtil;
import io.swagger.v3.oas.annotations.media.Schema;

public record JoinRequestDto(
        // 필드 설명
        @Schema(description = "사용할 아이디", example = "visitor123")
        String username,
        @Schema(description = "사용할 비밀번호", example = "1q2w3e4r!")
        String password,
        @Schema(description = "집 주소", example = "서울시 구로구")
        String address,
        @Schema(description = "나이", example = "30")
        int age
) {

    public Member toEntity() {
        int id = Integer.parseInt(StringUtil.generateRandom4Digit());
        return new Member(id, username(), password(), address(), age());
    }

}

