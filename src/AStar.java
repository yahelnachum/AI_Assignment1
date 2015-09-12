import java.awt.Point;
import java.lang.Math;
import java.util.*;

public class AStar {
	long startTime5 = System.currentTimeMillis();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.printf(FileInputOutput.fileToBoard("sample board.txt"));

		String fileName = args[0];
		String heuristicS = args[1];
		int heuristicI = heuristicS.charAt(0) - '0';

		int[][] board = FileInputOutput.fileToBoard("sample board.txt");
		int[][] board1 = FileInputOutput.fileToBoard("sample board1.txt");
		int[][] board2 = FileInputOutput.fileToBoard("sample board2.txt");
		int[][] board3 = FileInputOutput.fileToBoard("sample board3.txt");
		int[][] board4 = FileInputOutput.fileToBoard("sample board4.txt");
		int[][] board5 = FileInputOutput.fileToBoard("sample board5.txt");

		AStarSearch searcher = new AStarSearch();

		for (int i = 1; i <= 6; i++) {
			long startTime = System.currentTimeMillis();
			searcher.search(board, i);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Running time :" + totalTime);
			System.out.println("End");
			long startTime1 = System.currentTimeMillis();
			searcher.search(board1, i);
			long endTime1 = System.currentTimeMillis();
			long totalTime1 = endTime1 - startTime1;
			System.out.println("Running time 1 :" + totalTime1);
			System.out.println("End1\n");
			long startTime2 = System.currentTimeMillis();
			searcher.search(board2, i);
			long endTime2 = System.currentTimeMillis();
			long totalTime2 = endTime2 - startTime2;
			System.out.println("Running time 2 :" + totalTime2);
			System.out.println("End2\n");
			long startTime3 = System.currentTimeMillis();
			searcher.search(board3, i);
			long endTime3 = System.currentTimeMillis();
			long totalTime3 = endTime3 - startTime3;
			System.out.println("Running time 3 :" + totalTime3);
			System.out.println("End3\n");
			long startTime4 = System.currentTimeMillis();
			searcher.search(board4, i);
			long endTime4 = System.currentTimeMillis();
			long totalTime4 = endTime4 - startTime4;
			System.out.println("Running time 4 :" + totalTime4);
			System.out.println("End4\n");
			long startTime5 = System.currentTimeMillis();
			searcher.search(board5, i);
			long endTime5 = System.currentTimeMillis();
			long totalTime5 = endTime5 - startTime5;
			System.out.println("Running time 5 :" + totalTime5);
			System.out.println("End5\n");
		}
		// Point tempPoint = new Point(0,0);
		/*
		 * AStarNode startNode = new AStarNode(null, new Robot(board, tempPoint,
		 * -1),0 ,0); AStarNode endNode = new AStarNode(null , new Robot(board,
		 * tempPoint, -1), 0, 0);
		 */

		/*
		 * Point start = new Point(0, 0); Point goal = new Point(0, 0);
		 * 
		 * for (int j = 0; j < board[0].length; j++) { for (int i = 0; i <
		 * board.length; i++) { System.out.printf("%3d", board[i][j]); if
		 * (board[i][j] == State.START) start = new Point(i, j); else if
		 * (board[i][j] == State.GOAL) goal = new Point(i, j); }
		 * System.out.printf("\n"); }
		 * 
		 * AStarNode a = new AStarNode(new Robot(board, start, 0), goal);
		 * ArrayList<AStarNode> list = new ArrayList<AStarNode>();
		 * ArrayList<AStarNode> visited = new ArrayList<AStarNode>();
		 * list.add(a);
		 * 
		 * // int z = 0; while (!list.isEmpty() && !(list.get(0).r.loc.x ==
		 * goal.x && list.get(0).r.loc.y == goal.y)) {
		 * 
		 * System.out.println("BEFORE SORT");
		 * System.out.println(list.get(0).r.getPoints());
		 * Collections.sort(list);
		 * 
		 * // z++; // if(z%100 == 0) int i = 0; boolean visit = false; boolean
		 * goAhead = true; //System.out.println(visited.size());
		 * //System.out.println(list.size()); System.out.println("AFTER SORT");
		 * System.out.println(list.get(0).r.getPoints()); while ((i <
		 * visited.size()) && !visit) { // System.out.println(visited.size());
		 * //System.out.println(list.size()); if ((list.get(0).r.loc.getX() ==
		 * visited.get(i).r.loc.getX()) && (list.get(0).r.loc.getY() ==
		 * visited.get(i).r.loc .getY()) && (list.get(0).r.dir ==
		 * visited.get(i).r.dir) && (list.get(0).r.getPoints() <=
		 * visited.get(i).r.getPoints())) { visit = true; goAhead = false;
		 * list.remove(0); System.out.println("removed"); } else { goAhead =
		 * true; // System.out.println("goahead"); } i++; } if (goAhead) {
		 * AStarNode b = list.remove(0); b.search(); list.addAll(b.children);
		 * visited.add(b); // System.out.printf("%d\n", list.size()); } }
		 * AStarNode goalRobo = new AStarNode(list.get(0)); list.remove(0);
		 * while (!list.isEmpty()) { // for(int i = 0; i<list.size(); i++){ if
		 * (list.get(0).r.getPoints() > goalRobo.r.getPoints() - 100) { int j =
		 * 0; boolean visit = false; boolean goAhead = true;
		 * //System.out.println(visited.size());
		 * //System.out.println(list.size()); while ((j < visited.size()) &&
		 * !visit) { // System.out.println(visited.size());
		 * //System.out.println(list.size()); if ((list.get(0).r.loc.getX() ==
		 * visited.get(j).r.loc .getX()) && (list.get(0).r.loc.getY() ==
		 * visited.get(j).r.loc .getY()) && (list.get(0).r.dir ==
		 * visited.get(j).r.dir) && (list.get(0).r.getPoints() <=
		 * visited.get(j).r.getPoints())) { visit = true; goAhead = false;
		 * list.remove(0); System.out.println("removed"); } else { goAhead =
		 * true; // System.out.println("goahead"); } j++; } if (goAhead) {
		 * AStarNode b = list.remove(0); b.search(); list.addAll(b.children);
		 * visited.add(b); // System.out.printf("%d\n", list.size()); } } else
		 * if (list.get(0).r.loc.x == goal.x && list.get(0).r.loc.y == goal.y){
		 * goalRobo = list.get(0); } else { AStarNode q = list.remove(0);
		 * visited.add(q); } // } } if(goalRobo.r.loc.equals(goal)){
		 * goalRobo.r.points+=100; } System.out.printf("found\n"); //
		 * System.out.printf(list.get(0).path + "\n");
		 * System.out.printf(goalRobo.path + "\n");
		 * System.out.printf(goalRobo.r.getPoints() + "");
		 * 
		 * // AStarNode.findGoalPath(a, goal);
		 */

	}
}
