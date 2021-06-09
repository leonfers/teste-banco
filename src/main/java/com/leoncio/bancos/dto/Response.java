package com.leoncio.bancos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private Object data;
    private List<ErrorDTO> errors;

    public Response(Object data) {
        this.data = data;
        this.errors = null;
    }

    public Response(List<ErrorDTO> errors) {
        this.errors = errors;
        this.data = null;
    }
}
