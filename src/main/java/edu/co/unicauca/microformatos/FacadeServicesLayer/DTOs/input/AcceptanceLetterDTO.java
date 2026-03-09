package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.Valid;

public record AcceptanceLetterDTO(
    @NotBlank(message = "Company name is required")
    String companyName,
    
    @NotBlank(message = "Company Adviser role is required")
    String role,
    
    @NotNull(message = "Hours of total work is required")
    @Positive(message = "Total hours must be a positive number")
    Integer totalHours,

    @NotBlank(message = "Number of contract is required")
    String contractNumber,

    @NotNull(message = "Department is required")
    @Valid
    DepartmentDTO department
) {}
