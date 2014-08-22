package com.auronic;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;

public class WinBoard {

	private GridLayout gl;
	public HashMap<String, JLabel> spaces;
	
	public WinBoard() {
		gl = new GridLayout();
	}
	
}
