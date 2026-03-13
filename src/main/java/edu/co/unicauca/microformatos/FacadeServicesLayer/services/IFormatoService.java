package edu.co.unicauca.microformatos.FacadeServicesLayer.services;

import java.util.List;

import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input.ProposalCreateDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output.ProposalResponseDTO;

public interface IFormatoService {
    public List<ProposalResponseDTO> getAllProposals();
    public ProposalResponseDTO createProposal(ProposalCreateDTO proposal);
    public ProposalResponseDTO getProposalById(String id);
}
