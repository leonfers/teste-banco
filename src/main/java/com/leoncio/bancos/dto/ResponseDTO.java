package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO implements BaseDTO {

    private BaseDTO data;
    private List<Error> errors;

    public ResponseDTO(BaseDTO data) {
        this.data = data;
    }

    public ResponseDTO(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "data=" + data +
                ", errors=" + errors +
                '}';
    }
}
