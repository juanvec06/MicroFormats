package edu.co.unicauca.microformatos.DataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
