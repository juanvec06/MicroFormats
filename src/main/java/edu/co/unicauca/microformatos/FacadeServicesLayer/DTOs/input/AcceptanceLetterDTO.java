package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcceptanceLetterDTO {
    @NotBlank(message = "Company name is required")
    private String companyName;
    
    @NotBlank(message = "Company Adviser role is required")
    private String role;
    
    @NotNull(message = "Hours of total work is required")
    @Positive(message = "Total hours must be a positive number")
    private Integer totalHours;

    @NotBlank(message = "Number of contract is required")
    private String contractNumber;

    @NotNull(message = "Department is required")
    @Valid
    private DepartmentDTO department;
}
