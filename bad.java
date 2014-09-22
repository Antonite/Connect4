/*
 * bad.java
 * 
 * $Id: bad.java,v 1.4 2012-04-19 01:46:30 axp9304 Exp $
 */

/**
 * bad is the class for a bad computer player.
 *
 * @author Anton Pashyk axp9304@g.rit.edu
 */

public class bad extends mind implements player{
    /**
     * bad initializes member fields of an instance.
     * @param    board      the playing board
     */
	public bad(board board){
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
		for (int i=0;i<max;i++){
			if(! board.full(i)) return i;
		}
		return 0;
	}

}

/*
* $Log: bad.java,v $
* Revision 1.4  2012-04-19 01:46:30  axp9304
* commenting done, text files filled out. final formatting/bug fixing. Final version
*
* Revision 1.3  2012-04-18 19:58:39  axp9304
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