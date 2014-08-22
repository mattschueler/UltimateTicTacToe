package com.auronic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class GameClass {

	/**
	 * @param args
	 */
	
	/*public static void main(String[] args) {
		int currentPlayer=1;
		int board [][] = new int [3][3];
		//initialize the board for the game
		BoardBuilder(board);
		System.out.println("Time to play a game...");
		BoardPrinter(board);
		//begin game loop
		int i;
		for (i=0;i<9;i++) {
			//print out what the board looks like
			//attempt to make a move for player currentPlayer (1 or 2)
			MakeMove(currentPlayer,board);
			//after the move has been made check to see if any player has won the game
			if (CheckForWin(board)!=0) {
				switch (CheckForWin(board)) {
				case 1:
					System.out.println("Player 1 wins!");
					break;
				case 2:
					System.out.println("Player 2 wins!");
					break;
				default:
					break;
				}
				break;
			}
			BoardPrinter(board);
			//switch the turn to the other player
			switch (currentPlayer) {
			case 1:
				currentPlayer=2;
				break;
			case 2:
				currentPlayer=1;
				break;
			default:
				break;
			}
		}
		
	}*/
	
	public static void BoardBuilder(int board[][]) {
		
	  
		//build the board for the game as a 3x3 array with 0s in every array index
		int i,j;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				board [i][j]=0;
			}
		}
	}
	
	public static void BoardPrinter(int board[][]) {
		//print out the board with * as empty spaces X as player one and O as player 2
		int i,j;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				switch (board [i][j]) {
				case 0:
					System.out.print("X");
					break;
				case 1:
					System.out.print("O");
					break;
				case 2:
					System.out.print("*");
					break;
				default:
					break;
				}
			}
			//go to next line after every row is printed
			System.out.println("");
		}
		//go to next line after the entire grid has been printed
		System.out.println("");
	}
	
	public static void MakeMove(int player, int board[][]) {
		//read in the moves for the player and attempt to make them
		int move [] = {0,0};
		String input;
		Scanner scanner = new Scanner(System.in);
		//read in the row for the move and assign to array move at index 0
		System.out.print("Please type row:");
		input = scanner.nextLine();
		move[0]=Integer.parseInt(input);
		//read in the column for the move and assign to array move at index 1
		System.out.print("Please type column:");
	    input = scanner.nextLine();
	    move[1]=Integer.parseInt(input);
	    //check to make sure that the input is inside the bounds of the array
		if (move[0]<4 && move[1]<4) {
			//check to make sure that the square is not already taken
			if (board[move[0]-1][move[1]-1]==0) {
				board[move[0]-1][move[1]-1]=player;
			}
			else {
				//tell user move is not valid and call the method again to try a new move
				System.out.println("Invalid Move");
				MakeMove(player,board);
			}
		}
		else {
			//tell user move is not valid and call the method again to try a new move
			System.out.println("Invalid Move");
			MakeMove(player,board);
		}
	}

	public static int CheckForWin(int board [][]) {
		int winner=0;
		
		/*
		 * Possible Win States
		 * 00 01 02
		 * 10 11 12
		 * 20 21 22
		 * 00 10 20
		 * 01 11 21
		 * 02 12 22
		 * 00 11 22
		 * 02 11 20		
		 */
		//check all possible winning states: 3 rows, 3 columns, 2 diagonals
		if (board[0][0]==board[0][1] && board[0][0]==board[0][2] && board[0][0]!=0) {
			winner=board[0][0];
		}
		else if (board[1][0]==board[1][1] && board[1][0]==board[1][2] && board[1][0]!=0) {
			winner=board[1][0];
		}
		else if (board[2][0]==board[2][1] && board[2][0]==board[2][2] && board[2][0]!=0) {
			winner=board[2][0];
		}
		else if (board[0][0]==board[1][0] && board[0][0]==board[2][0] && board[0][0]!=0) {
			winner=board[2][0];
		}
		else if (board[0][1]==board[1][1] && board[0][1]==board[2][1] && board[0][1]!=0) {
			winner=board[0][1];
		}
		else if (board[0][2]==board[1][2] && board[0][2]==board[2][2] && board[0][2]!=0) {
			winner=board[0][2];
		}
		else if (board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]!=0) {
			winner=board[0][0];
		}
		else if (board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]!=0) {
			winner=board[0][2];
		}
		else {
			winner=0;
		}
		return winner;
	}

}
