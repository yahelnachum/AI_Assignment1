import java.util.*;

/**
  The AStarNode class, along with the AStarSearch class,
  implements a generic A* search algorithm. The AStarNode
  class should be subclassed to provide searching capability.
*/
public class AStarNode implements Comparable {
	
  AStarNode pathParent;
  Robot currentRobot;
  float costFromStart;
  float estimatedCostToGoal;

  AStarNode(AStarNode path, Robot robot, float cost, float estimatedCost){
	  pathParent = path;
	  currentRobot = robot;
	  costFromStart = cost;
	  estimatedCostToGoal = estimatedCost;
  }
  
  public float getCost() {
    return costFromStart + estimatedCostToGoal;
  }


  public int compareTo(Object other) {
    float thisValue = this.getCost();
    float otherValue = ((AStarNode)other).getCost();

    float v = thisValue - otherValue;
    return (v>0)?1:(v<0)?-1:0; // sign function
  }


  /**
    Gets the cost between this node and the specified
    adjacent (AKA "neighbor" or "child") node.
  */
  public float getCost(AStarNode node){
	  
	  return 0;
  }


  /**
    Gets the estimated cost between this node and the
    specified node. The estimated cost should never exceed
    the true cost. The better the estimate, the more
    effecient the search.
  */
  public float getEstimatedCost(AStarNode node){
	  
	  return node.currentRobot.points;
  }


  /**
    Gets the children (AKA "neighbors" or "adjacent nodes")
    of this node.
  */
  public  List<AStarNode> getNeighbors(){
	List<AStarNode> neighbors = new ArrayList<AStarNode>();
	
	AStarNode nextNeighbor = this;
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.forward();
	neighbors.add(nextNeighbor);
	
	nextNeighbor = this;
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.bash();
	neighbors.add(nextNeighbor);
	
	nextNeighbor = this;
	Turn nextTurn = Turn.CLOCKWISE;
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.turn(nextTurn);
	
	nextNeighbor = this;
	nextTurn = Turn.COUNTER_CLOCKWISE;
	nextNeighbor.currentRobot = nextNeighbor.currentRobot.turn(nextTurn);

	neighbors.add(nextNeighbor);

	return neighbors;
  }
}  