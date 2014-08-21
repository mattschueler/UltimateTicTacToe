package com.auronic;

public class Coords {	
	private int BigX, BigY, SmallX, SmallY;
	
	public Coords(int i, int j, int k, int l) {
		this.BigX = i;
		this.BigY = j;
		this.SmallX = k;
		this.SmallY = l;
	}

	public int getBigX() {
		return BigX;
	}

	public int getBigY() {
		return BigY;
	}

	public int getSmallX() {
		return SmallX;
	}

	public int getSmallY() {
		return SmallY;
	}
}
