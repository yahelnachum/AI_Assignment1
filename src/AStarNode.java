import java.awt.Point;
import java.util.*;

public class AStarNode {

	Robot r;
	Point goal;
	AStarNode parent;
	ArrayList<AStarNode> children = new ArrayList<AStarNode>();
	String path = "";
	
	AStarNode(AStarNode n){
		this.r = new Robot(n.r);
		this.goal = new Point(n.goal);
		parent = n;
		children = new ArrayList<AStarNode>();
		this.path = n.path;
	}
	
	AStarNode(Robot r, Point goal){
		this.r = r;
		this.goal = goal;
		parent = null;
	}
	
	public void search(){
		if(!r.offBoard()){
			for(int i = 0; i < 4; i++){
				children.add(new AStarNode(this));
			}
			
			// make children try every possible move robot can take
			children.get(0).r.forward();
			children.get(0).path += "forward ";
			
			children.get(1).r.bash();
			children.get(1).path += "bash forward ";
			
			children.get(2).r.turn(Turn.CLOCKWISE);
			children.get(2).path += "Clockwise ";
			
			children.get(3).r.turn(Turn.COUNTER_CLOCKWISE);
			children.get(3).path += "Counter_Clockwise ";
		}
	}
}
