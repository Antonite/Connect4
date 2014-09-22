/*
 * good.java
 * 
 * $Id: good.java,v 1.4 2012-04-19 01:46:29 axp9304 Exp $
 */

/**
 * good is the class for a good computer player.
 *
 * @author Anton Pashyk axp9304@g.rit.edu
 */

public class good extends mind implements player{
    /**
     * good initializes member fields of an instance.
     * @param    board      the playing board
     */
	public good(board board){
		super(board);
	}
	/**
	    * getMove get the move of the player.
	    *
	    * @param type	"X" or "O" type of player.
	    * @param max	maximal number of columns allowed for a move.
	    * @return the column of the move to be made.
	    */
	@Override
	public int getMove(String type, int max) {
		/** Type of opposing player */
		String newType = "";
		if (type.equals("X")) newType = "O";
		if (type.equals("O")) newType = "X";
		/** initial outputs for the move */
		int output = 0;
		int win = -1;
		int block = -1;
		//test every column for blocking or winning
		for (int i=0;i<max;i++){
			if(! board.full(i)) {
				output =  i;
				// winning
				String result = board.test(output, type);
				if (result.charAt(0) == 'h' || result.charAt(0) == 'v' || result.charAt(0) == 'd') win = output;
				// blocking
				result = board.test(output, newType);
				if (result.charAt(0) == 'h' || result.charAt(0) == 'v' || result.charAt(0) == 'd') block = output;
			}
		}
		// return either winning move, blocking move, or default strategy
		if (win != -1) return win;
		if (block != -1) return block;
		return output;
	}

}

/*
* $Log: good.java,v $
* Revision 1.4  2012-04-19 01:46:29  axp9304
* commenting done, text files filled out. final formatting/bug fixing. Final version
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
