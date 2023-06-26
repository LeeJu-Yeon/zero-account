package com.example.account.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class DeleteAccount {   // 내부클래스 생성시 static 으로 해야 사용하기 편리

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {   // 계좌해지 요청시 필요한 파라미터들

        @NotNull
        @Min(1)
        private Long userId;
        // @Valid 조건 : ID 값은 필수 & 1부터 시작

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;
        // @Valid 조건 : 빈칸불가, 길이 = 10

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {   // 계좌해지 응답시 출력할 정보들

        private Long userId;
        private String accountNumber;
        private LocalDateTime unRegisteredAt;

        public static Response from(AccountDto accountDto) {
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .unRegisteredAt(accountDto.getUnRegisteredAt())
                    .build();
        }

    }

}
