
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
	
	Robot(Robot r){
		this.loc = new Point(r.loc);
		this.dir = r.dir;
		this.board = r.board;
		this.points = r.points;
	}
	
	/**
	 * Creates a robot to traverse over the terrain complexity board given.
	 * 
	 * @param init_board Describes the terrain complexity over the whole board.
	 * @param init_loc Gives the robot an initial location
	 */
	Robot(int[][] init_board, Point init_loc, int init_points){
		
		board = init_board;
		loc = init_loc;
		dir = Direction.NORTH;
		points = init_points;
		//System.out.printf("x: %d, y: %d\n", loc.x, loc.y);
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
			nextRobot.loc.move(loc.x, loc.y-1);
			break;
		case SOUTH:
			nextRobot.loc.move(loc.x, loc.y+1);
			break;
		case EAST:
			nextRobot.loc.move(loc.x+1, loc.y);
			break;
		case WEST:
			nextRobot.loc.move(loc.x-1, loc.y);
			break;
		}
		
		//System.out.printf("forward\n");
		//System.out.printf("x: %d, y: %d\n", loc.x, loc.y);
		// deduct points
		if(offBoard()){
			nextRobot.points -= 100;
			//System.out.printf("off board\n");
		}
		else if(board[loc.x][loc.y] == -1 || board[loc.x][loc.y] == -2){
			nextRobot.points -= 1;
		}
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
			nextRobot.loc.move(loc.x, loc.y-1);
			break;
		case SOUTH:
			nextRobot.loc.move(loc.x, loc.y+1);
			break;
		case EAST:
			nextRobot.loc.move(loc.x+1, loc.y);
			break;
		case WEST:
			nextRobot.loc.move(loc.x-1, loc.y);
			break;
		}
		
		//System.out.printf("bash\n");
		//System.out.printf("x: %d, y: %d\n", loc.x, loc.y);
		// deduct points
		if(offBoard()){
			//System.out.printf("offboard\n");
			nextRobot.points -= 100;
		}
		else{
			nextRobot.points -= 3;
		}
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
		if (offBoard()){
			return null;
		}
		switch(turn){
		case CLOCKWISE:
			//System.out.printf("turn clockwise\n");
			//System.out.printf("x: %d, y: %d\n", loc.x, loc.y);
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
			//System.out.printf("turn counter clockwise\n");
			//System.out.printf("x: %d, y: %d\n", loc.x, loc.y);
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
		if(board[loc.x][loc.y] == -1 || board[loc.x][loc.y] == -2){
			nextRobot.points -= 1;
		}
		else{
			nextRobot.points -= (int)(Math.ceil((1.0/3.0)*(board[loc.x][loc.y])));
		}
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
		if(loc.x < 0 || loc.y < 0 || loc.x >= board.length || loc.y >= board[0].length)
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
	
	/*public static Robot copyRobot(Robot r){
		Robot ret = new Robot(r.board, r.getPoint(), r.getPoints());
		return ret;
	}*/
}