import java.util.Scanner;

public class TicTacTo {
	static Scanner scan;
	static char[][] grid = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	static boolean playerType = true;

	public static void main(String args[]) {
		scan = new Scanner(System.in);

		String playerInput;

		draw(grid);
		boolean gameOver = false;
		while (!gameOver) {

			playerInput = scan.nextLine();
			draw(trackInput(playerInput));
			// check for draw
			if (checkDraw()) {
				System.out.println("Y'all are dumb! This game resulted in a draw.");
				break;
			}
			// check if for a winner
			else if(checkWinner('X')) {
				System.out.println("Congratulations! Player X won the game.");
				break;
			}
			else if(checkWinner('O')) {
				System.out.println("Congratulations! Player O won the game.");
				break;
			}
			

		}
	}
	
	private static boolean checkWinner(char player) {
		//check the rows
		int counter = 0;
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				if(grid[i][j] == player) {
					counter++;
				}
			}
			if(counter == 3) {
				return true;
			}
			counter = 0;
		}
		//check the columns
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				if(grid[j][i] == player) {
					counter++;
				}
			}
			if(counter == 3) {
				return true;
			}
			counter = 0;
		}
		//check the diagonal
		if(grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
			return true;
		}
		if(grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
			return true;
		}
		
		
		return false;
		
		
	}

	private static void draw(char[][] grid) {
		char topLeft = grid[0][0];
		char topRight = grid[0][2];
		char topMiddle = grid[0][1];
		char midLeft = grid[1][0];
		char midMiddle = grid[1][1];
		char midRight = grid[1][2];
		char lowLeft = grid[2][0];
		char lowMiddle = grid[2][1];
		char lowRight = grid[2][2];
		System.out.println(" 0      1     2\n" + "0 " + topLeft + "  | " + topMiddle + "  | " + topRight + "  \n"
				+ "     |    |   \n " + "---- ---- ----\n" + "1  " + midLeft + " | " + midMiddle + "  | " + midRight
				+ " \n" + "     |    |   \n" + " ---- ---- ----\n" + "2  " + lowLeft + " | " + lowMiddle + "  | "
				+ lowRight + " \n" + "     |    |   ");
		playerType = !playerType;
		if (playerType == false) {
			System.out.println("Player 1, enter a the coordinate of your play (row,column) (only two digits):");

		} else {
			System.out.println("Player 2, enter a the coordinate of your play (row,column) (only two digits):");
		}
	}

	private static char[][] trackInput(String input) {
		scan = new Scanner(System.in);

		int player1InputInt;
		int inputX;
		int inputY;
		int player2Input;

		while ((input.matches("[0-9]+")) && !(input.length() == 2)) {
			System.out.println("Your input is incorrect. Please try again!");
			input = scan.nextLine();
		}
		player1InputInt = Integer.parseInt(input);
		inputY = player1InputInt % 10;
		inputX = (player1InputInt - inputY) / 10;
		System.out.println("x:" + inputX + " y:" + inputY + "\n \n \n \n");
		if (playerType) {
			if (grid[inputX][inputY] == 'X' || grid[inputX][inputY] == 'O')
				;
			else {
				grid[inputX][inputY] = 'X';
			}
		} else {
			if (grid[inputX][inputY] == 'X' || grid[inputX][inputY] == 'O')
				;
			else {
				grid[inputX][inputY] = 'O';
			}
		}
		return grid;

	}

	private static boolean checkDraw() {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == 'X' || grid[i][j] == 'O') {
					counter += 1;
				}
			}
		}
		if (counter == 9) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
