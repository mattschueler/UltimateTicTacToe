package com.auronic;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class UTTTGUI {

	public static JFrame window;
	public static Board board;
	public static WinBoard wBoard;
	public static JSplitPane boards;
	
	public UTTTGUI() {
		
		
	}
	
	public static void createAndShowGUI() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board = new Board();
		board.setMinimumSize(new Dimension(660,650));
		board.setMaximumSize(new Dimension(660,650));
		board.setPreferredSize(new Dimension(660,650));
		wBoard = new WinBoard();
		wBoard.setMinimumSize(new Dimension(120,120));
		wBoard.setMaximumSize(new Dimension(120,120));
		wBoard.setPreferredSize(new Dimension(120,120));
		boards = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, board, wBoard);
		boards.setEnabled(false);
		window.getContentPane().add(boards);
		window.pack();
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
