
import java.awt.Point;

public class Robot {
	Point loc;
	Direction dir;
	int [][] board;
	int points;
	
	Robot(int[][] init_board, Point init_loc){
		board = init_board;
		loc = init_loc;
		dir = Direction.NORTH;
	}
	
	// moves robot forward and calculates negative points received
	public void forward(){
		switch(dir){
			case NORTH:
				break;
			case SOUTH:
				break;
			case EAST:
				break;
			case WEST:
				break;
		}
	}
	
	// bashes robot and then performs forward move and calculates negative points received
	public void bash(){
		switch(dir){
			case NORTH:
				break;
			case SOUTH:
				break;
			case EAST:
				break;
			case WEST:
				break;
		}
		
		// must do a forward move after bash
		forward();
	}
	
	// turns robot and calculates negative points received
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
