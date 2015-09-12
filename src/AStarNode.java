import java.util.*;
import java.lang.*;

/**
  The AStarNode class, along with the AStarSearch class,
  implements a generic A* search algorithm. The AStarNode
  class should be subclassed to provide searching capability.
*/
public class AStarNode implements Comparable<AStarNode> {
	
  AStarNode pathParent;
  Robot currentRobot;
  int costFromStart;
  int estimatedCostToGoal;
  String action;
  
  AStarNode(AStarNode newNode){
	  this.pathParent = newNode.pathParent;
	  this.currentRobot = new Robot(newNode.currentRobot);
	  this.costFromStart = newNode.costFromStart;
	  this.estimatedCostToGoal = newNode.estimatedCostToGoal;
	  this.action = newNode.action;
  }
  
	AStarNode(Robot r){
		this.currentRobot = r;
		this.pathParent = null;
		this.costFromStart = 0;
		this.estimatedCostToGoal = 0;
	}
  
  public int getCost() {
    return costFromStart + estimatedCostToGoal;
  }


  public int compareTo(AStarNode other) {
    int thisValue = this.getCost();
    int otherValue = ((AStarNode)other).getCost();

    int v = thisValue - otherValue;
    return (v>0)?1:(v<0)?-1:0; // sign function
  }


  /**
    Calculate the cost between current node and adjacent node.
  */
  public int getCost(AStarNode node){
	  Point loc = node.currentRobot.loc;
	 // System.out.println(loc.x + " " + loc.y + " " + node.currentRobot.board[loc.x][loc.y]);
	  if (node.currentRobot.offBoard(loc)) return 100;
	  if (node.action.equals("Forward")) return node.currentRobot.board[loc.x][loc.y];
	  if (node.action.equals("CW") || node.action.equals("CCW")) return (int) Math.ceil((1.0/3.0) * (node.currentRobot.board[loc.x][loc.y]));
	  if (node.action.equals("Bash Forward")) return (3 + node.currentRobot.board[loc.x][loc.y]);
	  return node.currentRobot.points - this.currentRobot.points;
  }


  /**
    Calculate the estimated cost between current node and the
    goal node.
  */
  public int getEstimatedCost(AStarNode node){
	  Heuristics h = new Heuristics();
	  return h.heuristic5(this.currentRobot.loc.x, this.currentRobot.loc.y, node.currentRobot.loc.x, node.currentRobot.loc.y);
  }

  public AStarNode movingForward(AStarNode node){
	  node.currentRobot.forward();
	  return node;
  }
  
  public AStarNode bashing(AStarNode node){
	  node.currentRobot.bash();
	  return node;
  }
  
  public AStarNode turnClockWise(AStarNode node){
	  node.currentRobot.turn(Turn.CLOCKWISE);
	  return node;
  }
  
  public AStarNode turnCounterClockWise(AStarNode node){
	  node.currentRobot.turn(Turn.COUNTER_CLOCKWISE);
	  return node;
  }
  
  /**
    Gets the children (AKA "neighbors" or "adjacent nodes")
    of this node.
  */
  public  List<AStarNode> getNeighbors(){
	List<AStarNode> neighbors = new ArrayList<AStarNode>();
	//System.out.println(this.currentRobot.points);
	for (int i = 0; i < 4; i++){
		neighbors.add(new AStarNode(this));
	}
	
	neighbors.get(0).movingForward(neighbors.get(0));
	neighbors.get(0).action = "Forward";
	//System.out.println("Forward " + neighbors.get(0).currentRobot.loc.x + " " + neighbors.get(0).currentRobot.loc.y + " " + neighbors.get(0).currentRobot.points);

	neighbors.get(1).bashing(neighbors.get(1));
	neighbors.get(1).action = "Bash Forward";
	//System.out.println("Bash " + neighbors.get(1).currentRobot.loc.x + " " + neighbors.get(1).currentRobot.loc.y);

	
	neighbors.get(2).turnClockWise(neighbors.get(2)); 
	neighbors.get(2).action = "CW";
	//System.out.println("CW " + neighbors.get(2).currentRobot.loc.x + " " + neighbors.get(2).currentRobot.loc.y);
	
	neighbors.get(3).turnCounterClockWise(neighbors.get(3)); 
	neighbors.get(3).action = "CCW";
	//System.out.println("CCW " + neighbors.get(3).currentRobot.loc.x + " " + neighbors.get(3).currentRobot.loc.y);
	
	return neighbors;
  }
  
}  