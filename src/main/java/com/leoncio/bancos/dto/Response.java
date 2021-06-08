package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Response implements BaseDTO {

    private Object data;
    private List<Error> errors;

    public Response(Object data) {
        this.data = data;
    }

    public Response(List<Error> errors) {
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
