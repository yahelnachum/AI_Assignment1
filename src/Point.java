
public class Point {
	int x;
	int y;
	int cost;
	
	public Point(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
}
