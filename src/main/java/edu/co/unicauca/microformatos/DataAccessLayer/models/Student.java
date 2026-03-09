package edu.co.unicauca.microformatos.DataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long countryId;
    private String cityExpedition;
}
