
public class Heuristics {
	
	/**
	 * Always returns 0 no matter where the 
	 * robot is and where the goal state is
	 * @param currentlocX Current x location of robot
	 * @param currentlocY Current y location of robot
	 * @param goallocX X location of goal
	 * @param goallocY Y location of goal
	 * @return Returns 0 for any locations given
	 */
	public int heuristic1(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		return 0;
	}
	
	
	/**
	 * Returns the smallest distance, either vertical or horizontal
	 * @param currentlocX Current x location of robot
	 * @param currentlocY Current y location of robot
	 * @param goallocX X location of goal
	 * @param goallocY Y location of goal
	 * @return Returns vertical or horizontal distance, whichever is smaller
	 */
	public int heuristic2(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int result = Math.min(vertical, horizontal);
		return result;
	}
	
	/**
	 * Returns the largest distance, either vertical or horizontal
	 * @param currentlocX Current x location of robot
	 * @param currentlocY Current y location of robot
	 * @param goallocX X location of goal
	 * @param goallocY Y location of goal
	 * @return Returns vertical or horizontal distance, whichever is larger
	 */
	public int heuristic3(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int result = Math.max(vertical, horizontal);
		return result;
	}
	
	/**
	 * Returns the sum of the vertical and horizontal distance
	 * @param currentlocX Current x location of robot
	 * @param currentlocY Current y location of robot
	 * @param goallocX X location of goal
	 * @param goallocY Y location of goal
	 * @return Returns sum of the vertical and horizontal distance
	 */
	public int heuristic4(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int result = vertical + horizontal;
		return result;
	}
	
	/**
	 * Uses an admissable heuristic to calculate cost of reaching goal
	 * @param currentlocX Current x location of robot
	 * @param currentlocY Current y location of robot
	 * @param goallocX X location of goal
	 * @param goallocY Y location of goal
	 * @return Returns the sum of the distances minus the minimum of the two distances
	 */	
	public int heuristic5(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		// might we want to change this to pythagorean theorom heuristic???
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int d = 1-2;
		int result = (vertical + horizontal) + d*Math.min(vertical, horizontal);
		return result;
	}

	/**
	 * Uses an non-admissable heuristic by taking hueristic5 and multiplying by 3
	 * @param currentlocX Current x location of robot
	 * @param currentlocY Current y location of robot
	 * @param goallocX X location of goal
	 * @param goallocY Y location of goal
	 * @return Returns the sum of the distances minus the minimum of the two distances, all times 3
	 */	
	public int heuristic6(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int d = 1-2;
		int result = (vertical + horizontal) + d*Math.min(vertical, horizontal);
		return 3*result;
	}
	
}
