package com.example.demo.validations.diagonal;

public class Cell {

	private int posX;
	private int posY;
	private char letter;
	
	public Cell(int posX, int posY, char letter) {
		this.posX = posX;
		this.posY = posY;
		this.letter = letter;
	}
	
	public Cell() {
		this.posX = 0;
		this.posY = 0;
		this.letter = ' ';
	}
	
	public Cell(char letter) {
		this.posX = 0;
		this.posY = 0;
		this.letter = letter;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}

}

