package com.neoris.userstransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorMessageResponseDto {

    private String message;
    private LocalDateTime time;

}
