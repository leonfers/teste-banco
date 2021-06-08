package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorDTO implements BaseDTO {

    public String type;
    public String title;
    public String code;
    public String detail;
    public String instance;

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", detail='" + detail + '\'' +
                ", instance='" + instance + '\'' +
                '}';
    }
}
