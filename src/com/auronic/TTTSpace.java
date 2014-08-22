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
		
			   
		    double answer, top, bottom, terms, increment;  
		    terms=Math.abs(0);  
		    top=Math.abs(1);  
		    bottom=Math.abs(1);  
		    answer=Math.abs(1);  
		    increment=Math.abs(1);  
		      
		          
		    while (answer != 2.71828183){  
		    //for(int i=1;i<25;i++){  
		        answer+=(top/bottom);  
		        increment++;  
		        bottom*=increment;  
		        terms++;  
		          
		        //System.out.println("#:"+increment+" "+bottom+". Answer:"+answer);  
		        //System.out.println(answer);  
		          
		    }
		    System.out.println("The amount of terms needed is: "+terms);  
		    /* 
		    System.out.println(answer); 
		    System.out.println(increment); 
		    System.out.println(bottom); 
		    */  
		    
		  
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
