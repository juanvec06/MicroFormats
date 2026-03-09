package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record StudentDTO(
    @NotNull(message = "University ID is required")
    @Positive(message = "University ID must be a positive number")
    Long universityId,
    
    @NotBlank(message = "Student name is required")
    String name,
    
    @Email(message = "Invalid email format")
    @NotBlank(message = "Student email is required")
    String email,

    @NotBlank(message = "Student Career is required")
    String career,

    @NotNull(message = "Country ID is required")
    @Positive(message = "Country ID must be a positive number")
    Long countryId,

    @NotBlank(message = "City expedition is required")
    String cityExpedition
) {}
