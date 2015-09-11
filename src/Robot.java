
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
	Robot(int[][] init_board, Point init_loc, int init_points){
		this.board = init_board;
		this.loc = init_loc;
		this.dir = Direction.NORTH;
		this.points = init_points;
	}
	
	Robot cloneRobot(int[][] cloneBoard, Point cloneLoc, int clonePoints){
		return new Robot(cloneBoard, cloneLoc, clonePoints);
	}
	// moves robot forward in the direction it is facing
	// points deducted is equal to the number in the square that the robot is entering
	/**
	 * moves robot forward in the direction it is facing
	 * 
	 * points deducted is equal to the number in the 
	 * square that the robot is entering
	 */
	public Robot forward(){
		Robot nextRobot = this;
		switch(dir){
		case NORTH:
			nextRobot.loc.y--;
			break;
		case SOUTH:
			nextRobot.loc.y++;
			break;
		case EAST:
			nextRobot.loc.x++;
			break;
		case WEST:
			nextRobot.loc.x--;
			break;
		}
		
		// deduct points
		if(offBoard())
			nextRobot.points -= 100;
		else
			nextRobot.points -= board[loc.x][loc.y];
		return nextRobot;
	}
	
	/**
	 * bashes robot and then performs forward move
	 * points deducted is equal to 3 no matter the terrain complexity
	 */
	public Robot bash(){
		Robot nextRobot = this;
		switch(dir){
		case NORTH:
			nextRobot.loc.y--;
			break;
		case SOUTH:
			nextRobot.loc.y++;
			break;
		case EAST:
			nextRobot.loc.x++;
			break;
		case WEST:
			nextRobot.loc.x--;
			break;
		}
		
		// deduct points
		if(offBoard())
			nextRobot.points -= 100;
		else
			nextRobot.points -= 3;
		
		// must do a forward move after bash
		nextRobot.forward();
		return nextRobot;
	}
	
	/**
	 * bashes robot and then performs forward move
	 * points deducted is equal to 3 no matter the terrain complexity
	 * 
	 * @param turn The direction to turn the robot in.
	 */
	public Robot turn(Turn turn){
		Robot nextRobot = this;
		if (offBoard()) {
			nextRobot.points-=100;
			return nextRobot;
		}
		switch(turn){
		case CLOCKWISE:
			switch(dir){
			case NORTH:
				nextRobot.dir = Direction.EAST;
				break;
			case SOUTH:
				nextRobot.dir = Direction.WEST;
				break;
			case EAST:
				nextRobot.dir = Direction.SOUTH;
				break;
			case WEST:
				nextRobot.dir = Direction.NORTH;
				break;
			}
			break;
		case COUNTER_CLOCKWISE:
		switch(dir){
			case NORTH:
				nextRobot.dir = Direction.WEST;
				break;
			case SOUTH:
				nextRobot.dir = Direction.EAST;
				break;
			case EAST:
				nextRobot.dir = Direction.NORTH;
				break;
			case WEST:
				nextRobot.dir = Direction.SOUTH;
				break;
			}
			break;
		}
		
		// deduct points
		//System.out.println(nextRobot.loc);
		nextRobot.points -= (int)(Math.ceil((1.0/3.0)*(board[loc.x][loc.y])));
		return nextRobot;
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
		if(loc.x < 0 || loc.y < 0 || loc.x >= board[0].length || loc.y >= board.length)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the location of the robot
	 * @return 
	 */
	public Point getPoint(){
		return loc;
	}
}
