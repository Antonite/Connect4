/*
 * Connect4.java
 * 
 * $Id: Connect4.java,v 1.17 2012-04-19 01:46:29 axp9304 Exp $
 */

/**
 * Connect4 is the main class for connect four programm.
 *
 * @author Anton Pashyk axp9304@g.rit.edu
 */
public class Connect4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** initial board variable */
		board board = null;
		/** default column number */
		int column = 4;
		/** default row number */
		int row = 4;
		// Testing for valid arguments
		if(args.length == 2) board = new board(row,column);
		if(args.length != 2 && args.length != 4) {
			System.err.print("Usage: java Connect4 player-X player-O [#rows #cols]\nwhere player-X and player-O are one of: human bad good random\n[#rows #cols] are optional, if provided their values must be\nin the ranges: #rows from 1 to 6 and #cols from 1 to 7");
			System.exit(0);
		}
		// Testing for valid arguments
		if(args.length == 4) {
			board = new board(row,column);
			row = Integer.parseInt(args[2]);
			column = Integer.parseInt(args[3]);
			if (column > 7 || row > 6 || column <= 0 || row <= 0){
				System.err.print("Usage: java Connect4 player-X player-O [#rows #cols]\nwhere player-X and player-O are one of: human bad good random\n[#rows #cols] are optional, if provided their values must be\nin the ranges: #rows from 1 to 6 and #cols from 1 to 7");
				System.exit(0);
			}
			/** Create final board */
			board = new board(row, column);
		}
		/** Creation of mind intelligence instances */
		mind player1 = null;
		mind player2 = null;
		if (args[0].equals("human")) player1 = new human(board);
		if (args[0].equals("random")) player1 = new random(board);
		if (args[0].equals("bad")) player1 = new bad(board);
		if (args[0].equals("good")) player1 = new good(board);
		if (args[1].equals("human")) player2 = new human(board);
		if (args[1].equals("random")) player2 = new random(board);
		if (args[1].equals("bad")) player2 = new bad(board);
		if (args[1].equals("good")) player2 = new good(board);
		// Testing for valid arguments
		if (player1 == null || player2 == null){
			System.err.print("Usage: java Connect4 player-X player-O [#rows #cols]\nwhere player-X and player-O are one of: human bad good random\n[#rows #cols] are optional, if provided their values must be\nin the ranges: #rows from 1 to 6 and #cols from 1 to 7");
			System.exit(0);
		}
		
		/** Default print strings */
		String play1 = args[0] + " player X moving...";
		String play2 = args[1] + " player O moving...";
		
		//Print initial empty board
		board.printBoard();
		
		//Game Play happens in this while loop
		int moveCounter = 0;
		String end = board.endgame();
		while (end == "No"){
			//For player X
			if (moveCounter % 2 == 0){
				System.out.print(play1);
				int move = player1.getMove("X", column);
				System.out.println("\nPlayer drops an X piece into column: " + Integer.toString(move));
				board.move(move, "X");
				end = board.endgame();
				moveCounter++;
			}
			else{
				//For player O
				System.out.print(play2);
				int move = player2.getMove("O", column);
				System.out.println("\nPlayer drops an O piece into column: " + Integer.toString(move));
				board.move(move, "O");
				end = board.endgame();
				moveCounter++;
			}
			//End game messages
			if (end.charAt(0) == 'h')	System.out.println(end.charAt(1) + " won in row " + end.charAt(2));
			if (end.charAt(0) == 'v')	System.out.println(end.charAt(1) + " won in column " + end.charAt(2));
			if (end.charAt(0) == 'd')	System.out.println(end.charAt(1) + " won on a diagonal");
			if (end.charAt(0) == 'I')	System.out.println("Its a tie, no one wins");
			board.printBoard();
		}

	}

}

/*
* $Log: Connect4.java,v $
* Revision 1.17  2012-04-19 01:46:29  axp9304
* commenting done, text files filled out. final formatting/bug fixing. Final version
*
* Revision 1.16  2012-04-19 00:05:10  axp9304
* update to previous update
*
* Revision 1.15  2012-04-19 00:03:12  axp9304
* update to output
*
* Revision 1.14  2012-04-19 00:00:55  axp9304
* minor bugs
*
* Revision 1.13  2012-04-18 23:59:22  axp9304
* finally fixed row vs column bug - switched order of constructors between classes
*
* Revision 1.12  2012-04-18 21:48:55  axp9304
* row vs column bug should be fixed now
*
* Revision 1.11  2012-04-18 21:45:05  axp9304
* row vs column not fixed apparently.. testing...
*
* Revision 1.10  2012-04-18 21:42:04  axp9304
* NOW row and column are fixed
*
* Revision 1.9  2012-04-18 21:39:34  axp9304
* column vs row confusion fixed
*
* Revision 1.8  2012-04-18 21:35:13  axp9304
* gotta love bugs
*
* Revision 1.7  2012-04-18 21:30:54  axp9304
* more bugs...
*
* Revision 1.6  2012-04-18 21:29:07  axp9304
* bugs
*
* Revision 1.5  2012-04-18 21:07:27  axp9304
* more error outputs fixed
*
* Revision 1.4  2012-04-18 20:35:11  axp9304
* multiple inputs, error messages bugs fixed
*
* Revision 1.3  2012-04-18 19:58:39  axp9304
* good player strategy working
*
* Revision 1.2  2012-04-18 18:38:10  axp9304
* fixed human termination
*
* Revision 1.1  2012-04-18 09:59:24  axp9304
* bugs fixed
*
* Revision 1.0  2012-04-18 5:51:31  axp9304
* initial revision
*
*/