import java.lang.Math.*;

public class Heuristics {
	public int heuristic1(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		return 0;
	}
	public int heuristic2(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int result = Math.min(vertical, horizontal);
		return result;
	}
	public int heuristic3(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int result = Math.max(vertical, horizontal);
		return result;
	}
	public int heuristic4(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int result = vertical + horizontal;
		return result;
	}
	public int heuristic5(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int d = 1-2;
		int result = (vertical + horizontal) + d*Math.min(vertical, horizontal);
		return result;
	}
	public int heuristic6(int currentlocX, int currentlocY, int goallocX, int goallocY ){
		int vertical = Math.abs(currentlocX - goallocX);
		int horizontal = Math.abs(currentlocY - goallocY);
		int d = 1-2;
		int result = (vertical + horizontal) + d*Math.min(vertical, horizontal);
		return 3*result;
	}
	
}
