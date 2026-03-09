package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input.StudentDTO;
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
    @JsonSubTypes.Type(value = ResearchProposalResponseDTO.class, name = "Research"),
    @JsonSubTypes.Type(value = PracticeProposalResponseDTO.class, name = "Practice")
})
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProposalResponseDTO {
    
    private String id;
    private String title;
    private String generalObjective;
    private List<String> specificObjectives;
    private String contributions;
    private String estimatedTime;
    private String deliveryConditions;
    private String requiredResources;
    private String fundingSources;
    private String observations;
    private String universityDirectorName;
    private List<StudentDTO> students;
    private LocalDateTime submissionDate;
}
