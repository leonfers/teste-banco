package com.leoncio.bancos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements BaseDTO {

    private Object data;
    private List<Error> errors;

    public Response(Object data) {
        this.data = data;
        this.errors = null;
    }

    public Response(List<Error> errors) {
        this.errors = errors;
        this.data = null;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", errors=" + errors +
                '}';
    }
}
