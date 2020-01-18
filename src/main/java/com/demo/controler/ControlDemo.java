package com.demo.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.components.util.UtilWaitImpl;
import com.demo.model.rest.Valor;
import com.demo.services.ValorSrv;

@RestController
public class ControlDemo {
	
	public Logger logger = LoggerFactory.getLogger(ControlDemo.class);
	
	@Autowired
	@Qualifier("valorSrv")
	private ValorSrv valorSrv;
	
	@GetMapping("/dado6")
	public Valor dado6() {
		logger.info("Se solicita tirar y esperar un dado de 6");
		
		logger.debug("Se va a proceder con el lanzamiento del dado");
		Integer valor = valorSrv.obtenValor(1, 6);
		logger.debug("Se solicita ha obtenido %i", valor);
		
		valorSrv.espera(valor);
		
		Valor respuesta = new Valor();
		respuesta.setStatus(HttpStatus.OK);
		respuesta.setValor(valor);
		return respuesta;
	}

	@GetMapping("/dado10")
	public Valor dado10() {
		logger.info("Se solicita tirar y esperar un dado de 10");
		
		logger.debug("Se va a proceder con el lanzamiento del dado");
		Integer valor = valorSrv.obtenValor(1, 10);
		logger.debug("Se solicita ha obtenido %i", valor);

		valorSrv.espera(valor);
		
		Valor respuesta = new Valor();
		respuesta.setStatus(HttpStatus.OK);
		respuesta.setValor(valor);
		return respuesta;
	}


}
