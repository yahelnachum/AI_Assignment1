
import java.awt.Point;
import java.lang.Math;

public class Robot {
	
	/**
	 * point on the board the robot is on
	 */
	Point loc;
	
	/**
	 * direction the robot is facing
	 */
	Direction dir;
 
	/**
	 * an array of the terrain complexity
	 */
	int [][] board;
	
	/**
	 * points given to robot
	 */
	int points;
	
	/**
	 * Creates a robot to traverse over the terrain complexity board given.
	 * 
	 * @param init_board Describes the terrain complexity over the whole board.
	 * @param init_loc Gives the robot an initial location
	 */
	Robot(int[][] init_board, Point init_loc){
		board = init_board;
		loc = init_loc;
		dir = Direction.NORTH;
		points = 0;
	}
	
	// moves robot forward in the direction it is facing
	// points deducted is equal to the number in the square that the robot is entering
	/**
	 * moves robot forward in the direction it is facing
	 * 
	 * points deducted is equal to the number in the 
	 * square that the robot is entering
	 */
	public void forward(){
		switch(dir){
		case NORTH:
			loc.move(0, 1);
			break;
		case SOUTH:
			loc.move(0, -1);
			break;
		case EAST:
			loc.move(1, 0);
			break;
		case WEST:
			loc.move(-1, 0);
			break;
		}
		
		// deduct points
		if(offBoard())
			points -= 100;
		else
			points -= board[loc.x][loc.y];
	}
	
	/**
	 * bashes robot and then performs forward move
	 * points deducted is equal to 3 no matter the terrain complexity
	 */
	public void bash(){
		switch(dir){
		case NORTH:
			loc.move(0, 1);
			break;
		case SOUTH:
			loc.move(0, -1);
			break;
		case EAST:
			loc.move(1, 0);
			break;
		case WEST:
			loc.move(-1, 0);
			break;
		}
		
		// deduct poitns
		if(offBoard()){
			points -= 100;
			return;
		}
		else
			points -= 3;
		
		// must do a forward move after bash
		forward();
	}
	
	/**
	 * bashes robot and then performs forward move
	 * points deducted is equal to 3 no matter the terrain complexity
	 * 
	 * @param turn The direction to turn the robot in.
	 */
	public void turn(Turn turn){
		switch(turn){
		case CLOCKWISE:
			switch(dir){
			case NORTH:
				dir = Direction.EAST;
				break;
			case SOUTH:
				dir = Direction.WEST;
				break;
			case EAST:
				dir = Direction.SOUTH;
				break;
			case WEST:
				dir = Direction.NORTH;
				break;
			}
			break;
		case COUNTER_CLOCKWISE:
		switch(dir){
			case NORTH:
				dir = Direction.WEST;
				break;
			case SOUTH:
				dir = Direction.EAST;
				break;
			case EAST:
				dir = Direction.NORTH;
				break;
			case WEST:
				dir = Direction.SOUTH;
				break;
			}
			break;
		}
		
		// deduct points
		points -= (int)(Math.ceil((1.0/3.0)*(board[loc.x][loc.y])));
	}
	
	/**
	 * Returns the points the robot has
	 * @return
	 */
	public int getPoints(){
		return points;
	}
	
	/**
	 * Returns whether or not the robot is still on the board
	 * 
	 * @return
	 */
	public boolean offBoard(){
		if(loc.x < 0 || loc.y < 0 || loc.x >= board.length || loc.y >= board[0].length)
			return true;
		else
			return false;
	}
}
