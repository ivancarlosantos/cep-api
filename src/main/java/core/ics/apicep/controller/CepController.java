package core.ics.apicep.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.ics.apicep.model.Cep;
import core.ics.apicep.services.ICepService;

@RestController
@RequestMapping(path = "/cep")
public class CepController {

	@Autowired
	private ICepService cepServices;

	private Logger lz = LoggerFactory.getLogger(CepController.class);

	@GetMapping(path = "/{cep}")
	public ResponseEntity<Cep> requestCep(@PathVariable(name = "cep") String cep) {
		lz.debug("");
		Cep cp = cepServices.requestCEP(cep);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cp);
	}

}
