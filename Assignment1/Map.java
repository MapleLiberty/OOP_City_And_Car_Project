
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Dongwon Lee
Student Number: 215805260
Course Section: B
*/

package Assignment1;


/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
		this.row = row;
		this.column = column;
		map = new boolean[row][column];	// make the map with given row and column
	}
	
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow >= 0 && startRow < this.row && startCol >= 0 && startCol < this.column && destRow >= 0 && destRow < this.row && destCol >= 0 && destCol < this.column) {	// if row or column argument is not negative and not out of map range
			if(startRow >= destRow && startCol >= destCol) {	// if the destination is at the south west of the start point
				return goSouthWest(startRow, startCol, destRow, destCol, path);	
			}
			else if(startRow >= destRow && startCol <= destCol) {	// if the destination is at the south east of the start point
				return goSouthEast(startRow, startCol, destRow, destCol, path);
			}
			else if(startRow <= destRow && startCol <= destCol) {	// if the destination is at the north east of the start point
				return goNorthEast(startRow, startCol, destRow, destCol, path);
			}
			else {	// if the destination is at the north west of the start point
				return goNorthWest(startRow, startCol, destRow, destCol, path);
			}
		}
		else {
			throw new IllegalArgumentException();	// throw an exception if row or column argument is negative or out of map range
		}	 
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow >= destRow && startCol >= destCol) {	// if the destination is at the south west of the start point
			if(startRow == destRow && startCol == destCol) {	// if arrived at destination
				return path;
			}
			else if(startRow != destRow){	// move row first
				startRow--;	// go south
				return goSouthWest(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
			else {	// move column after row
				startCol--;	// go west
				return goSouthWest(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
		}
		else {
			throw new IllegalArgumentException();	// throw an exception if row or column argument is not in the proper range
		}
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow >= destRow && startCol <= destCol) {	// if the destination is at the south east of the start point
			if(startRow == destRow && startCol == destCol) {	// if arrived at destination
				return path;
			}
			else if(startRow != destRow){	// move row first
				startRow--; // go south
				return goSouthEast(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
			else {	// move column after row
				startCol++; // go east
				return goSouthEast(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
		}
		else {
			throw new IllegalArgumentException();	// throw an exception if row or column argument is not in the proper range
		}
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow <= destRow && startCol <= destCol) {	// if the destination is at the north east of the start point
			if(startRow == destRow && startCol == destCol) {	// if arrived at destination
				return path;
			}
			else if(startRow != destRow){	// move row first
				startRow++; // go north
				return goNorthEast(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
			else {	// move column after row
				startCol++; // go east
				return goNorthEast(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
		}
		else {
			throw new IllegalArgumentException();	// throw an exception if row or column argument is not in the proper range
		}
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow <= destRow && startCol >= destCol) {	// if the destination is at the north west of the start point
			if(startRow == destRow && startCol == destCol) {	// if arrived at destination
				return path;
			}
			else if(startRow != destRow){	// move row first
				startRow++;	// go north
				return goNorthWest(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
			else {	// move column after row
				startCol--; // go west
				return goNorthWest(startRow,startCol,destRow,destCol,path + "(" + startRow + "," + startCol + ") ");	// recursive call with next location and path that has the new location
			}
		}
		else {
			throw new IllegalArgumentException();	// throw an exception if row or column argument is not in the proper range
		}
	}
	
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */
	
	public String findPath (int startRow, int startCol) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		return makePath(startRow, startCol, "");	// call private helper method makePath
	}
	
	// private helper for findPath
	private String makePath(int startRow, int startCol, String path) {
		for(int i = 0; i < this.row; i++)	// loop all elements of map
			for(int j = 0; j < this.column; j++)
				map[i][j] = false;	// clear map, set all elements of map to false
		path = move(startRow, startCol, path + "(" + startRow + "," + startCol + ") ");	// call private helper method move
		if(!path.equals("")) {	// if finding the path was successful
			return path;	// return successful path
		}
		else {	// if finding the path was unsuccessful
			return makePath(startRow, startCol, "");	// start finding the path again, recursive call
		}
	}
	
	// private helper for makePath
	private String move(int startRow, int startCol, String path) {
		map[startRow][startCol] = true;	// mark current location
		if(startRow == 0 || startRow == this.row - 1 || startCol == 0 || startCol == this.column - 1) {	// if the car went to the boundary of the map successfully
			return path;	// return successful path String
		}
		else {  
			double random = Math.random();	// make a random number
			if(random >= 0.75) {
				startRow++;	// go north
				if(map[startRow][startCol] == true) {	// if the new location was marked, cannot move more
					return "";	// return an empty string to start over again
				}
				else {	// moving to next location is successful
					return move(startRow, startCol, path + "(" + startRow + "," + startCol + ") ");	// recursive call to move to next location
				}
			}
			else if(random >= 0.5) {
				startRow--;	// go south
				if(map[startRow][startCol] == true) {	// if the new location was marked, cannot move more
					return "";	// return an empty string to start over again
				}
				else {	// moving to next location is successful
					return move(startRow, startCol, path + "(" + startRow + "," + startCol + ") ");	// recursive call to move to next location
				}
			}
			else if(random >= 0.25) {	
				startCol++;	// go east
				if(map[startRow][startCol] == true) {	// if the new location was marked, cannot move more
					return "";	// return an empty string to start over again
				}
				else {	// moving to next location is successful
					return move(startRow, startCol, path + "(" + startRow + "," + startCol + ") ");	// recursive call to move to next location
				}
			}
			else {
				startCol--;	// go west
				if(map[startRow][startCol] == true) {	// if the new location was marked, cannot move more
					return "";	// return an empty string to start over again
				}
				else {	// moving to next location is successful
					return move(startRow, startCol, path + "(" + startRow + "," + startCol + ") ");	// recursive call to move to next location
				}
			}
		}
		
	}
	
		
} // end of class
