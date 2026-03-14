package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output;

import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input.AcceptanceLetterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PracticeProposalResponseDTO extends ProposalResponseDTO {
    
    private String companyAdvisorName;
    private AcceptanceLetterDTO acceptanceLetter;
}
