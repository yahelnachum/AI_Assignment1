
import java.awt.Point;

public class Robot {
	
	// point on the board the robot is on
	Point loc;
	
	// direction the robot is facing
	Direction dir;
	
	// an array of the terrain complexity
	int [][] board;
	
	// points given to robot
	int points;
	
	Robot(int[][] init_board, Point init_loc){
		board = init_board;
		loc = init_loc;
		dir = Direction.NORTH;
		points = 0;
	}
	
	// moves robot forward in the direction it is facing
	// points deducted is equal to the number in the square that the robot is entering
	public void forward(){
		switch(dir){
		case NORTH:
			loc.move(0, 1);
			points -= board[loc.x][loc.y];
			break;
		case SOUTH:
			loc.move(0, -1);
			points -= board[loc.x][loc.y];
			break;
		case EAST:
			loc.move(1, 0);
			points -= board[loc.x][loc.y];
			break;
		case WEST:
			loc.move(-1, 0);
			points -= board[loc.x][loc.y];
			break;
		}
	}
	
	// bashes robot and then performs forward move
	// points deducted is equal to 3 no matter the terrain complexity
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
		points -= 3;
		
		// must do a forward move after bash
		forward();
	}
	
	// turns robot in turn direction given
	// points deducted is equal to terrain complexity at the location divided by 3 and rounded up
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
	}
}
