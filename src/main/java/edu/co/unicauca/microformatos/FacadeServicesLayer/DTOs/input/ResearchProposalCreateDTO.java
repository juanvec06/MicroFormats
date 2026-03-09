package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input;

import java.util.List;

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
public class ResearchProposalCreateDTO extends ProposalCreateDTO {
    
    @Override
    @Size(min = 1, max = 2, message = "Research proposals must have between 1 and 2 students")
    public List<StudentDTO> getStudents() {
        return super.getStudents();
    }
}
