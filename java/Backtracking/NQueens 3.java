import java.util.HashSet;
import java.util.Set;

public class NQueens {
    int res = 0;

    public int nQueens(int n) {
        dfs(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
        return res;
    }

    private void dfs(int r, Set<Integer> diagonalsSet, Set<Integer> antiDiagonalsSet, Set<Integer> colsSet, int n) {
        // Termination condition: If we have reached the end of the rows,
        // we've placed all 'n' queens.
        if (r == n) {
            res++;
            return;
        }
        for (int c = 0; c < n; c++) {
            int currDiagonal = r - c;
            int currAntiDiagonal = r + c;
            // If there are queens on the current column, diagonal or
            // anti-diagonal, skip this square.
            if (colsSet.contains(c) || diagonalsSet.contains(currDiagonal) || antiDiagonalsSet.contains(currAntiDiagonal)) {
                continue;
            }
            // Place the queen by marking the current column, diagonal, and
            // anti−diagonal as occupied.
            colsSet.add(c);
            diagonalsSet.add(currDiagonal);
            antiDiagonalsSet.add(currAntiDiagonal);
            // Recursively move to the next row to continue placing queens.
            dfs(r + 1, diagonalsSet, antiDiagonalsSet, colsSet, n);
            // Backtrack by removing the current column, diagonal, and
            // anti−diagonal from the hash sets.
            colsSet.remove(c);
            diagonalsSet.remove(currDiagonal);
            antiDiagonalsSet.remove(currAntiDiagonal);
        }
    }
}