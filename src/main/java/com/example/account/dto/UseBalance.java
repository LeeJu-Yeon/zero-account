package com.example.account.dto;

import com.example.account.aop.AccountLockIdInterface;
import com.example.account.type.TransactionResultType;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UseBalance {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request implements AccountLockIdInterface {   // 잔액사용 요청시 필요한 파라미터들

        @NotNull
        @Min(1)
        private Long userId;
        // @Valid 조건 : ID 값은 필수 & 1부터 시작

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;
        // @Valid 조건 : 빈칸불가, 길이 = 10

        @NotNull
        @Min(10)
        @Max(1_000_000_000)
        private Long amount;
        // @Valid 조건 : 거래금액 필수 & 10원 이상 & 10억 이하

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {   // 잔액사용 응답시 출력할 정보들

        private String accountNumber;
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;

        public static Response from(TransactionDto transactionDto) {
            return Response.builder()
                    .accountNumber(transactionDto.getAccountNumber())
                    .transactionResult(transactionDto.getTransactionResultType())
                    .transactionId(transactionDto.getTransactionId())
                    .amount(transactionDto.getAmount())
                    .transactedAt(transactionDto.getTransactedAt())
                    .build();
        }

    }

}
