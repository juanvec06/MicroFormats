package edu.co.unicauca.microformatos.DataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for representing an Acceptance Letter entity.
 * <p>
 * This class contains the attributes and methods related to an acceptance letter, such as the company name, role, and associated department.
 * The AcceptanceLetter class is used in the context of practice proposals, where it represents the letter of acceptance from a company for a student to undertake a practice or internship.
 * </p>
 * @author Juan David Vela Coronado
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcceptanceLetter {
    
    private Long id;
    private String companyName;
    private String role;
    private Integer totalHours;
    private String contractNumber;
    private Department department;
}
