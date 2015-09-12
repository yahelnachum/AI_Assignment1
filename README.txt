Author:						Gregory Port, Cuong Nguyen, Duc Pham, Yahel Nachum
Date:						9/10/2015
Version:					1.0
Project ID:					Assignment #1
CS Class:					CS 4341
Programming Language:		Java
OS/Hardware dependencies:	The program requires enough memory to store the nodes in the tree 
							used to find the path to the goal. Depending on the location of java 
							executables you might need to find where they are to compile the 
							program and run it.

Problem Description: To create a program that can find a path, using different heuristic 
						functions, for a robot to traverse a board, from the start location 
						to the end location, through terrain with varying complexity (1-9).

Overall Design:			main design decisions about the program
	System structure	The system works by having a Robot class that acts on the board 
						given its actions. Its actions move/turn it on the board. 
						The AStarNode allows the system to develop multiple paths 
						that start from a root location/node and expand with its 
						potential actions into the next levels. AStarSearch does 
						the expansion of these nodes and sorts the expansion of 
						the children node based on the heuristic cost. Lower costs 
						are more favorable so those are expanded first and higher 
						costs are expanded later on if they become lower costs than 
						the previous lower costs.

	Data representation The representation in terms of the Robot and Board are simple 
						since it is easy to think of them as seperate objects. Especially 
						the robot class is very intuative that you can have this entity 
						in which it knows the board complexity and can use its 
						actions/functions to traverse the board in many different ways. 
						The representation of the search is classical since nodes with 
						children are used very commonly to depict a tree of options.	

	Algorithms 			The A* algorithm is used to decide what nodes to expand next. 
						The ones with the lower current cost + heuristic cost are expanded 
						first while the ones that have a higher overall cost will be 
						pushed to the front of the expansion list as the lower cost 
						nodes are expanded and their costs increase.

Program Assumptions 
      and Restrictions:		The board must be of a rectangular shape with numbers 1-9 
						      deliminated by tabs. The heuristic number must be a number 1-6 
						      because those are the only heuristics created.

Interfaces:			how the program interacts with users, data or programs
	User	The program takes input from the user as command line arguments 
			for the board to use and the heuristic to use as a cost 
			function. Then once it is done searching it will output 
			the score of the path found, the number of actions it took, 
			and the number of nodes expanded to find the path.
			
	File/D-B The file interacts with the program by being read in line 
				by line and transformed into a 2d integer array to be 
				used as a definition of the terrain complexity for the 
				robot.
				
	Program/Module ***** still need to add ******

Implementation Details:
	Data			The board is represented as a 2d integer array. The 
					robot at a certain part of the path is represented by an 
					AStarNode that includes the robots information at that 
					time in the path, and the sequence of actions taken to 
					get to that point.
					
	Variables		***** still need to add ******key variables and their scopes
	 
	Algorithm		***** still need to add ******implementation details of algorithm(s) used

How to build the program:	To build the program you must take the following steps on the command line: 
							"(path to javac.exe)\javac.exe" -g AStar.java
							java AStar "board name.txt" (heuristic integer)
							
							Ex.
							"C:\Program Files\Java\jdk####\bin\javac.exe" -g AStar.java
							java AStar "sample board1.txt" 3

Program Source:			
						AStarNode.java
						Direction.java
						FileInputOutput.java
						Heuristic.java
						AStar.java
						AStarSearch.java
						Robot.java
						State.java
						Turn.java

Additional Files:		
						sample board.txt
						sample board1.txt
						sample board2.txt
						sample board3.txt
						sample board4.txt
						sample board5.txt

Results:			***** still need to add ******listing of sample run(s) of the program

Test Procedures:		The program was tested by giving it a board and a heuristic to use. 
						The program searched for the best path based on the heuristic and the tester 
						looked at the path and determined, based on the algorithm, if the correct 
						path was chosen.
Test Data:			***** still need to add ******test cases

Performance Evaluation:		how well the program performs
	Time/Space			The program takes very little time to decide a chosen path to take. 
						The program will usually respond with an answer within 5 seconds. The search 
						used is basically a breadth first search where objects with a low cost based 
						on the heuristic are pushed to the front of the list while objects with a 
						high cost are pushed to the back of the list.
						
	User Interface		The program interfaces through the command line. The User gives it input 
						of a board file name and a heuristic to use and the program responds with 
						the path found using the heuristic given.

References:			Class book, class slides, stackoverflow partially for some of the FileInputOutput 
					code (website url given in FileInputOutput class)
