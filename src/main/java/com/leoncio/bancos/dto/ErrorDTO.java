package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ErrorDTO {

    public String title;
    public int code;
    public String detail;
    public String path;
    public LocalDateTime timestamp;
}
