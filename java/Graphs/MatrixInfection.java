import java.util.LinkedList;
import java.util.Queue;

public class MatrixInfection {
    public int matrixInfection(int[][] matrix) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        int ones, seconds;
        ones = seconds = 0;
        // Count the total number of uninfected cells and add each infected 
        // cell to the queue to represent level 0 of the level-order  
        // traversal.
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 1) {
                    ones += 1;
                } else if (matrix[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        // Use level-order traversal to determine how long it takes to 
        // infect the uninfected cells.
        while (!queue.isEmpty() && ones > 0) {
            // 1 second passes with each level of the matrix that's explored.
            seconds++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                // Infect any neighboring 1s and add them to the queue to be 
                // processed in the next level.
                for (int[] d : dirs) {
                    int nextR = r + d[0];
                    int nextC = c + d[1];
                    if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] == 1) {
                        matrix[nextR][nextC] = 2;
                        ones--;
                        queue.offer(new int[]{nextR, nextC});
                    }
                }
            }
        }
        // If there are still uninfected cells left, return -1. Otherwise, 
        // return the time passed.
        return ones == 0 ? seconds : -1;
    }

    private boolean isWithinBounds(int r, int c, int[][] matrix) {
        return 0 <= r && r < matrix.length && 0 <= c && c < matrix[0].length;
    }
}
