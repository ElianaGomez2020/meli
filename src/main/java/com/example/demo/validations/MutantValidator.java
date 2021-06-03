package com.example.demo.validations;

import java.util.List;


import com.example.demo.validations.diagonal.DiagonalValidator;
import com.example.demo.validations.diagonal.InverseDiagonalValidator;

public class MutantValidator {
	
	public boolean isMutant(List<String> dna) {
		boolean isMutant = false;
		
		HorizontalValidator horizontalValidator = new HorizontalValidator();
		long numHorizontalSequences = horizontalValidator.getNumOfHorizontalSequences(dna);
		
		VerticalValidator verticalValidator = new VerticalValidator();
		long numVerticalSecuences = verticalValidator.getNumOfVerticalSequences(dna);
		
		DiagonalValidator diagonalValidator = new DiagonalValidator(dna);
	    long numDiagonalSecuences = diagonalValidator.getNumOfDiagonalSequences();
		
		InverseDiagonalValidator inverseDiagonalValidator = new InverseDiagonalValidator(dna);
	    long numInverseDiagonalSecuences = inverseDiagonalValidator.getNumOfDiagonalSequences();
	    
	    long totalSecuences = numHorizontalSequences + numVerticalSecuences + numDiagonalSecuences + numInverseDiagonalSecuences;
		
		isMutant = totalSecuences > 1;
		
		return isMutant;
	}


}