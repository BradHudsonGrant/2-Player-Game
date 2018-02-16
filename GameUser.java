import java.util.*;
import java.io.*;
// Class GameUser
public class GameUser {
	
//Main	
	public static void main(String[] args) {

		//Attributes
		boolean robot = false;		

		// create a new scanner for the user to input from the keyboard
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter '1' for 2 players or '2' for playing with computer");
			int gameType = sc.nextInt();
			while (gameType<=0 || gameType>=3){
				System.out.println("Between 1 and 2");
				gameType = sc.nextInt();
				continue;
			}
		// If the user entered 2 or 1 change whether the robot will be used or not
		if (gameType==2){
			robot=true;
		}
		else{
			robot=false;
		}
		
		// create an instance of the Game class using the game type boolean
		Game GameObject = new Game(robot);	
		// call the method to show the starting board
		GameObject.gameBoard();
		
		// if the game type was 1 (with second player) do this loop if it was 2 then do the second loop that also calls the getRobotChoice method
		if (gameType==1)
		for (int count=1; count<=25; count++){
		GameObject.askPlayer();
		GameObject.playerPoint();
		GameObject.gameBoard();
		GameObject.checkWin();
		GameObject.changeTurn();
		}
		else if (gameType==2)
		for (int count=1; count<=25; count++){
		GameObject.askPlayer();
		GameObject.playerPoint();
		GameObject.gameBoard();
		GameObject.checkWin();
			
		GameObject.getRobotChoice();
		GameObject.changeTurn();
		GameObject.playerPoint();
		GameObject.gameBoard();
		GameObject.checkWin();
		GameObject.changeTurn();
		}
		GameObject.printDraw();
		
		
	}
}