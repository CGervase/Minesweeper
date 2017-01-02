import java.util.Scanner;

public class Minesweeper {
  public static void main(String[] args) {
    System.out.println("Welcome to Minesweeper! This game plays like a traditional Minesweeper game. The board's coordinates are set up like a Battleship board, using (0, 0) as the top left corner. Input should be formatted like so: 'v h' where v and h are the vertical and horizontal coordinates, respectively.");
    System.out.println();
    
    //for custom board formats, enter height, width, and # of mines between parentheses
    //ex: Board b = new Board(20, 20, 99);
    Board b = new Board();
    b.display();
    Scanner input = new Scanner(System.in);
    int v;	//vertical coordinate
    int h;	//horizontal coordinate
    
    //Game is now in progress, loops until the game is over
    while (!b.getGameState()) {
    	System.out.print("Please enter each coordinate separated by a space: ");
    	boolean check = true;	//flag for try/catch block
    	do {
    		try {
    			v = input.nextInt();
    			h = input.nextInt();
    			b.uncover(v, h);
    			b.display();
    			check = false;
    		}
    		catch (Exception e) {
    			System.out.println("Try again, input must be two integers separated by a space: ");
    			input.next();
    		}
    	} while (check);
    }
    System.out.println("Game over");
    
  }
}