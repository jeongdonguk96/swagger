package io.spring.swagger.domain.member;

import io.swagger.v3.oas.annotations.media.Schema;

public record ResponseDto<T>(
        // 필드 설명
        @Schema(description = "응답 코드", example = "0000")
        int code,
        @Schema(description = "응답 메시지", example = "성공")
        String message,
        @Schema(description = "응답 데이터", example = "{id: 1}")
        T data
) {
}
