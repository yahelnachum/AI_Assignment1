import java.awt.Point;
import java.lang.Math;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.printf(FileInputOutput.fileToBoard("sample board.txt"));
		int[][] board = FileInputOutput.fileToBoard("sample board1.txt");
		// Point tempPoint = new Point(0,0);
		/*
		 * AStarNode startNode = new AStarNode(null, new Robot(board, tempPoint,
		 * -1),0 ,0); AStarNode endNode = new AStarNode(null , new Robot(board,
		 * tempPoint, -1), 0, 0);
		 */

		Point start = new Point(0, 0);
		Point goal = new Point(0, 0);

		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				System.out.printf("%3d", board[i][j]);
				if (board[i][j] == State.START)
					start = new Point(i, j);
				else if (board[i][j] == State.GOAL)
					goal = new Point(i, j);
			}
			System.out.printf("\n");
		}

		AStarNode a = new AStarNode(new Robot(board, start, 0), goal);
		ArrayList<AStarNode> list = new ArrayList<AStarNode>();
		list.add(a);

		while (!(list.get(0).r.loc.x == goal.x && list.get(0).r.loc.y == goal.y)) {
			/*if (list.size() > 1) {
				Collections.sort(list);
			}*/
			AStarNode b = list.remove(0);
			b.search();
			list.addAll(b.children);
		}
		System.out.printf("found\n");
		System.out.printf(list.get(0).path + "\n");
		System.out.printf(list.get(0).r.getPoints() + "");

		// AStarNode.findGoalPath(a, goal);

	}

}
