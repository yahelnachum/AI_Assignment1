import java.awt.Point;
import java.util.*;

public class AStarNode implements Comparable<AStarNode>{

	Robot r;
	Point goal;
	AStarNode parent;
	ArrayList<AStarNode> children = new ArrayList<AStarNode>();
	ArrayList<Point> visited = new ArrayList<Point>();
	String path = "                 ";
	
	AStarNode(AStarNode n){
		this.r = new Robot(n.r);
		this.goal = new Point(n.goal);
		parent = n;
		children = new ArrayList<AStarNode>();
		this.path = n.path;
		this.visited = n.visited; 
	}
	
	AStarNode(Robot r, Point goal){
		this.r = r;
		this.goal = goal;
		parent = null;
	}
	
	public void search(){
		if(!r.offBoard()){
			
			System.out.printf("size %d\n", visited.size());
			
			/*boolean loc_visited = false;
			for(int i = 0; i < visited.size(); i++){
				if(visited.get(i).x == r.loc.x && visited.get(i).y == r.loc.y)
					loc_visited = true;
			}
			if(!loc_visited)
				visited.add(r.loc);
			else
				return;*/
			
			if((path.substring(path.length()-10).contains("bash") || path.substring(path.length()-10).contains("forward")) && visited.contains(r.loc))
				return;
			
			for(int i = 0; i < 4; i++){
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
			
			if(r.loc.equals(goal)){
				r.points+=100;
			}
		}
	}

	public int compareTo(AStarNode node) {
		if(this.r.getPoints() > node.r.getPoints()){
			return -1;
		}
		else if(this.r.getPoints() < node.r.getPoints()){
			return 1;
		}
		else{
			return 0;
		}
	}
}
