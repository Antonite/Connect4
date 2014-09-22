/*
 * board.java
 * 
 * $Id: board.java,v 1.5 2012-04-19 01:46:29 axp9304 Exp $
 */

/**
 * board is the class processing all the data about the playing board.
 *
 * @author Anton Pashyk axp9304@g.rit.edu
 */

import java.util.ArrayList;

public class board {
	/** initial board variable */
	ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
	/** initial rows */
	int rows;
	/** initial columns */
	int col;
    /**
     * board initializes member fields of an instance.
     * @param    row      number or rows
     * @param    colm     number or columns
     */
	public board(int row, int colm){
		rows = row;
		col = colm;
		for(int j=0; j<col; j++){
			//create the specified 2D array
			ArrayList<String> rowlist = new ArrayList<String>();
			for(int i=0; i<rows; i++){
				rowlist.add(" ");
			}
			board.add(rowlist);
		}
	}
	/**
	    * move makes a move on the board.
	    *
	    * @param column	Column in which to make a move.
	    * @param move	"X" or "O" depending on player.
	    */
	public void move(int column, String move){
		int i = rows-1;
		while(board.get(column).get(i) != " "){
			i--;
		}
		board.get(column).set(i,move);
	}
	/**
	    * test returns the outcome of a potential move.
	    *
	    * @param column	Column in which to make a move.
	    * @param move	"X" or "O" depending on player.
	    * @return the outcome of a potential move.
	    */
	public String test(int column, String move){
		move(column, move);
		String output = endgame();
		remove(column);
		return output;
	}
	/**
	    * remove removes an element from the board.
	    *
	    * @param column	Column in which to remove a piece.
	    */
	public void remove(int column){
		int i = rows-1;
		while(board.get(column).get(i) != " "){
			i--;
			if (i<0) break;
		}
		i++;
		board.get(column).set(i," ");
	}
	/**
	    * full figures out whether a column is full
	    *
	    * @param column	Column to test
	    * @return boolean of whether the column is full
	    */
	public boolean full(int column){
		boolean output = board.get(column).get(0) != " ";
		return output;
	}
	/**
	    * Prints the board as a sequence of strings.
	    */
	public void printBoard(){
		//prints the board iself
		for(int i=0;i<rows;i++){
			System.out.println();
			for(int j=0;j<col;j++){
				System.out.print("|");
				System.out.print(board.get(j).get(i));
			}
			System.out.print("|");
		}
		//prints the floor of the board
		int counter = 0;
		System.out.println();
		while(counter<(col*2 + 1)){
			if(counter % 2 == 0) System.out.print("+");
			else System.out.print("-");
			counter++;
		}
		System.out.println();
		System.out.println();
	}
	/**
	    * full figures out whether the entire board is full
	    *
	    * @return boolean of whether the board is full
	    */
	public boolean boardFull(){
		boolean output = true;
		for(int i=0;i<col;i++){
			for(int j=0;j<rows;j++){
				output = output && board.get(i).get(j) != " ";
			}
		}
		return output;
	}
	/**
	    * vertical figures out whether there are 4 in a row vertically.
	    *
	    * @return a string of player type and column of the win.
	    */
	private String vertical(){
		String output = "";
		//check all possible combinations that are larger than 4.
		for (int i=0;i<col;i++){
			int counter = 0;
			String instance = "X";
			for (int j=0;j<rows;j++){
				if (board.get(i).get(j) == instance) counter += 1;
				else{
					counter = 1;
					instance = board.get(i).get(j);
				}
				//check for a win
				if (counter == 4 && instance != " ") return instance + Integer.toString(i);
			}
			//check for a win
			if (counter >= 4 && instance != " "){
				output += instance;
				output += Integer.toString(i);
				return output;
			}
		}
		return "None";
	}
	/**
	    * horizontal figures out whether there are 4 in a row horizontally.
	    *
	    * @return a string of player type and row of the win.
	    */
	private String horizontal(){
		String output = "";
		//check all possible combinations that are larger than 4.
		for (int i=0;i<rows;i++){
			int counter = 0;
			String instance = "X";
			for (int j=0;j<col;j++){
				if (board.get(j).get(i) == instance) counter += 1;
				else{
					counter = 1;
					instance = board.get(j).get(i);
				}
				//check for a win
				if (counter == 4 && instance != " ") return instance + Integer.toString(i);
			}
			//check for a win
			if (counter >= 4 && instance != " "){
				output += instance;
				output += Integer.toString(i);
				return output;
			}
		}
		return "None";
	}
	/**
	    * diagonal figures out whether there are 4 in a row diagonally.
	    *
	    * @return a string of player type of the win.
	    */
	private String diagonal(){
		if (rows <= 3 || col <= 3) return "None";
		String output = "";
		//check all possible combinations that are larger than 4 in one direction.
		for (int i=3;i<=rows-1;i++){
			for (int j=0;j<col;j++){
				int counter = 0;
				String instance = "X";
				int r = i;
				int c = j;
				while(r>=0 && c<col){
					if (board.get(c).get(r) == instance) counter += 1;
					else{
						counter = 1;
						instance = board.get(c).get(r);
					}
					r -= 1;
					c += 1;
					//check for a win
					if (counter == 4 && instance != " ") return instance + Integer.toString(i);
				}
				//check for a win
				if (counter >= 4 && instance != " "){
					output += instance;
					output += Integer.toString(i);
					return output;
				}
			}
		}
		//check all possible combinations that are larger than 4 in the other direction.
		for (int i=rows-4;i>=0;i--){
			for (int j=0;j<col;j++){
				int counter = 0;
				String instance = "X";
				int r = i;
				int c = j;
				while(r<rows && c<col){
					if (board.get(c).get(r) == instance) counter += 1;
					else{
						counter = 1;
						instance = board.get(c).get(r);
					}
					r += 1;
					c += 1;
					//check for a win
					if (counter == 4 && instance != " ") return instance + Integer.toString(i);
				}
				//check for a win
				if (counter >= 4 && instance != " "){
					output += instance;
					output += Integer.toString(i);
					return output;
				}
			}
		}
		
		return "None";
	}
	/**
	    * endgame combines the 3 tests to determine any possible win on the board.
	    *
	    * @return a string of player type of the win.
	    */
	public String endgame(){
		boolean output = boardFull();
		String horizontal = horizontal();
		String vertical = vertical();
		String diagonal = diagonal();
		//is it a tie?
		if (horizontal == "None" && vertical == "None" && diagonal == "None"){
			if(output) return "Its a tie, no one wins";
			else return "No";
		}
		else {
			//determine the type of win
			if (horizontal != "None") return "h" + horizontal;
			if (vertical != "None") return "v" + vertical;
			if (diagonal != "None") return "d" + diagonal;
		}
		//all else fails? recognition for a bizarre failure 
		return "wtf";
	}
	
}

/*
* $Log: board.java,v $
* Revision 1.5  2012-04-19 01:46:29  axp9304
* commenting done, text files filled out. final formatting/bug fixing. Final version
*
* Revision 1.4  2012-04-19 00:16:06  axp9304
* win pattern recognition update
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