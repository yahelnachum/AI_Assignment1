import java.io.*;

// skeleton of file input reader is taken from website in the next comment line
// http://stackoverflow.com/questions/4716503/best-way-to-read-a-text-file-in-java
public class FileInputOutput {
	
	/**
	 * Takes in a filename and creates a 2d 
	 * array of ints that describes the 
	 * complexity of the terrain
	 * @param fileName String of the file name to use
	 * @return Returns a 2d integer array of the board complexity
	 */
	static int[][] fileToBoard(String fileName) {
		try {
			// open up file
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				
				// used to record the length and 
				// height of the board for the 2d int array
				int x = 0;
				int y = 0;
				
				x = line.replaceAll("\t", "").length();
				// build up string line by line
				while (line != null) {
					y++;
					sb.append(line);
					line = br.readLine();
				}

				// change from string builder to string and take out tabs
				String everything = sb.toString();
				String noTabs = everything.replaceAll("\t", "");

				// close file
				br.close();
				
				// convert string to 2d int array
				int [][] board = new int[x][y];
				for(int i = 0; i < x; i++){
					for(int j = 0; j < y; j++){
						char character = noTabs.charAt(i+j*x);
						
						// check to see if the character is a special state (Start and Goal)
						if(character == 'G')
							board[i][j] = State.GOAL;
						else if(character == 'S')
							board[i][j] = State.START;
						else
							board[i][j] = character - '0';
					}
				}
				return board;
			} finally {

			}
		} catch (Exception e) {

		}
		return new int[0][0];
	}
	
}
