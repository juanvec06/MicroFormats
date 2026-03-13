package edu.co.unicauca.microformatos.DataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @brief Model class for representing a Student entity.
 * This class contains the attributes and methods related to a student, such as their ID, university ID, name, email, career, country of origin, and city of expedition.
 * @author Juan David Vela Coronado
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    private Long id;
    private Long universityId;
    private String name;
    private String email;
    private String career;
    private String cityExpedition;
}
