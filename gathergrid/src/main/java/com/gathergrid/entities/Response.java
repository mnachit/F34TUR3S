package com.gathergrid.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Response<T> {
    @Setter @Getter
    private String message;
    @Setter@Getter
    private Object data;
    @Setter@Getter
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
