package com.mercadolibre.webApplication.service;

public class MutantService implements IMutantService {

	public final Integer minEqualLetters = 4;
	public final Integer minSequence = 2;
	
	public boolean isMutant(String[] dna) {
		Integer foundSeq = 0;
		for (Integer rowIndex = 0; rowIndex < dna.length && foundSeq < minSequence; rowIndex++) {
			String row = dna[rowIndex];
			for (Integer column = 0; column< row.length() && foundSeq < minSequence; column++) {
				char c = row.charAt(column); 
				if(
						findMutantHorizontal(dna, c, column, rowIndex) || 
						findMutantVertical(dna, c, column, rowIndex) || 
						findMutantDiagonal(dna, c, column,rowIndex)
						) {
					foundSeq++;
				}
			}
		}
		return foundSeq >= minSequence;
	}
	
	private boolean findMutantHorizontal(String[] dna, char c, Integer x, Integer y) {
		boolean returnValue = false; 
		boolean canFind = true;
		String entry = dna[y];
		if (canFind(entry.length(), x)) {
			for (Integer index = 1; index <= minEqualLetters-1 && canFind; index++) {
				canFind = c == entry.charAt(x + index);
			}
			returnValue = canFind;
		}
		return returnValue;
	}
	private boolean findMutantVertical(String[] dna, char c, Integer x, Integer y) 
	{
		boolean returnValue = false; 
		boolean canFind = true;
		if (canFind(dna.length,y)) {
			for (Integer index = 1; index <= minEqualLetters-1 && canFind; index++) {
				canFind = c == dna[y+index].charAt(x);
			}
			returnValue = canFind;
		}
		return returnValue;
	}
	private boolean findMutantDiagonal(String[] dna, char c, Integer x, Integer y) 
	{
		boolean returnValue = false; 
		boolean canFind = true;
		String entry = dna[y];
		if (canFind(dna.length,y) && canFind(entry.length(), x)) {
			for (Integer index = 1; index <= minEqualLetters-1 && canFind; index++) {
				canFind = c == dna[y+index].charAt(x+index);
			}
			returnValue = canFind;
		}
		return returnValue;
	}
	private boolean canFind(Integer length, Integer offset) {
		return length - offset - 1 >= minEqualLetters;
	}

}
