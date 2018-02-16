import java.util.*;
import java.io.*;
// Class Game
public class Game{

	// Attributes
	private int playerUser;
	private	int [][] array = new int [5][5];
	private	int nextTurn = 1;
	private	Scanner sc = new Scanner(System.in);
	private	int robotChoice;
	private	boolean gameType;
	
	//Constructors
	public Game(boolean robot){
	gameType = robot;
	}
	//Methods
	// Method to allow the user to input position
	public void askPlayer(){
		// ask the player for their chosen position
		System.out.println("Player " + nextTurn + " input the desired position between 1 and 25");
		// let the next integer inputted be assigned to the playerUser variable
		playerUser = sc.nextInt();
		//  If they do not enter an integer between 1 and 25 then print invalid message and let them try again
		while (playerUser<=0 || playerUser>=26){
			System.out.println("Between 1 and 25");
			playerUser = sc.nextInt();
			continue;
		}
	}
	// Method to change the players number
	public int changeTurn(){
		if (nextTurn == 1){
			nextTurn = 2;
		}
		else {
		nextTurn = 1;
		}
		return nextTurn;		
	}
	// Method to generate the computers choice if in the 2nd game type
	public int getRobotChoice(){
	robotChoice = (int)(Math.random() * (25 - 1) + 1);
	System.out.println("The Robot chose " + robotChoice);
	playerUser = robotChoice;
	return playerUser;
	}
	
	// Method to check if the current player has won or not
	public void checkWin(){		
		int x1=0;
		int x2=1;
		int y1=0;
		int y2=1;
		// check 5 sets of 5 subsets. First 5 subsets have the first x1 and x2 values then increment them at the end of the loop
		for (int sets=1; sets<5; sets++){
			// goes through a set of subsets with the x1 and x2
			for(int count=1; count<5; count++){
					if (array[x1][y1]==nextTurn){
						if(array[x1][y2]==nextTurn){
							if(array[x2][y1]==nextTurn){
								if(array[x2][y2]==nextTurn){
									System.out.println("Player " + nextTurn + " is the winner!");
									System.exit(1);
								}
							}
						} 
					}
					//increment the y values
				else{
					y1++;
					y2++;
				}
			}
			// reset the y values for the next set
			y1 = 0;
			y2 = 1;
			// increment the x values to read the next set
			x1++;
			x2++;
		}
	}
	// Method to print the 5 by 5 grid 
	public void gameBoard (){
		System.out.println();
		for(int row=0; row<array.length; row++) {
			for(int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col]);
				if(col < array[row].length - 1)
					System.out.print(" ");
			}
				System.out.println();
		}
		System.out.println();
	}
	// Method to print draw message and stop the program
	public void printDraw(){
			System.out.println("The Grid Is Full Its a Draw");
			System.exit(1);l
	}
	
	// method to add the players position chocen to the grid
	public void playerPoint(){
		int playerRow;
		int playerCol;
			playerRow = (playerUser -1)/5;
			playerCol = (playerUser -1)%5;
			// if the position is taken allow the current player to try again
			while  (array[playerRow][playerCol]>0) {
				System.out.println("This position has already been taken");
				// if the computer is playing then call the method to generate another number
				if (gameType==true){
					getRobotChoice();
				}
				// if there are 2 players call the ask player method
				else if (gameType==false){
				askPlayer();
				}
				playerRow = (playerUser -1)/5;
				playerCol = (playerUser -1)%5;
				continue;
			}
			//in that row and column replace the 0 with the players number
			array[playerRow][playerCol] = nextTurn;
	}
}