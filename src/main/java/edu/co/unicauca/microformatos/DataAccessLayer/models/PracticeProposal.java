package edu.co.unicauca.microformatos.DataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Model class for represeting a Practice Proposal entity.
 * <p>
 * This class contains the attributes and methods related to a practice proposal, such as the company advisor's name and the acceptance letter associated with the proposal.
 * The PracticeProposal class extends the general Proposal class, inheriting its attributes and methods while adding specific details relevant to practice proposals.
 * </p>
 * @author Juan David Vela Coronado
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PracticeProposal extends Proposal {
    
    private String companyAdvisorName;
    private AcceptanceLetter acceptanceLetter;
}
