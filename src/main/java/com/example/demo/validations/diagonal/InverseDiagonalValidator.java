package com.example.demo.validations.diagonal;

import java.util.List;


public class InverseDiagonalValidator {
	
	private int matrizSize = 0;
	private List<String> dna;

	public InverseDiagonalValidator(List<String> dna) {
		matrizSize = dna.size();
		this.dna = dna;
	}
	
	public long getNumOfDiagonalSequences() {
		long secuenceCounter = 0;
		int lastPos = matrizSize - 1;
		
		//move upper diagonals
		Cell firstCellToMoveLeft = new Cell(lastPos, 0, dna.get(0).charAt(lastPos));
		do {
			Cell cellForDiagonal = new Cell();
			cellForDiagonal.setLetter(firstCellToMoveLeft.getLetter());
			cellForDiagonal.setPosX(firstCellToMoveLeft.getPosX());
			cellForDiagonal.setPosY(firstCellToMoveLeft.getPosY());
			
			long letterCounter = 0;
			char lastLetter = cellForDiagonal.getLetter();
			
			boolean canMoveDiagonal = true;
			do {
				char letter = cellForDiagonal.getLetter();
				if(letter == lastLetter) {
					letterCounter += 1;
				}else {
					if(letterCounter ==  4) {
						secuenceCounter += 1;
					}
					letterCounter = 1;
					lastLetter = letter;
				}
				
				canMoveDiagonal = canMoveInDiagonal(cellForDiagonal);
				if(!canMoveDiagonal) {
					if(letterCounter ==  4) {
						secuenceCounter += 1;
					}
				}
				
			}while(canMoveDiagonal);
			
			
		}while(canMoveToLeft(firstCellToMoveLeft));
		
		//Move inferior diagonals
		Cell firstCellToMoveDown = new Cell(lastPos, 1, dna.get(1).charAt(lastPos));
		
		do {
			Cell cellForDiagonal = new Cell();
			cellForDiagonal.setLetter(firstCellToMoveDown.getLetter());
			cellForDiagonal.setPosX(firstCellToMoveDown.getPosX());
			cellForDiagonal.setPosY(firstCellToMoveDown.getPosY());
			
			long letterCounter = 0;
			char lastLetter = cellForDiagonal.getLetter();
			
			boolean canMoveDiagonal = true;
			
			do {
				char letter = cellForDiagonal.getLetter();
				if(letter == lastLetter) {
					letterCounter += 1;
				}else {
					if(letterCounter ==  4) {
						secuenceCounter += 1;
					}
					letterCounter = 1;
					lastLetter = letter;
				}
				
				canMoveDiagonal = canMoveInDiagonal(cellForDiagonal);
				if(!canMoveDiagonal) {
					if(letterCounter ==  4) {
						secuenceCounter += 1;
					}
				}
				
			}while(canMoveDiagonal);
			
			
		}while(canMoveToDown(firstCellToMoveDown));
	
		
		return secuenceCounter;
		
	}
	
	private boolean canMoveToLeft(Cell cell) {
		boolean canMoveRight = cell.getPosX() - 4 >= 0;
		
		if(canMoveRight) {
			moveToLeft(cell);
		}
		
		return canMoveRight;
	}
	
	private boolean canMoveToDown(Cell cell) {
		int lastPos = matrizSize - 1;
		boolean canMoveToDown = cell.getPosY() + 4 <= lastPos;
		
		if(canMoveToDown) {
			moveToDown(cell);
		}
		
		return canMoveToDown;
	}
	
	private boolean canMoveInDiagonal(Cell cell) {
		int lastPos = matrizSize - 1;
		boolean canMoveInDiagonal = cell.getPosX() - 1 >= 0 && cell.getPosY() + 1 <= lastPos;
		
		if(canMoveInDiagonal) {
			moveInDiagonal(cell);
		}
		
		return canMoveInDiagonal;
	}
	
	private void moveInDiagonal(Cell cellForDiagonal) {
		cellForDiagonal.setPosX(cellForDiagonal.getPosX() - 1);
		cellForDiagonal.setPosY(cellForDiagonal.getPosY() + 1);
		
		String row = dna.get(cellForDiagonal.getPosY());
		char[] charArray = row.toCharArray();
		char letter = charArray[cellForDiagonal.getPosX()];
		
		cellForDiagonal.setLetter(letter);
	}
	
	private void moveToLeft(Cell cell) {
		cell.setPosX(cell.getPosX() - 1);
		
		String row = dna.get(cell.getPosY());
		char[] charArray = row.toCharArray();
		char letter = charArray[cell.getPosX()];
		
		cell.setLetter(letter);
	}
	
	private void moveToDown(Cell cell) {
		cell.setPosY(cell.getPosY() + 1);
		
		String row = dna.get(cell.getPosY());
		char[] charArray = row.toCharArray();
		char letter = charArray[cell.getPosX()];
		
		cell.setLetter(letter);
	}
}
