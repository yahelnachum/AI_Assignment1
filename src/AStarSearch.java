import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;


public class AStarSearch {
	public void search(int[][] board){
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
		ArrayList<AStarNode> visited = new ArrayList<AStarNode>();
		list.add(a);

		// int z = 0;
		while (!list.isEmpty()
				&& !(list.get(0).r.loc.x == goal.x && list.get(0).r.loc.y == goal.y)) {

			System.out.println("BEFORE SORT");
			System.out.println(list.get(0).r.getPoints());
			Collections.sort(list);

			// z++;
			// if(z%100 == 0)
			int i = 0;
			boolean visit = false;
			boolean goAhead = true;
			//System.out.println(visited.size());
			//System.out.println(list.size());
			System.out.println("AFTER SORT");
			System.out.println(list.get(0).r.getPoints());
			while ((i < visited.size()) && !visit) {
				// System.out.println(visited.size());
				//System.out.println(list.size());
				if ((list.get(0).r.loc.getX() == visited.get(i).r.loc.getX())
						&& (list.get(0).r.loc.getY() == visited.get(i).r.loc
								.getY())
						&& (list.get(0).r.dir == visited.get(i).r.dir)
						&& (list.get(0).r.getPoints() <= visited.get(i).r.getPoints())) {
					visit = true;
					goAhead = false;
					list.remove(0);
					System.out.println("removed");
				} else {
					goAhead = true;
					// System.out.println("goahead");
				}
				i++;
			}
			if (goAhead) {
				AStarNode b = list.remove(0);
				b.search();
				list.addAll(b.children);
				visited.add(b);
				// System.out.printf("%d\n", list.size());
			}
		}
		AStarNode goalRobo = new AStarNode(list.get(0));
		list.remove(0);
		while (!list.isEmpty()) {
			// for(int i = 0; i<list.size(); i++){
			if (list.get(0).r.getPoints() > goalRobo.r.getPoints() - 100) {
				int j = 0;
				boolean visit = false;
				boolean goAhead = true;
				//System.out.println(visited.size());
				//System.out.println(list.size());
				while ((j < visited.size()) && !visit) {
					// System.out.println(visited.size());
					//System.out.println(list.size());
					if ((list.get(0).r.loc.getX() == visited.get(j).r.loc
							.getX())
							&& (list.get(0).r.loc.getY() == visited.get(j).r.loc
									.getY())
							&& (list.get(0).r.dir == visited.get(j).r.dir)
							&& (list.get(0).r.getPoints() <= visited.get(j).r.getPoints())) {
						visit = true;
						goAhead = false;
						list.remove(0);
						System.out.println("removed");
					} else {
						goAhead = true;
						// System.out.println("goahead");
					}
					j++;
				}
				if (goAhead) {
					AStarNode b = list.remove(0);
					b.search();
					list.addAll(b.children);
					visited.add(b);
					// System.out.printf("%d\n", list.size());
				}
			}
			else if (list.get(0).r.loc.x == goal.x && list.get(0).r.loc.y == goal.y){
				goalRobo = list.get(0);
			}
			else {
				AStarNode q = list.remove(0);
				visited.add(q);
			}
			// }
		}
		if(goalRobo.r.loc.equals(goal)){
			goalRobo.r.points+=100;
		}
		System.out.printf("found\n");
		// System.out.printf(list.get(0).path + "\n");
		System.out.printf(goalRobo.path + "\n");
		System.out.printf(goalRobo.r.getPoints() + "" + "\n");
		System.out.printf("_____________________" + "\n");

		// AStarNode.findGoalPath(a, goal);

	}
}
