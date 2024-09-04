import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        Queue<Space> spacesToExplore = new LinkedList<Space>();
        int curSpace = 1;

        while (!spacesToExplore.isEmpty()) {
            for (int i = 0; i < ladders.length; i++) {
                if (curSpace + 6 >= ladders[i][0] && curSpace + 1 >= ladders[i][0]) {
                    spacesToExplore.add(new Space(ladders[i][0], 0));
                }
            }
            for (int i = 0; i < snakes.length; i++) {
                if (curSpace + 6 >= snakes[i][0] && curSpace + 1 >= snakes[i][0]) {
                    spacesToExplore.add(new Space(snakes[i][0], 0));
                }
            }

            curSpace = spacesToExplore.remove().getSpace();

            if (curSpace == boardsize) {
                return 1;
            }
        }

        return -1;

//        System.out.print(boardsize);
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
    }
}