package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PracticeProposalCreateDTO extends ProposalCreateDTO {
    
    @NotBlank(message = "Company advisor name is required")
    private String companyAdvisorName;
    
    @NotNull(message = "Acceptance letter is required")
    @Valid
    private AcceptanceLetterDTO acceptanceLetter;

    @Override
    @Size(min = 1, max = 1, message = "Practice proposals must have exactly 1 student")
    public List<StudentDTO> getStudents() {
        return super.getStudents();
    }
}
