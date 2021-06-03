package com.example.demo.validations;

import java.util.List;

public class InfoValidator {
		
	public boolean isDnaValid(List<String> dna) {
		long numRows = dna.size();
		for(String row : dna) {
			if(row.length() != numRows)
				return false;
			
			char[] charArray = row.toCharArray();
			for (int j = 0; j < charArray.length; j++) {
				
				char letter = charArray[j];
				if (letter != 'A' && letter != 'T' && letter != 'C' && letter != 'G') {
					return false;
				}
			}
		}
		return true;
	}
	
}
