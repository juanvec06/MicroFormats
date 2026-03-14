package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Department name is required")
    private String name;

    @NotBlank(message = "Department city is required")
    private String city;

    @NotBlank(message = "Department principal activity is required")
    private String principalActivity;
}
