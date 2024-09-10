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

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        Queue<Integer> spacesToExplore = new LinkedList<Integer>();
        boolean[] visited = new boolean[boardsize + 1];
        int[] moves = new int[boardsize + 1];
        int curSpace = 1;
        visited[1] = true;
        spacesToExplore.add(curSpace);

        int[] spaces = new int[boardsize + 1];

        for (int[] arr : ladders) {
            spaces[arr[0]] = arr[1];
        }

        for (int[] arr : snakes) {
            spaces[arr[0]] = arr[1];
        }

        while (!spacesToExplore.isEmpty()) {

            curSpace = spacesToExplore.remove();

            if (curSpace + 6 >= boardsize) {
                if (curSpace == boardsize) {
                    return moves[curSpace];
                }
                return moves[curSpace] + 1;
            }

            for (int i = 1; i <= 6; i++) {
                if (!visited[curSpace + i]) {
                    if (spaces[curSpace + i] != 0) {
                        spacesToExplore.add(spaces[curSpace + i]);
                        moves[spaces[curSpace + i]] = moves[curSpace] + 1;
                    } else {
                        spacesToExplore.add(curSpace + i);
                        moves[curSpace + i] = moves[curSpace] + 1;
                    }

                    visited[curSpace + i] = true;
                }
            }


        }

        return -1;

//        System.out.println(boardsize);
//
//        System.out.println("\n");
//
//        for (int i = 0; i < ladders.length; i++) {
//            for (int j = 0; j < ladders[i].length; j++) {
//                System.out.print(ladders[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("\n");
//
//        for (int i = 0; i < snakes.length; i++) {
//            for (int j = 0; j < snakes[i].length; j++) {
//                System.out.print(snakes[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return -1;
    }
}