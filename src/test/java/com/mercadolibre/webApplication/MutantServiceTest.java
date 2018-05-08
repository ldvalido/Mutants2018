package com.mercadolibre.webApplication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mercadolibre.webApplication.service.IMutantService;
import com.mercadolibre.webApplication.service.MutantService;

public class MutantServiceTest {
	
	@Test
	public void TestBasicMutant() {
		IMutantService mutantService = new MutantService();
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		boolean result = mutantService.isMutant(dna);
		assertEquals(result, true);
	}	

	@Test
	public void TestBasicNonMutant() {
		IMutantService mutantService = new MutantService();
		String[] dna = {"BTGCGP","CAGTGC","TTATGT","AGAAGG","CCCDTA","TCACTG"};
		boolean result = mutantService.isMutant(dna);
		assertEquals(result, false);
	}
}
