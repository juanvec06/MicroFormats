package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotNull(message = "University ID is required")
    @Positive(message = "University ID must be a positive number")
    private Long universityId;
    
    @NotBlank(message = "Student name is required")
    private String name;
    
    @Email(message = "Invalid email format")
    @NotBlank(message = "Student email is required")
    private String email;

    @NotBlank(message = "Student Career is required")
    private String career;

    @NotNull(message = "Country ID is required")
    @Positive(message = "Country ID must be a positive number")
    private Long countryId;

    @NotBlank(message = "City expedition is required")
    private String cityExpedition;
}
