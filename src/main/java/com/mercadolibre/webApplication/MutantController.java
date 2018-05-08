package com.mercadolibre.webApplication;

import com.mercadolibre.webApplication.service.IMutantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class MutantController {

	@Autowired
	IMutantService mutantService;
	
    @RequestMapping(value = "/mutant", method = RequestMethod.POST)
    boolean isMutant(String dna[]) {
        boolean returnValue = mutantService.isMutant(dna);
        if (!returnValue) {
        	throw new MutanValidationException();
        }
        //LPUSH: Register intent
        return returnValue;
    }
    
    @Cacheable(value = "stats")
    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    String getStats() {
    	return "";
    }
}
