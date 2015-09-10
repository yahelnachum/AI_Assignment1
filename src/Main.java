
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.printf(FileInputOutput.fileToBoard("sample board.txt"));
		int [][] board = FileInputOutput.fileToBoard("sample board.txt");
		for(int j = 0; j < board[0].length; j++){
			for(int i = 0; i < board.length; i++){
				System.out.printf("%3d", board[i][j]);
			}
			System.out.printf("\n");
		}
		
	}

}
