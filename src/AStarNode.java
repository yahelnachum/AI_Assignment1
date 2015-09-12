import java.awt.Point;
import java.util.*;

public class AStarNode implements Comparable<AStarNode> {

	Robot r;
	Point goal;
	AStarNode parent;
	ArrayList<AStarNode> children = new ArrayList<AStarNode>();
	ArrayList<Point> visited = new ArrayList<Point>();
	String path = "                 ";
	int heuristic;

	AStarNode(AStarNode n) {
		this.r = new Robot(n.r);
		this.goal = new Point(n.goal);
		parent = n;
		children = new ArrayList<AStarNode>();
		this.path = n.path;
		this.visited = n.visited;
	}

	AStarNode(Robot r, Point goal, int heuristic) {
		this.r = r;
		this.goal = goal;
		parent = null;
		this.heuristic = heuristic;
	}

	public void search() {
		if (!r.offBoard()) {

			//System.out.printf("size %d\n", visited.size());//

			/*
			 * boolean loc_visited = false; for(int i = 0; i < visited.size();
			 * i++){ if(visited.get(i).x == r.loc.x && visited.get(i).y ==
			 * r.loc.y) loc_visited = true; } if(!loc_visited)
			 * visited.add(r.loc); else return;
			 */

			if ((path.substring(path.length() - 10).contains("bash") || path
					.substring(path.length() - 10).contains("forward"))
					&& visited.contains(r.loc))
				return;

			for (int i = 0; i < 4; i++) {
				children.add(new AStarNode(this));
			}

			// make children try every possible move robot can take
			children.get(0).r.forward();
			children.get(0).visited.add(r.loc);
			children.get(0).path += "forward ";

			children.get(1).r.bash();
			children.get(1).path += "bash forward ";
			children.get(1).visited.add(r.loc);

			children.get(2).r.turn(Turn.CLOCKWISE);
			children.get(2).path += "Clockwise ";

			children.get(3).r.turn(Turn.COUNTER_CLOCKWISE);
			children.get(3).path += "Counter_Clockwise ";

		}
	}

	public int compareTo(AStarNode node) {
		Heuristics h = new Heuristics();
		switch (this.heuristic) {
		case 1:
			if ((this.r.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) > 
					(node.r	.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return -1;
			} else if ((this.r.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) < 
					(node.r	.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return 1;
			} else {
				return 0;
			}
		case 2:
			if ((this.r.getPoints() - h.heuristic2(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) > 
					(node.r	.getPoints() - h.heuristic2(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return -1;
			} else if ((this.r.getPoints() - h.heuristic2(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) < 
					(node.r	.getPoints() - h.heuristic2(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return 1;
			} else {
				return 0;
			}
		case 3:
			if ((this.r.getPoints() - h.heuristic3(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) > 
					(node.r	.getPoints() - h.heuristic3(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return -1;
			} else if ((this.r.getPoints() - h.heuristic4(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) < 
					(node.r	.getPoints() - h.heuristic4(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return 1;
			} else {
				return 0;
			}
		case 4:
			if ((this.r.getPoints() - h.heuristic5(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) > 
					(node.r	.getPoints() - h.heuristic5(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return -1;
			} else if ((this.r.getPoints() - h.heuristic6(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) < 
					(node.r	.getPoints() - h.heuristic6(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return 1;
			} else {
				return 0;
			}
		case 5:
			if ((this.r.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) > 
					(node.r	.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return -1;
			} else if ((this.r.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) < 
					(node.r	.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return 1;
			} else {
				return 0;
			}
		case 6:
			if ((this.r.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) > 
					(node.r	.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return -1;
			} else if ((this.r.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y)) < 
					(node.r	.getPoints() - h.heuristic1(this.r.getPoint().x,
					this.r.getPoint().y, this.goal.x, this.goal.y))) {
				return 1;
			} else {
				return 0;
			}
		default:
			if (this.r.getPoints() > node.r.getPoints()) {
				return -1;
			} else if (this.r.getPoints() < node.r.getPoints()) {
				return 1;
			} else {
				return 0;
			}
		}
		/*
		 * if(this.r.getPoints() > node.r.getPoints()){ return -1; } else
		 * if(this.r.getPoints() < node.r.getPoints()){ return 1; } else{ return
		 * 0; }
		 */
	}
}
