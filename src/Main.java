import java.awt.Point;
import java.lang.Math;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.printf(FileInputOutput.fileToBoard("sample board.txt"));
		int [][] board = FileInputOutput.fileToBoard("sample board.txt");
		Point tempPoint = new Point(0,0);
		AStarNode startNode = new AStarNode(null, new Robot(board, tempPoint, -1),0 ,0);
		AStarNode endNode = new AStarNode(null , new Robot(board, tempPoint, -1), 0, 0);
		
		for(int j = 0; j < board[0].length; j++){
			for(int i = 0; i < board.length; i++){
				if (board[i][j] == -2){
					Point startLoc = new Point(i,j);
					Robot startRobot = new Robot (board, startLoc, -1);
					startNode = new AStarNode(null, startRobot, 0, 0);
				}
				
				if (board[i][j] == -1){
					Point endLoc = new Point(i,j);
					Robot endRobot = new Robot(board, endLoc, -1);
					endNode = new AStarNode(null , endRobot, 0, 0);
				}
				
				System.out.printf("%3d", board[i][j]);
			}
			System.out.printf("\n");
		}
	  
		List<AStarNode> result = new AStarSearch().findPath(startNode, endNode);
		
	}
	
}
