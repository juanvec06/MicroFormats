package edu.co.unicauca.microformatos.controllersLayer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.output.ProposalResponseDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.DTOs.input.ProposalCreateDTO;
import edu.co.unicauca.microformatos.FacadeServicesLayer.facades.FormatoFacade;
import java.util.List;

@RestController
@RequestMapping("/api/formatos")
// @CrossOrigin(origins = "http://localhost:4200")
public class formatoController {

    
	private final FormatoFacade formatoFacade;

	public formatoController(FormatoFacade formatoFacade) {
		this.formatoFacade = formatoFacade;
	}

	@GetMapping
	public ResponseEntity<List<ProposalResponseDTO>> consultarFormatos() {
		return ResponseEntity.ok(formatoFacade.consultarFormatos());
	}

	@PostMapping
	public ResponseEntity<ProposalResponseDTO> crearFormato(@RequestBody ProposalCreateDTO formato) {
		return ResponseEntity.status(HttpStatus.CREATED).body(formatoFacade.crearFormato(formato));
	}
    
}
