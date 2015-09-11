import java.util.*;

/**
  The AStarSearch class, along with the AStarNode class,
  implements a generic A* search algorithm. The AStarNode
  class should be subclassed to provide searching capability.
*/
public class AStarSearch {


	
  /**
    A simple priority list, also called a priority queue.
    Objects in the list are ordered by their priority,
    determined by the object's Comparable interface.
    The highest priority item is first in the list.
  */
  public static class PriorityList<AStarNode> extends LinkedList<AStarNode> {

    public void add(Comparable<AStarNode> object) {
      for (int i=0; i<size(); i++) {
        if (object.compareTo(get(i)) <= 0) {
          add(i, (AStarNode) object);
          return;
        }
      }
      addLast((AStarNode) object);
    }
  }


  /**
    Construct the path, not including the start node.
  */
  protected List<AStarNode> constructPath(AStarNode node) {
    LinkedList<AStarNode> path = new LinkedList<AStarNode>();
    while (node.pathParent != null) {
      path.addFirst(node);
      node = node.pathParent;
    }
    return path;
  }


  /**
    Find the path from the start node to the end node. A list
    of AStarNodes is returned, or null if the path is not
    found. 
  */
  public List<AStarNode> findPath(AStarNode startNode, AStarNode goalNode) {

    PriorityList<AStarNode> openList = new PriorityList<AStarNode>();
    LinkedList<AStarNode> closedList = new LinkedList<AStarNode>();

    startNode.costFromStart = 0;
    startNode.estimatedCostToGoal =
    startNode.getEstimatedCost(goalNode);
    startNode.pathParent = null;
    openList.add(startNode);
    
    System.out.println(goalNode.currentRobot.loc);
    while (!openList.isEmpty()) {
      AStarNode node = (AStarNode)openList.removeFirst();
      System.out.println(node.currentRobot.loc);
      if (node.currentRobot.loc == goalNode.currentRobot.loc || node.currentRobot.loc.y < 0) {
        // construct the path from start to goal
    	System.out.println(100);
        return constructPath(goalNode);
      }

      List<AStarNode> neighbors = node.getNeighbors();
      for (int i=0; i < neighbors.size(); i++) {
        AStarNode neighborNode = (AStarNode)neighbors.get(i);
        boolean isOpen = openList.contains(neighborNode);
        boolean isClosed =
          closedList.contains(neighborNode);
        int costFromStart = node.costFromStart +
          node.getCost(neighborNode);

        // check if the neighbor node has not been
        // traversed or if a shorter path to this
        // neighbor node is found.
        if ((!isOpen && !isClosed) ||
          costFromStart < neighborNode.costFromStart)
        {
          neighborNode.pathParent = node;
          neighborNode.costFromStart = costFromStart;
          neighborNode.estimatedCostToGoal =
            neighborNode.getEstimatedCost(goalNode);
          if (isClosed) {
            closedList.remove(neighborNode);
          }
          if (!isOpen) {
            openList.add(neighborNode);
          }
        }
      }
      closedList.add(node);
    }

    // no path found
    return null;
  }

}