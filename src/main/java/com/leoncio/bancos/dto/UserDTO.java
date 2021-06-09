package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
}
