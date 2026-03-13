package edu.co.unicauca.microformatos.DataAccessLayer.models;

/**
 * Represents the valid lifecycle states for a proposal.
 *
 * <p>A proposal can only be in one of these states at a time. These values
 * are also constrained in the relational schema.</p>
 *
 * @author Juan David Vela Coronado
 */
public enum ProposalState {

    /**
     * The director has completed the necessary information to create the proposal.
     */
    FORMULATED,

    /**
     * The proposal is currently being evaluated.
     */
    IN_EVALUATION,

    /**
     * The proposal was formulated and has observations to be addressed.
     */
    FORMULATED_WITH_OBSERVATIONS,

    /**
     * The proposal was approved.
     */
    APPROVED,

    /**
     * The proposal was not approved.
     */
    NOT_APPROVED
}