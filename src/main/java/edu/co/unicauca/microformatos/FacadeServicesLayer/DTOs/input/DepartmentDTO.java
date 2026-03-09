package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import jakarta.validation.constraints.NotBlank;

public record DepartmentDTO(
    @NotBlank(message = "Department name is required")
    String name,

    @NotBlank(message = "Department city is required")
    String city,

    @NotBlank(message = "Department principal activity is required")
    String principalActivity
) {}
