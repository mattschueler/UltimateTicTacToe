package com.auronic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class WinBoard extends JPanel {

	private SpringLayout sl;
	public HashMap<String, JLabel> bigSpaces;
	
	public WinBoard() {
		sl = new SpringLayout();
		bigSpaces = new HashMap<String, JLabel>();
		this.setLayout(sl);
		int i, j;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				bigSpaces.put(String.format("" + i + j), new JLabel("abcde"));
			}
		}
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				if (i == 0) {
					sl.putConstraint(SpringLayout.WEST, bigSpaces.get(String.format("" + i + j)), 10, SpringLayout.WEST, this);
				} else {
					sl.putConstraint(SpringLayout.WEST, bigSpaces.get(String.format("" + i + j)), 10, SpringLayout.EAST, bigSpaces.get(String.format("" + (i-1) + j)));
				}
				if (j == 0) {
					sl.putConstraint(SpringLayout.NORTH, bigSpaces.get(String.format("" + i + j)), 10, SpringLayout.NORTH, this);
				} else {
					sl.putConstraint(SpringLayout.NORTH, bigSpaces.get(String.format("" + i + j)), 10, SpringLayout.SOUTH, bigSpaces.get(String.format("" + i + (j-1))));
				}
				bigSpaces.get(String.format("" + i + j)).setPreferredSize(new Dimension(80,80));
				bigSpaces.get(String.format("" + i + j)).setFont(new Font("Arial", Font.PLAIN, 28));
				this.add(bigSpaces.get(String.format("" + i + j)));
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400,400);
	}
}
