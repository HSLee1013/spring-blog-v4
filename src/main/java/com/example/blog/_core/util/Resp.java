package com.example.blog._core.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resp<T> {
    private Boolean success;
    private String msg;
    private T body;

    public static <T> Resp<T> ok(T body) {
        return new Resp<>(true, "성공", body);
    }

    public static <T> Resp<T> fail(String msg) {
        return new Resp<>(false, msg, null);
    }
}
