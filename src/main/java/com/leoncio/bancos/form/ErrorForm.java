package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorForm implements BaseForm {

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
