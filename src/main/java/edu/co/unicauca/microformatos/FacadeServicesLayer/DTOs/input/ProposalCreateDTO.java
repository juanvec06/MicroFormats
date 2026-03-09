package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ResearchProposalCreateDTO.class, name = "Research"),
    @JsonSubTypes.Type(value = PracticeProposalCreateDTO.class, name = "Practice")
})
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProposalCreateDTO {
    
    @NotBlank(message = "Title is required")
    private String title;
    
    @NotBlank(message = "General objective is required")
    private String generalObjective;
    
    @NotEmpty(message = "At least one specific objective is required")
    private List<String> specificObjectives;
    
    @NotBlank(message = "Contributions are required")
    private String contributions;
    
    @NotBlank(message = "Estimated time is required")
    private String estimatedTime; // Could be LocalDate or String based on requirements, kept as String for simplicity

    @NotBlank(message = "Delivery conditions are required")
    private String deliveryConditions;
    
    @NotBlank(message = "Required resources are required")
    private String requiredResources;
    
    @NotBlank(message = "Funding sources are required")
    private String fundingSources;
    
    private String observations;
    
    @NotBlank(message = "University director name is required")
    private String universityDirectorName;
    
    @Valid
    @NotEmpty(message = "At least one student is required")
    private List<StudentDTO> students;
}
