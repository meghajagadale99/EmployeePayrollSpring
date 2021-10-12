package com.bridgelabz.employeepayroll.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object empData) {
        this.message = message;
        data = empData;
    }
}
