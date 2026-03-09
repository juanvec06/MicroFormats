package edu.co.unicauca.microformatos.DataAccessLayer.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
    private List<Student> students; // Polymorphic behavior is not strictly needed on List if generics are used, but List<Student> is fine.
}
