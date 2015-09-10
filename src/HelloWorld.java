import java.awt.Point;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("Hello World");
		
		FileInputOutput fIO = new FileInputOutput();
		Heuristics heuristic = new Heuristics();
		int board1[][] = fIO.fileToBoard("sample board.txt"); //Acquires board from .txt document
		Point start1 = new Point(0,0); //starting point for robot
		for (int i = 0; i < board1.length; i++){
			for (int j = 0; j < board1[0].length; j++){
				if (board1[i][j] == State.START){
					start1 = new Point(i,j);
				}
			}
		}
		Point end1 = new Point(0,0); //starting point for robot
		for (int i = 0; i < board1.length; i++){
			for (int j = 0; j < board1[0].length; j++){
				if (board1[i][j] == State.GOAL){
					end1 = new Point(i,j);
				}
			}
		}
		Robot rob1 = new Robot(board1, start1); //creates a new robot to traverse the board
		
		//move robot until it gets to end point
		while(rob1.getPoint() != end1){
			rob1.traverse(heuristic.heuristic1(rob1.getPoint().getX(), //May need to make own Point class since Heuristics uses ints and Point uses doubles
					rob1.getPoint().getY(), 
					end1.getX(),
					end1.getY()));
		}
	}
}
