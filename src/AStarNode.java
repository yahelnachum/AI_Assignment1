import java.util.*;

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

  AStarNode(AStarNode path, Robot robot, int cost, int estimatedCost){
	  this.pathParent = path;
	  this.currentRobot = robot;
	  this.costFromStart = cost;
	  this.estimatedCostToGoal = estimatedCost;
  }
  
  
  AStarNode AStarNodeClone (AStarNode clonePath, Robot cloneRobot, int cloneCost, int cloneEstimatedCost){
	  AStarNode clone = new AStarNode(clonePath, cloneRobot.cloneRobot(cloneRobot.board,  cloneRobot.loc,  cloneRobot.points), cloneCost, cloneEstimatedCost);
	  return clone;
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
	  
	  return 0;
  }


  /**
    Gets the estimated cost between this node and the
    specified node. The estimated cost should never exceed
    the true cost. The better the estimate, the more
    effecient the search.
  */
  public int getEstimatedCost(AStarNode node){
	  
	  return node.currentRobot.points;
  }


  /**
    Gets the children (AKA "neighbors" or "adjacent nodes")
    of this node.
  */
  public  List<AStarNode> getNeighbors(){
	List<AStarNode> neighbors = new ArrayList<AStarNode>();
	
	
	AStarNode nextNeighbor = AStarNodeClone(this.pathParent,this.currentRobot, this.costFromStart, this.estimatedCostToGoal);
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.forward();
    System.out.println("Forward" + nextNeighbor.currentRobot.loc);
	neighbors.add(nextNeighbor);

	nextNeighbor = AStarNodeClone(this.pathParent,this.currentRobot, this.costFromStart, this.estimatedCostToGoal);
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.bash();
    System.out.println("Bash" + nextNeighbor.currentRobot.loc);
	neighbors.add(nextNeighbor);
	
	nextNeighbor = AStarNodeClone(this.pathParent,this.currentRobot, this.costFromStart, this.estimatedCostToGoal);
	Turn nextTurn = Turn.CLOCKWISE;
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.turn(nextTurn);
    System.out.println("CLOCKWISE" + nextNeighbor.currentRobot.loc);
	neighbors.add(nextNeighbor);
	
	nextNeighbor = AStarNodeClone(this.pathParent,this.currentRobot, this.costFromStart, this.estimatedCostToGoal);	nextTurn = Turn.COUNTER_CLOCKWISE;
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.turn(nextTurn);
    System.out.println("CW" + nextNeighbor.currentRobot.loc);
	neighbors.add(nextNeighbor);

	return neighbors;
  }
}  