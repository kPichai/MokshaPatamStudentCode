import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Kieran Pichai
 *
 */

public class MokshaPatam {

    // Helper function to generate a single array of ints that contains all the info from ladders and snakes
    public static int[] generateSpacesArray(int[][] ladders, int[][] snakes, int boardsize) {

        // Initializes the array
        int[] spaces = new int[boardsize + 1];

        // Loops through ladders array
        for (int[] arr : ladders) {

            // Adds the end location of the current ladder to the starting location in spaces array
            spaces[arr[0]] = arr[1];
        }

        // Loops through snakes array
        for (int[] arr : snakes) {

            // Accomplishes the same goal as ladder loop
            spaces[arr[0]] = arr[1];
        }

        return spaces;
    }

    // Helper function that simulates the dice roll results and adds the next spaces to visit to a queue
    public static void checkDiceRollSpaces(Queue<Integer> nextSpaces, int curSpace, int[] moves, boolean[] visited,
                                           int[] spaces) {

        // Loops 6 times (6 sides of a dice) to simulate all spots possible within 6 spaces of your current one
        for (int i = 1; i <= 6; i++) {

            // Checks if the spot that you are rolling to has not been visited
            if (!visited[curSpace + i]) {

                // If not, it checks if the space the die will take you too is a snake or ladder
                if (spaces[curSpace + i] != 0) {

                    // If so it will add the space that the snake / ladder leads too to the queue
                    nextSpaces.add(spaces[curSpace + i]);

                    // Updates the spaces it takes to get to that spot via the spaces it took to get to the curSpace
                    moves[spaces[curSpace + i]] = moves[curSpace] + 1;
                } else {

                    // If not, it assumes the location of the space is the same as its index and adds that to the queue
                    nextSpaces.add(curSpace + i);

                    // Similar logic for moves as above
                    moves[curSpace + i] = moves[curSpace] + 1;
                }

                // Marks the current space as visited so it isn't repeated again in the future
                visited[curSpace + i] = true;
            }
        }
    }

    // Main function for this problem set, calculates the fewest number of moves to reach the final square in a board
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        // Initializes all critical variables to this
        Queue<Integer> spacesToExplore = new LinkedList<Integer>();
        boolean[] visited = new boolean[boardsize + 1];
        int[] moves = new int[boardsize + 1];

        // Initializes current space values so that the algorithm starts at and doesn't repeat the initial space
        int curSpace = 1;
        visited[1] = true;
        spacesToExplore.add(curSpace);

        // Uses the helper function to generate the spaces array
        int[] spaces = generateSpacesArray(ladders, snakes, boardsize);

        // Main while loop that loops through the spaces board until it reaches the end or until there are no more
        //          spaces left to explore
        while (!spacesToExplore.isEmpty()) {

            // Sets the current square to the one at the front of the queue
            curSpace = spacesToExplore.remove();

            // Checks if we are in a winning position
            if (curSpace + 6 >= boardsize) {

                // Checks if we are already exactly at the end (because then we don't want to add another move)
                if (curSpace == boardsize) {
                    return moves[curSpace];
                }

                // Case in which we are within 1 dice roll so it returns the current moves + 1 final dice roll
                return moves[curSpace] + 1;
            }

            // Calls helper function to check and add all the spots within 6 spaces (1 dice roll) of the current space
            checkDiceRollSpaces(spacesToExplore, curSpace, moves, visited, spaces);
        }

        // Returns -1 when we haven't found a solution and we run out of spaces to check (unsolvable board)
        return -1;
    }
}