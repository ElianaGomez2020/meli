package com.example.demo.validations;

import java.util.List;

public class VerticalValidator {
	public long getNumOfVerticalSequences(List<String> dna) {	
		long secuenceCounter = 0;
		long letterCounter = 1;
		char lastLetter = ' ';
		
		int matrizSize = dna.size();
		
		for(int x = 0; x < matrizSize; x++) {
			lastLetter = ' ';
			letterCounter = 0;
			
			for(int y = 0; y < dna.size(); y++) {
				
				String row = dna.get(y);
				char[] charArray = row.toCharArray();
				
				
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
				
				if(y == matrizSize - 1) {
					if(letterCounter ==  4) {
						secuenceCounter += 1;
					}
				}
			}
			
		
		}
		
		
		return secuenceCounter;
	}
	
}
		


