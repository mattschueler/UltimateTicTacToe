package com.auronic;

import javax.swing.*;

public class UTTTGUI {

	public static JFrame window;
	public static Board board;
	
	public UTTTGUI() {
		
	}
	
	public static void createAndShowGUI() {
		window = new JFrame();
		board = new Board();
		window.add(board);
		window.pack();
		window.setSize(1100,853);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}	
}
