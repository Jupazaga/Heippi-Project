package com.example.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RecoveryDTO implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    @NotBlank
    private String token;
    @NotBlank
    private String password;
}
