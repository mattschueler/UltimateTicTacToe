package com.auronic;

import java.util.Scanner;

public class UTTT {

	/**
	 * @param args
	 */
	
	/*public static void main(String[] args) {
		System.out.println();
		int currentPlayer=1;
		int board [][][][] = new int [3][3][3][3];
		int previous[] = {1,1};
		int checkBox[];
		int bigBox[][] = new int[3][3];
		//initialize the boards for the game
		BoardBuilderBig(bigBox);
		BoardBuilderFull(board);
		println("Time to play a game...");
		//begin game loop
		int i;
		for (i=0;i<1;) {
			//print what the board looks like
			BoardPrinter(board);
			//print which box the game is in and the large grid
			PrintSquare(previous,bigBox);
			switch(currentPlayer) {
			case 1:	
				println("X");
				break;
			case 2:
				println("O");
				break;
			default:
				break;
			}
			//set the box to be checked to the last move made
			checkBox = previous;
			//let the player make a move
			previous=MakeMove(currentPlayer,board,previous);
			//check to see if there was a win in the small box of the previous move
			if (CheckForWinSmall(board,checkBox)!=0)
			bigBox[checkBox[0]][checkBox[1]]=CheckForWinSmall(board,checkBox);
			//check then to see if anyone has won on the larger board
			switch (CheckForWinBig(bigBox)) {
				case 1:
					println("Player 1 wins!");
					i=1;
					PrintSquare(previous,bigBox);
					break;
				case 2:
					println("Player 2 wins!");
					i=1;
					PrintSquare(previous,bigBox);
					break;
				default:
					break;
			}
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
	
	public static void println(String string) {
	    System.out.println(string);
	}
	
	public static void print(String string) {
		System.out.print(string);
	}
	
	public static void BoardBuilderFull(int board[][][][]) {
		//build the board for the game as a 3x3 array with 3x3 inside each square with 0s in every array index
		int i,j,k,l;
		for (i=0;i<3;i++) {
			for (k=0;k<3;k++) {
				for (j=0;j<3;j++) {
					for (l=0;l<3;l++) {
						board [i][j][k][l]=0;
					}
				}
			}
		}
	}
	
	public static void BoardBuilderBig(int bigBoard[][]) {
		int i,j;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				bigBoard [i][j]=0;
			}
		}
	}
	
	public static void BoardPrinter(int board[][][][]) {
		//print out the board with * as empty spaces X as player one and O as player 2
		int i,j,k,l;
		/*
		 * i is big row, j is big column, k is small row, l is small column
		 * order: i,k,j,l
		 * Will be slightly different from standard thinking
		 * because it has to print each full row at a time
		 */
		for (i=0;i<3;i++) {
			for (k=0;k<3;k++) {
				for (j=0;j<3;j++) {
					for (l=0;l<3;l++) {
						switch (board [i][j][k][l]) {
							case 0:
								print("*");
								break;
							case 1:
								print("X");
								break;
							case 2:
								print("O");
								break;
							default:
								break;
						}
						//end of l loop
					}
					//end of j loop
					//Print out a divider between squares of the same horizontal level
					print("|");
				}
				//end of k loop
				println("");
			}
			//end of i loop
			//print out a divider between the large rows, but only on the first two loop
			//iterations, not on the last one, otherwise there would be a line under the grid
			if (i<2) {
			println("____________");
			}
		}
	}
	
	public static int[] MakeMove(int player, int board[][][][], int[] newBox) {
		//read in the moves for the player and attempt to make them
		int move [] = {0,0};
		String input;
		Scanner scanner = new Scanner(System.in);
		//read in the row for the move and assign to array move at index 0
		print("Please type row:");
		input = scanner.nextLine();
		if (!input.isEmpty()) {
			move[0]=Integer.parseInt(input);
		}
		//read in the column for the move and assign to array move at index 1
		print("Please type column:");
	    input = scanner.nextLine();
	    if (!input.isEmpty()) {
			move[1]=Integer.parseInt(input);
		}
	    //check to make sure that the input is inside the bounds of the array
		if (move[0]<4 && move[1]<4) {
			/*
			 * check to make sure that the square is not already taken
			 * newBox[0] and newBox[1] are the row and column of the previous move, 
			 * which tells in which sector the move is being made
			 */
			if (board[newBox[0]][newBox[1]][move[0]-1][move[1]-1]==0) {
				board[newBox[0]][newBox[1]][move[0]-1][move[1]-1]=player;
			}
			else {
				//tell user move is not valid and call the method again to try a new move
				println("Invalid Move");
				MakeMove(player,board,newBox);
			}
		}
		else {
			//tell user move is not valid and call the method again to try a new move
			println("Invalid Move");
			MakeMove(player,board,newBox);
		}
		int nextBox[]= {move[0]-1,move[1]-1};
		return nextBox;
	}

	public static int CheckForWinSmall(int board [][][][], int[] lastMove) {
		int winner=0;
		
		if (board[lastMove[0]][lastMove[1]][0][0]==board[lastMove[0]][lastMove[1]][0][1] && board[lastMove[0]][lastMove[1]][0][0]==board[lastMove[0]][lastMove[1]][0][2] && board[lastMove[0]][lastMove[1]][0][0]!=0) {
			winner=board[lastMove[0]][lastMove[1]][0][0];
		}
		else if (board[lastMove[0]][lastMove[1]][1][0]==board[lastMove[0]][lastMove[1]][1][1] && board[lastMove[0]][lastMove[1]][1][0]==board[lastMove[0]][lastMove[1]][1][2] && board[lastMove[0]][lastMove[1]][1][0]!=0) {
			winner=board[lastMove[0]][lastMove[1]][1][0];
		}
		else if (board[lastMove[0]][lastMove[1]][2][0]==board[lastMove[0]][lastMove[1]][2][1] && board[lastMove[0]][lastMove[1]][2][0]==board[lastMove[0]][lastMove[1]][2][2] && board[lastMove[0]][lastMove[1]][2][0]!=0) {
			winner=board[lastMove[0]][lastMove[1]][2][0];
		}
		else if (board[lastMove[0]][lastMove[1]][0][0]==board[lastMove[0]][lastMove[1]][1][0] && board[lastMove[0]][lastMove[1]][0][0]==board[lastMove[0]][lastMove[1]][2][0] && board[lastMove[0]][lastMove[1]][0][0]!=0) {
			winner=board[lastMove[0]][lastMove[1]][2][0];
		}
		else if (board[lastMove[0]][lastMove[1]][0][1]==board[lastMove[0]][lastMove[1]][1][1] && board[lastMove[0]][lastMove[1]][0][1]==board[lastMove[0]][lastMove[1]][2][1] && board[lastMove[0]][lastMove[1]][0][1]!=0) {
			winner=board[lastMove[0]][lastMove[1]][0][1];
		}
		else if (board[lastMove[0]][lastMove[1]][0][2]==board[lastMove[0]][lastMove[1]][1][2] && board[lastMove[0]][lastMove[1]][0][2]==board[lastMove[0]][lastMove[1]][2][2] && board[lastMove[0]][lastMove[1]][0][2]!=0) {
			winner=board[lastMove[0]][lastMove[1]][0][2];
		}
		else if (board[lastMove[0]][lastMove[1]][0][0]==board[lastMove[0]][lastMove[1]][1][1] && board[lastMove[0]][lastMove[1]][0][0]==board[lastMove[0]][lastMove[1]][2][2] && board[lastMove[0]][lastMove[1]][0][0]!=0) {
			winner=board[lastMove[0]][lastMove[1]][0][0];
		}
		else if (board[lastMove[0]][lastMove[1]][0][2]==board[lastMove[0]][lastMove[1]][1][1] && board[lastMove[0]][lastMove[1]][0][2]==board[lastMove[0]][lastMove[1]][2][0] && board[lastMove[0]][lastMove[1]][0][2]!=0) {
			winner=board[lastMove[0]][lastMove[1]][0][2];
		}
		else {
			winner=0;
		}
		
		return winner;
	}

	public static int CheckForWinBig(int bigBoard [][]) {
		int winner=0;
		//check all possible winning states: 3 rows, 3 columns, 2 diagonals
		if (bigBoard[0][0]==bigBoard[0][1] && bigBoard[0][0]==bigBoard[0][2] && bigBoard[0][0]!=0) {
			winner=bigBoard[0][0];
		}
		else if (bigBoard[1][0]==bigBoard[1][1] && bigBoard[1][0]==bigBoard[1][2] && bigBoard[1][0]!=0) {
			winner=bigBoard[1][0];
		}
		else if (bigBoard[2][0]==bigBoard[2][1] && bigBoard[2][0]==bigBoard[2][2] && bigBoard[2][0]!=0) {
			winner=bigBoard[2][0];
		}
		else if (bigBoard[0][0]==bigBoard[1][0] && bigBoard[0][0]==bigBoard[2][0] && bigBoard[0][0]!=0) {
			winner=bigBoard[2][0];
		}
		else if (bigBoard[0][1]==bigBoard[1][1] && bigBoard[0][1]==bigBoard[2][1] && bigBoard[0][1]!=0) {
			winner=bigBoard[0][1];
		}
		else if (bigBoard[0][2]==bigBoard[1][2] && bigBoard[0][2]==bigBoard[2][2] && bigBoard[0][2]!=0) {
			winner=bigBoard[0][2];
		}
		else if (bigBoard[0][0]==bigBoard[1][1] && bigBoard[0][0]==bigBoard[2][2] && bigBoard[0][0]!=0) {
			winner=bigBoard[0][0];
		}
		else if (bigBoard[0][2]==bigBoard[1][1] && bigBoard[0][2]==bigBoard[2][0] && bigBoard[0][2]!=0) {
			winner=bigBoard[0][2];
		}
		else {
			winner=0;
		}
		return winner;
	}
	
	public static void PrintSquare(int[] lastMove,int bigBox[][]) {
		switch (lastMove[0]) {
		case 0:
			switch (lastMove[1]) {
			case 0:
				println("Top Left");
				break;
			case 1:
				println("Top Center");
				break;
			case 2:
				println("Top Right");
				break;
			default:
				break;
			}
			break;
		case 1:
			switch (lastMove[1]) {
			case 0:
				println("Center Left");
				break;
			case 1:
				println("Center Center");
				break;
			case 2:
				println("Center Right");
				break;
			default:
				break;
			}
			break;
		case 2:
			switch (lastMove[1]) {
			case 0:
				println("Bottom Left");
				break;
			case 1:
				println("Bottom Center");
				break;
			case 2:
				println("Bottom Right");
				break;
			default:
				break;
			}
			break;
		default:
			break;	
		}
		int i,j;
		for (i=0;i<3;i++) {
			for (j=0;j<3;j++) {
				switch(bigBox[i][j]) {
					case 0:
						print("*");
						break;
					case 1:
						print("X");
						break;
					case 2:
						print("O");
						break;
					default:
						break;
				}
			}
			println("");
		}
	}
}
