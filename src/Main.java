import java.util.*;

public class Main {
	static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.printf(FileInputOutput.fileToBoard("sample board.txt"));
		int [][] board1 = FileInputOutput.fileToBoard("sample board.txt");
		int n = board1[0].length, m = board1.length;
		int [][] board = new int [n][m];
		//System.out.println(n + " " + m);
		for (int i = 0; i < n; i++){
			for (int j = 0;j < m; j++){
				board[i][j] = board1[j][i];
			}
		}
		Point tempPoint = new Point(0,0,0);
		AStarNode startNode = new AStarNode(new Robot(board, tempPoint, -1));
		AStarNode endNode = new AStarNode(new Robot(board, tempPoint, -1));
		//System.out.println(board[2][1]);
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if (board[i][j] == -2){
					Point startLoc = new Point(i,j,0);
					Robot startRobot = new Robot (board, startLoc, 0);
					startNode = new AStarNode(startRobot);
				}
				
				if (board[i][j] == -1){
					Point endLoc = new Point(i,j,0);
					//System.out.println(endLoc);
					Robot endRobot = new Robot(board, endLoc, -1);
					endNode = new AStarNode(endRobot);
				}
				
				System.out.printf("%3d", board[i][j]);
			}
			System.out.printf("\n");
		}
	  
		List<AStarNode> result = new AStarSearch().findPath(startNode, endNode);
		if (result == null) System.out.println(0);
		int count = 0;
		for (int i = 0; i < result.size(); i++){
			if (result.get(i).action.equals("Bash Forward")) count+=2;
			else count++;
		}
		System.out.println("Number of actions: " + count);
		System.out.println("Number of nodes: " + result.size());
		for (int i = 0; i < result.size(); i++){
			//System.out.println(i);
			if (result.get(i) == null) System.out.println(0);
			else
			System.out.print(result.get(i).action + " ");
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("\nTotal running time:" + totalTime);
	}
}
