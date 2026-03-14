package edu.co.unicauca.microformatos.FacadeServicesLayer.services;

import edu.co.unicauca.microformatos.FacadeServicesLayer.mapper.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.modelmapper.TypeToken;


import edu.co.unicauca.microformatos.DataAccessLayer.models.PracticeProposal;
import edu.co.unicauca.microformatos.DataAccessLayer.models.Proposal;
import edu.co.unicauca.microformatos.DataAccessLayer.repositories.FormatoRepository;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input.ProposalCreateDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output.PracticeProposalResponseDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output.ProposalResponseDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output.ResearchProposalResponseDTO;

@Service("IDFormatoService")
public class FormatoService implements IFormatoService {

    private final mapper mapper_1;
    private FormatoRepository formatoRepository;
    private ModelMapper mapper;

    public FormatoService(FormatoRepository formatoRepository, ModelMapper mapper, mapper mapper_1) {
        this.formatoRepository = formatoRepository;
        this.mapper = mapper;
        this.mapper_1 = mapper_1;
    }

    public List<ProposalResponseDTO> getAllProposals() {
        Optional<List<Proposal>> proposals = formatoRepository.getAllProposals();
        List<ProposalResponseDTO> response = new ArrayList<>();
        if (proposals.isPresent()){
            List<Proposal> proposalList = proposals.get();
            for (Proposal proposal : proposalList) {
                if (proposal instanceof PracticeProposal) {
                    response.add(this.mapper.map(proposal, PracticeProposalResponseDTO.class));
                } else {
                    response.add(this.mapper.map(proposal, ResearchProposalResponseDTO.class));
                }
            }
            return response;
        }
        return new ArrayList<>();
    }

    public ProposalResponseDTO createProposal(ProposalCreateDTO proposal) {
        return null;
    }

    public ProposalResponseDTO getProposalById(String id) {
        return null;
    }
}
