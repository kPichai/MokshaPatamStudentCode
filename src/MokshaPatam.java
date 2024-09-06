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
        boolean[] visited = new boolean[boardsize];
        int curSpace = 1;
        visited[0] = true;
        spacesToExplore.add(curSpace);

        int[] spaces = new int[boardsize];

        for (int i = 1; i <= boardsize; i++) {
            spaces[i-1] = i;
        }

        for (int[] arr : ladders) {
            spaces[arr[0] - 1] = arr[1];
        }

        for (int[] arr : snakes) {
            spaces[arr[0] - 1] = arr[1];
        }


//        for (int i : spaces) {
//            System.out.println(i);
//        }

        while (!spacesToExplore.isEmpty()) {
            for (int i = 1; i <= 6; i++) {
                if (curSpace >= boardsize - 6) {
                    return 1;
                } else if (!visited[curSpace + i - 1]) {
                    spacesToExplore.add(curSpace + i);
                }
            }

            curSpace = spaces[spacesToExplore.remove() - 1];
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