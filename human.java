/*
 * human.java
 * 
 * $Id: human.java,v 1.8 2012-04-19 01:46:30 axp9304 Exp $
 */

/**
 * human is the class for a human computer player.
 *
 * @author Anton Pashyk axp9304@g.rit.edu
 */

import java.util.Scanner;
import java.util.regex.*;

public class human extends mind implements player{
	private static Scanner input = new Scanner(System.in);
    /**
     * human initializes member fields of an instance.
     * @param    board      the playing board
     */
	public human(board board){
		super(board);
	}
	/**
	    * getMove get the move of the player.
	    *
	    * @param type	"X" or "O" type of player.
	    * @param max	maximal number of columns allowed for a move.
	    * @return the column of the move to be made.
	    */
	public int getMove(String type, int max) {
		System.out.print("\nPlayer " + type + ": Enter the column to drop your piece (-1 to quit): ");
		String in = input.nextLine();
		boolean isInteger = false;
		//Testing for validity of input
		while (! isInteger){
			//does input look like -1?
			if (in.length() > 1){
				if (in.charAt(0) == '-' && in.charAt(1) == '1'){
					System.out.println(type + " quits the game");
					board.printBoard();
					System.exit(0);
				}
				}
			//does input look like an integer
			isInteger = Pattern.matches("\\d+", in);
			if (! isInteger){
				System.out.print("\nPlayer " + type + ": Enter the column to drop your piece (-1 to quit): ");
				in = input.nextLine();
				isInteger = false;
			}
			else{
				//does input fit into specified column dimension
				int result = Integer.parseInt(in);
				if (result >= max){
					System.out.print("invalid column: " + result);
					System.out.print("\nPlayer " + type + ": Enter the column to drop your piece (-1 to quit): ");
					in = input.nextLine();
					isInteger = false;
				}
				else{
					//does input fit into specified column at all
					if (board.full(result)){
						System.out.print("invalid column: " + result);
						System.out.print("\nPlayer " + type + ": Enter the column to drop your piece (-1 to quit): ");
						in = input.nextLine();
						isInteger = false;
					}
					
				}
			}
		}
		//return output after all tests passed
		int output = Integer.parseInt(in);
		return output;
	}

}

/*
* $Log: human.java,v $
* Revision 1.8  2012-04-19 01:46:30  axp9304
* commenting done, text files filled out. final formatting/bug fixing. Final version
*
* Revision 1.7  2012-04-18 21:35:13  axp9304
* gotta love bugs
*
* Revision 1.6  2012-04-18 21:30:55  axp9304
* more bugs...
*
* Revision 1.5  2012-04-18 21:29:07  axp9304
* bugs
*
* Revision 1.4  2012-04-18 21:07:27  axp9304
* more error outputs fixed
*
* Revision 1.3  2012-04-18 19:58:40  axp9304
* good player strategy working
*
* Revision 1.2  2012-04-18 18:38:11  axp9304
* fixed human termination
*
* Revision 1.1  2012-04-18 09:59:24  axp9304
* bugs fixed
*
* Revision 1.0  2012-04-18 5:51:31  axp9304
* initial revision
*
*/
