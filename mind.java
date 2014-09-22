/*
 * mind.java
 * 
 * $Id: mind.java,v 1.4 2012-04-19 01:46:30 axp9304 Exp $
 */

/**
 * mind is the class for all general player types.
 *
 * @author Anton Pashyk axp9304@g.rit.edu
 */

public abstract class mind implements player{
	board board;
    /**
     * mind initializes member fields of an instance.
     * @param    board      the playing board
     */
	mind(board board){
		this.board = board;
	}
	
}

/*
* $Log: mind.java,v $
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