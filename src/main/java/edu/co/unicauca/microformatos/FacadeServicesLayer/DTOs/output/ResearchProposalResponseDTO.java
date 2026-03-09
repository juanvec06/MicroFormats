package edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output;

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
public class ResearchProposalResponseDTO extends ProposalResponseDTO {
    // No specific fields for now
}
