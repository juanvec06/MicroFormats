package edu.co.unicauca.microformatos.DataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for representing a Department of the Enterprise that wants to hire students.
 * <p>
 * This class contains the attributes related to a department, such as its ID, name, city, and principal activity.
 * It's related to the AcceptanceLetter class, as each acceptance letter is associated with a specific department of the enterprise.
 * </p>
 * @author Juan David Vela Coronado
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Long id;
    private String name;
    private String city;
    private String principalActivity;
}
