package com.example.demo.validations;

import java.util.List;

public class HorizontalValidator {
	
	public long getNumOfHorizontalSequences(List<String> dna) {	
		long secuenceCounter = 0;
		long letterCounter = 1;
		char lastLetter = ' ';
		
		int matrizSize = dna.size();
		
		for(int y = 0; y < matrizSize; y++) {
			lastLetter = ' ';
			String row = dna.get(y);
			char[] charArray = row.toCharArray();
			letterCounter = 0;
			
			for(int x = 0; x < charArray.length; x++) {
				
				char letter = charArray[x];
				if(letter == lastLetter) {
					letterCounter += 1;
				}else {
					if(letterCounter ==  4) {
						secuenceCounter += 1;
					}
					letterCounter = 1;
					lastLetter = letter;
				}
				
				if(x == matrizSize - 1) {
					if(letterCounter ==  4) {
						secuenceCounter += 1;
					}
				}
			}
			
		}
		
		return secuenceCounter;
	}

}