package com.example.groupremember.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

public class GroupDto {
    @NotBlank(message = "Campo nome é obrigatório.")
    @Size(min = 3, message = "Campo nome deve conter no mínimo 3 caracteres.")
    private String name;

    public String getName() {
        return name;
    }
}
