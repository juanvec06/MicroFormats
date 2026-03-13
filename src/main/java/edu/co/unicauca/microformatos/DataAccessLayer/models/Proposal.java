package edu.co.unicauca.microformatos.DataAccessLayer.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Model class that represents a generic proposal entity.
 *
 * <p>This base class contains the shared information for proposal types such as
 * research proposals and practice proposals. It is intended to be extended by
 * concrete proposal implementations.</p>
 *
 * @author Juan David Vela Coronado
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Proposal {
    
    private Long id;
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
    /**
     * Current lifecycle state of the proposal.
     */
    private ProposalState state;
    private List<Student> students; // Polymorphic behavior is not strictly needed on List if generics are used, but List<Student> is fine.
}
