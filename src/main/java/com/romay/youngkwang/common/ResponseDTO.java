package com.romay.youngkwang.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ResponseDTO {
    private int code;
    private String msg;
    private Object response;
    public ResponseDTO(HttpStatus code, String msg, Object response) {
        this.code = code.value();
        this.msg = msg;
        this.response = response;
    }
}