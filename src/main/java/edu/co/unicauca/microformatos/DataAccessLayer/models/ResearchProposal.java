package edu.co.unicauca.microformatos.DataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Model class for represeting a Research Proposal entity.
 * <p>
 * This class does not add any new attributes or methods to the Proposal class, but it serves as a specific type of proposal that can be used to represent research proposals in the system.
 * </p>
 * @author Juan David Vela Coronado
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchProposal extends Proposal {
    // Inherits everything from Proposal
}
