package com.leoncio.bancos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {

    public String title;
    public int code;
    public String detail;
    public String path;
    public LocalDateTime timestamp;
}
