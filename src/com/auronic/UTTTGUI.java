package com.auronic;

import javax.swing.*;

public class UTTTGUI {

	public static JFrame window;
	public static Board board;
	public static JSplitPane boards;
	
	public UTTTGUI() {
		
	}
	
	public static void createAndShowGUI() {
		window = new JFrame();
		board = new Board();
		window.add(board);
		window.pack();
		window.validate();
		window.setSize(955,690);
		window.setVisible(true);
		window.setResizable(false);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}	
}
