package edu.co.unicauca.microformatos.FacadeServicesLayer.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input.ProposalCreateDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output.ProposalResponseDTO;

@Service("IDFormatoService")
public class FormatoService implements IFormatoService {

    public List<ProposalResponseDTO> getAllProposals() {
        return new ArrayList<>();
    }

    public ProposalResponseDTO createProposal(ProposalCreateDTO proposal) {
        return null;
    }

    public ProposalResponseDTO getProposalById(String id) {
        return null;
    }
}
