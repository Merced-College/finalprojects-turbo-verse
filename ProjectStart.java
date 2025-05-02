import java.util.Scanner;

public class ProjectStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // This is what the maze looks like
        char[][] maze = {
            {'#', '#', '#', '#', '#', '#'},
            {'#', 'P', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', 'E', '#'},
            {'#', '#', '#', '#', '#', '#'}
        };

        // Player's starting position
        int playerRow = 1;
        int playerCol = 1;

        boolean gameRunning = true;

        System.out.println("Welcome to the Maze Game!");
        System.out.println("Use W (up), A (left), S (down), D (right) to move.");
        System.out.println("Reach 'E' to win!");

        while (gameRunning) {
            // Print the maze
            printMaze(maze);

            // Get player input
            System.out.print("Enter your move: ");
            char move = scanner.nextLine().toUpperCase().charAt(0);

            // Calculate new position
            int newRow = playerRow;
            int newCol = playerCol;

            switch (move) {
                case 'W': newRow--; break; // Move up
                case 'A': newCol--; break; // Move left
                case 'S': newRow++; break; // Move down
                case 'D': newCol++; break; // Move right
                default:
                    System.out.println("Invalid move. Use W, A, S, or D.");
                    continue;
            }

            // Check if the move is valid
            if (maze[newRow][newCol] == '#') {
                System.out.println("You hit a wall! Try a different direction.");
            } else {
                // Update the maze
                maze[playerRow][playerCol] = ' '; // Clear old position
                playerRow = newRow;
                playerCol = newCol;

                // Check if the player reached the exit
                //The Player is the character P
                //The Exit is the character E
                if (maze[playerRow][playerCol] == 'E') {
                    maze[playerRow][playerCol] = 'P';
                    printMaze(maze);
                    System.out.println("Congratulations! You reached the exit!");
                    gameRunning = false;
                } else {
                    maze[playerRow][playerCol] = 'P'; // Update player position
                }
            }
        }

        scanner.close();
    }

    // Method to print the maze
    // The #'s are used to create walls
    private static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        // my game ceates a maze and the player is the character P
        //They have to reach the exit E while avoiding the walls #

        // The parts that I written are putting the comments that explain a part of the maze
        // I also explained the characters that are used in the maze
    }
}
// what I intend to do next is add some kind of enemy that chases the player
// I also want to add a timer that counts down from 60 seconds
// I also want to add a score that increases when the player reaches the exit
// I also want to add a way to restart the game