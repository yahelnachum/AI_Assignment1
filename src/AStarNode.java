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
    Gets the cost between this node and the specified
    adjacent (AKA "neighbor" or "child") node.
  */
  public int getCost(AStarNode node){
	  
	  return node.currentRobot.points;
  }


  /**
    Gets the estimated cost between this node and the
    specified node. The estimated cost should never exceed
    the true cost. The better the estimate, the more
    effecient the search.
  */
  public int getEstimatedCost(AStarNode node){
	  
	  return 0;
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
	//System.out.println("Forward " + neighbors.get(0).currentRobot.loc + neighbors.get(0).currentRobot.points);

	neighbors.get(1).bashing(neighbors.get(1));
	neighbors.get(1).action = "Bash";
	//System.out.println("Bash " + neighbors.get(1).currentRobot.loc);

	
	neighbors.get(2).turnClockWise(neighbors.get(2)); 
	neighbors.get(2).action = "CW";
	//System.out.println("CW " + neighbors.get(2).currentRobot.loc);
	
	neighbors.get(3).turnCounterClockWise(neighbors.get(3)); 
	neighbors.get(3).action = "CCW";
	//System.out.println("CCW " + neighbors.get(3).currentRobot.loc);
	
	return neighbors;
  }
  
}  