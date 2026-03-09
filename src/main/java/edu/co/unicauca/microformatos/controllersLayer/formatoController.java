package edu.co.unicauca.microformatos.controllersLayer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.microformatos.FacadeServicesLayer.facades.formatoFacade;

@RestController
@RequestMapping("/api/formatos")
// @CrossOrigin(origins = "http://localhost:4200")
public class formatoController {

    
	private final formatoFacade formatoFacade;

	public formatoController(formatoFacade formatoFacade) {
		this.formatoFacade = formatoFacade;
	}

	@GetMapping
	public ResponseEntity<Object> consultarFormatos() {
		return ResponseEntity.ok(formatoFacade.consultarFormatos());
	}

	@PostMapping
	public ResponseEntity<Object> crearFormato(@RequestBody Object formato) {
		return ResponseEntity.status(HttpStatus.CREATED).body(formatoFacade.crearFormato(formato));
	}
    
}
