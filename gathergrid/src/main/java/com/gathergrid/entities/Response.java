package com.gathergrid.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter @Getter
public class Response<T> {
    private String message;
    private Object data;
    private int status;

    public Response(String message, Object data, int status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public Response(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
