package edu.co.unicauca.microformatos.FacadeServicesLayer.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input.ProposalCreateDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output.ProposalResponseDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.services.IFormatoService;

import java.util.List;
@Service
public class FormatoFacade {

    @Autowired
    @Qualifier("IDFormatoService")
    private IFormatoService service;

    public List<ProposalResponseDTO> consultarFormatos() {
        return service.getAllProposals();
    }

    public ProposalResponseDTO crearFormato(ProposalCreateDTO formato) {
        if (formato == null) {
            return null;
        }
        return service.createProposal(formato);
    }
}
