package edu.co.unicauca.microformatos.DataAccessLayer.repositories;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.co.unicauca.microformatos.DataAccessLayer.conection.DBConection;
import edu.co.unicauca.microformatos.DataAccessLayer.models.Proposal;
import edu.co.unicauca.microformatos.DataAccessLayer.models.ProposalState;
import edu.co.unicauca.microformatos.DataAccessLayer.models.ResearchProposal;
import edu.co.unicauca.microformatos.DataAccessLayer.models.PracticeProposal;
import edu.co.unicauca.microformatos.DataAccessLayer.models.Student;
import edu.co.unicauca.microformatos.DataAccessLayer.models.AcceptanceLetter;

/**
 * @brief Repository class for managing Proposal entities.
 * @author Juan David Vela Coronado
 */
@Repository
public class FormatoRepository {

    DBConection dbConection;

    public FormatoRepository() {
        dbConection = new DBConection();
    }
    /**
     * @brief Method to create a new Proposal in the database.
     * @param proposal The Proposal model to be created.
     * @return The created Proposal model.
     */
    public Optional<Proposal> createProposal(Proposal proposal) {
        // Lógica para crear un nuevo formato
        return Optional.empty(); //TODO: Implementar la lógica de creación de formato y retornar el objeto correspondiente
    }
    /**
     * @brief Method to get a Proposal by its ID.
     * @param id The ID of the Proposal to be retrieved.
     * @return The Proposal model with the specified ID.
     */
    public Optional<Proposal> getProposalById(String id) {
        // Lógica para obtener un formato por su ID
        return Optional.empty(); //TODO: Implementar la lógica de obtención de formato por ID y retornar el objeto correspondiente
    }
    /**
     * @brief Method to get all Proposals from the database.
     * @return A list of all Proposal models.
     */
    public Optional<List<Proposal>> getAllProposals() {
        System.out.println("Obtaining all proposals from the database...");
        List<Proposal> proposals = new ArrayList<>();

        dbConection.conectar();
        try {
            var connection = dbConection.getConnection();
            String proposalsSql = "SELECT id, proposal_type, state_proposal, title, general_objective, "
                    + "contributions, estimated_time, delivery_conditions, required_resources, "
                    + "funding_sources, observations, university_director_name, company_advisor_name, "
                    + "acceptance_letter_id FROM proposals";

            try (PreparedStatement proposalStmt = connection.prepareStatement(proposalsSql);
                    ResultSet proposalRs = proposalStmt.executeQuery()) {

                while (proposalRs.next()) {
                    Proposal proposal = buildProposalFromResultSet(proposalRs);
                    Long proposalId = proposalRs.getLong("id");

                    proposal.setSpecificObjectives(getSpecificObjectivesByProposalId(connection, proposalId));
                    proposal.setStudents(getStudentsByProposalId(connection, proposalId));
                    proposals.add(proposal);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            dbConection.desconectar();
        }
        return Optional.of(proposals);
    }

    private Proposal buildProposalFromResultSet(ResultSet resultSet) throws Exception {
        String proposalType = resultSet.getString("proposal_type");
        Proposal proposal;

        if ("PRACTICE".equalsIgnoreCase(proposalType)) {
            PracticeProposal practiceProposal = new PracticeProposal();
            practiceProposal.setCompanyAdvisorName(resultSet.getString("company_advisor_name"));

            Long acceptanceLetterId = (Long) resultSet.getObject("acceptance_letter_id");
            if (acceptanceLetterId != null) {
                practiceProposal.setAcceptanceLetter(AcceptanceLetter.builder().id(acceptanceLetterId).build());
            }
            proposal = practiceProposal;
        } else {
            proposal = new ResearchProposal();
        }

        proposal.setId(resultSet.getLong("id"));
        proposal.setTitle(resultSet.getString("title"));
        proposal.setGeneralObjective(resultSet.getString("general_objective"));
        proposal.setContributions(resultSet.getString("contributions"));
        proposal.setEstimatedTime(resultSet.getString("estimated_time"));
        proposal.setDeliveryConditions(resultSet.getString("delivery_conditions"));
        proposal.setRequiredResources(resultSet.getString("required_resources"));
        proposal.setFundingSources(resultSet.getString("funding_sources"));
        proposal.setObservations(resultSet.getString("observations"));
        proposal.setUniversityDirectorName(resultSet.getString("university_director_name"));
        proposal.setState(ProposalState.valueOf(resultSet.getString("state_proposal")));

        return proposal;
    }

    private List<String> getSpecificObjectivesByProposalId(java.sql.Connection connection, Long proposalId) throws Exception {
        List<String> specificObjectives = new ArrayList<>();
        String sql = "SELECT objective_text FROM proposal_specific_objectives WHERE proposal_id = ? ORDER BY objective_order";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, proposalId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    specificObjectives.add(resultSet.getString("objective_text"));
                }
            }
        }

        return specificObjectives;
    }

    private List<Student> getStudentsByProposalId(java.sql.Connection connection, Long proposalId) throws Exception {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.id, s.university_id, s.name_student, s.email, s.career, s.city_expedition "
                + "FROM proposal_students ps "
                + "INNER JOIN students s ON ps.student_id = s.id "
                + "WHERE ps.proposal_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, proposalId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = Student.builder()
                            .id(resultSet.getLong("id"))
                            .universityId((Long) resultSet.getObject("university_id"))
                            .name(resultSet.getString("name_student"))
                            .email(resultSet.getString("email"))
                            .career(resultSet.getString("career"))
                            .cityExpedition(resultSet.getString("city_expedition"))
                            .build();
                    students.add(student);
                }
            }
        }

        return students;
    }
}