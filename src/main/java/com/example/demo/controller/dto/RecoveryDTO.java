package com.example.demo.controller.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RecoveryDTO implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    private String token;
    private String password;
}
