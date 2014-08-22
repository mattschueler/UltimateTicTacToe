package com.auronic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import java.awt.Color;
import java.awt.Dimension;

import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Board extends JPanel {
	private static final long serialVersionUID = 1L;
	public static String player;
	public static HashMap<String, TTTSpace> spaces;
	public SpringLayout boardLayout;
		
	public Board() {
		player = "X";
		spaces = new HashMap<String, TTTSpace>(81,1);
		createSpaces();
		boardLayout = new SpringLayout();
		this.setLayout(boardLayout);
		lockInactive(1,1);
	}
	
	private static void createSpaces() {
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));
	 
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString("GGWP", 10, 20);
	 
		//save this image
		//ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));
	 
		for (int y = 0; y < 30; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < 100; x++) {
	 
				sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
	 
			}
	 
			if (sb.toString().trim().isEmpty()) {
				continue;
			}
	 
			System.out.println(sb);
		}
		System.out.println("\n\n\n\n\n");
		g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));
	 
		graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	
		//save this image
		//ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));
	 
		for (int y = 0; y < 30; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < 100; x++) {
	 
				sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
	 
			}
	 
			if (sb.toString().trim().isEmpty()) {
				continue;
			}
	 
			System.out.println(sb);
		
	 
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
	
}
