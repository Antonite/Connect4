/*
 * player.java
 * 
 * $Id: player.java,v 1.3 2012-04-19 01:46:30 axp9304 Exp $
 */

/**
 * player is the interface for player types.
 *
 * @author Anton Pashyk axp9304@g.rit.edu
 */

public interface player {
	/**
    * getMove get the move of the player.
    *
    * @param type	"X" or "O" type of player.
    * @param max	maximal number of columns allowed for a move.
    * @return the column of the move to be made.
    */
	public int getMove(String type, int max);

}

/*
* $Log: player.java,v $
* Revision 1.3  2012-04-19 01:46:30  axp9304
* commenting done, text files filled out. final formatting/bug fixing. Final version
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