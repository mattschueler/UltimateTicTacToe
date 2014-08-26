package com.auronic;

import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class WinBoard extends JPanel {
	private static final long serialVersionUID = 1L;
	private SpringLayout sl;
	public HashMap<String, JLabel> bigSpaces;
	public JSeparator x1, x2, y1, y2;
	
	public WinBoard() {
		sl = new SpringLayout();
		x1 = new JSeparator();
		x2 = new JSeparator();
		y1 = new JSeparator();
		y2 = new JSeparator();
		bigSpaces = new HashMap<String, JLabel>();
		this.setLayout(sl);
		int i, j;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				bigSpaces.put(String.format("" + i + j), new JLabel("", JLabel.CENTER));
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
		x1.setOrientation(SwingConstants.VERTICAL);
		sl.putConstraint(SpringLayout.NORTH, x1, 0, SpringLayout.NORTH, bigSpaces.get("00"));
		sl.putConstraint(SpringLayout.WEST, x1, 5, SpringLayout.EAST, bigSpaces.get("00"));
		sl.putConstraint(SpringLayout.SOUTH, x1, 0, SpringLayout.SOUTH, bigSpaces.get("02"));
		this.add(x1);
		x2.setOrientation(SwingConstants.VERTICAL);
		sl.putConstraint(SpringLayout.NORTH, x2, 0, SpringLayout.NORTH, bigSpaces.get("10"));
		sl.putConstraint(SpringLayout.WEST, x2, 5, SpringLayout.EAST, bigSpaces.get("10"));
		sl.putConstraint(SpringLayout.SOUTH, x2, 0, SpringLayout.SOUTH, bigSpaces.get("12"));
		this.add(x2);
		y1.setOrientation(SwingConstants.HORIZONTAL);
		sl.putConstraint(SpringLayout.NORTH, y1, 0, SpringLayout.SOUTH, bigSpaces.get("00"));
		sl.putConstraint(SpringLayout.WEST, y1, 5, SpringLayout.WEST, bigSpaces.get("00"));
		sl.putConstraint(SpringLayout.EAST, y1, 0, SpringLayout.EAST, bigSpaces.get("20"));
		this.add(y1);
		y2.setOrientation(SwingConstants.HORIZONTAL);
		sl.putConstraint(SpringLayout.NORTH, y2, 0, SpringLayout.SOUTH, bigSpaces.get("01"));
		sl.putConstraint(SpringLayout.WEST, y2, 5, SpringLayout.WEST, bigSpaces.get("01"));
		sl.putConstraint(SpringLayout.EAST, y2, 0, SpringLayout.EAST, bigSpaces.get("21"));
		this.add(y2);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400,400);
	}
}
