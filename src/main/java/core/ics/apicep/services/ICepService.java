package core.ics.apicep.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import core.ics.apicep.model.Cep;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ICepService {

	@GetMapping(path = "/{cep}/json/")
	Cep requestCEP(@PathVariable(name = "cep") String cep);
}
