package com.auronic;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Board extends JPanel {
	private static final long serialVersionUID = 1L;
	public static String player;
	public static HashMap<String, TTTSpace> spaces;
	public SpringLayout boardLayout;
			
	public Board() {
		player = "X";
		UTTTGUI.first = true;
		spaces = new HashMap<String, TTTSpace>(81,1);
		createSpaces();
		boardLayout = new SpringLayout();
		this.setLayout(boardLayout);
		lockInactive(1,1);
	}
	
	private static void createSpaces() {
		int i,j,k,l;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				for (k=0;k<3;k++) {
					for (l=0;l<3;l++) {
						spaces.put(String.format("" + i + j + k + l), new TTTSpace(i,j,k,l));
					}
				}
			}
		}
	}
	
	public void layoutSpaces() {
		int i,j,k,l;
		for (j=0;j<3;j++) {
			for (l=0;l<3;l++) {
				for (i=0;i<3;i++) {
					for (k=0;k<3;k++) {
						if (i == 0 && k == 0) {
							boardLayout.putConstraint(SpringLayout.WEST, spaces.get(String.format("" + i + j + k + l)), 10, SpringLayout.WEST, this);
						} else {
							if (k == 0) {
								boardLayout.putConstraint(SpringLayout.WEST, spaces.get(String.format("" + i + j + k + l)), 20, SpringLayout.EAST, spaces.get(String.format("" + (i-1) + j + 2 + l)));
							} else {
								boardLayout.putConstraint(SpringLayout.WEST, spaces.get(String.format("" + i + j + k + l)), 10, SpringLayout.EAST, spaces.get(String.format("" + i + j + (k-1) + l)));
							}
						}
						if (j == 0 && l == 0) {
							boardLayout.putConstraint(SpringLayout.NORTH, spaces.get(String.format("" + i + j + k + l)), 10, SpringLayout.NORTH, this);
						} else {
							if (l == 0) {
								boardLayout.putConstraint(SpringLayout.NORTH, spaces.get(String.format("" + i + j + k + l)), 20, SpringLayout.SOUTH, spaces.get(String.format("" + i + (j-1) + k + 2)));
							} else {
								boardLayout.putConstraint(SpringLayout.NORTH, spaces.get(String.format("" + i + j + k + l)), 10, SpringLayout.SOUTH, spaces.get(String.format("" + i + j + k + (l-1))));
							}
						}
						this.add(spaces.get(String.format("" + i + j + k + l)));
					}
				}
			}
		}
	}
	
	public void lockInactive(int activeX, int activeY) {
		boolean full = true;
		int x, y;
		for (x=0;x<3;x++) {
			for (y=0;y<3;y++) {
				if (spaces.get(String.format("" + activeX + activeY + x + y)).getText() == null) {
					full = false;
				}
			}
		}
		if (!full) {
			int i,j,k,l;
			for (i=0;i<3;i++) {
				for (j=0;j<3;j++) {
					for (k=0;k<3;k++) {
						for (l=0;l<3;l++) {
							spaces.get(String.format("" + i + j + k + l)).setEnabled(false);
						}
					}
				}
			}
		
			for (k=0;k<3;k++) {
				for (l=0;l<3;l++) {
					spaces.get(String.format("" + activeX + activeY + k + l)).setEnabled(true);
				}
			}
		} else {
			unlockAll();
			if (player == "X") {
				player = "O";
			} else {
				player = "X";
			}
		}
		removeAll();
		if (!UTTTGUI.first) {
			checkSmall(activeX, activeY);
			UTTTGUI.first = false;
		}
		layoutSpaces();
	}
	
	public void unlockAll() {
		int i,j,k,l;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				for (k=0;k<3;k++) {
					for (l=0;l<3;l++) {
						spaces.get(String.format("" + i + j + k + l)).setEnabled(true);
					}
				}
			}
		}
	}
	
	public void checkSmall(int x, int y) {
		//check for win inside last small box (one that wejust came from)
		
		//((JButton)this.getComponents()[_ + 3 * _ + 9 * x + 27 * y]).getText()
		if (((JLabel)(UTTTGUI.wBoard.getComponents()[x + 3 * y])).getText() == "") {
			if ((
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[0 + 3 * 1 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[0 + 3 * 2 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() != "0"
					) || (
					((JButton)this.getComponents()[1 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[1 + 3 * 1 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[1 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[1 + 3 * 2 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[1 + 3 * 0 + 9 * x + 27 * y]).getText() != "0"
					) || (
					((JButton)this.getComponents()[2 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[2 + 3 * 1 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[2 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[2 + 3 * 2 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[2 + 3 * 0 + 9 * x + 27 * y]).getText() != "0"
					) || (
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[1 + 3 * 0 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[2 + 3 * 0 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() != "0"
					) || (
					((JButton)this.getComponents()[0 + 3 * 1 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[1 + 3 * 1 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 1 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[2 + 3 * 1 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 1 + 9 * x + 27 * y]).getText() != "0"
					) || (
					((JButton)this.getComponents()[0 + 3 * 2 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[1 + 3 * 2 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 2 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[2 + 3 * 2 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 2 + 9 * x + 27 * y]).getText() != "0"
					) || (
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[1 + 3 * 1 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[2 + 3 * 2 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 0 + 9 * x + 27 * y]).getText() != "0"
					) || (
					((JButton)this.getComponents()[0 + 3 * 2 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[1 + 3 * 1 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 2 + 9 * x + 27 * y]).getText() == ((JButton)this.getComponents()[2 + 3 * 0 + 9 * x + 27 * y]).getText() && 
					((JButton)this.getComponents()[0 + 3 * 2 + 9 * x + 27 * y]).getText() != "0"
					)){
				((JLabel)(UTTTGUI.wBoard.getComponents()[x + 3 * y])).setText(player);
			}			
		}

	}
	
}
