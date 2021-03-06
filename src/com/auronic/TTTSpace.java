package com.auronic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TTTSpace extends JButton {
	private static final long serialVersionUID = 1L;
	public String value = null;
	public Coords xy;
	
	public TTTSpace(int i, int j, int k, int l) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String player = getPlayer();
				((TTTSpace)(ae.getSource())).setText(player);
				value = player;
				((TTTSpace)(ae.getSource())).removeActionListener(this);
				switch (player) {
				case "X":
					Board.player = "O";
					break;
				case "O":
					Board.player = "X";
					break;
				}
				((Board)((TTTSpace)(ae.getSource())).getParent()).lockInactive(k, l);
			}
		});
		this.setFont(new Font("Arial", Font.PLAIN, 28));
		this.setText(value);
		xy = new Coords(i,j,k,l);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(60,60);
	}
	
	public String getPlayer() {
		return Board.player;
	}
}
