import java.util.ArrayList;
import java.util.List;

public class PondSizes {
    public static void main(String[] args) {

        int[][] land = new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        List<Integer> sizes = pondSizes(land);
        System.out.println(sizes);
    }


    public static List<Integer> pondSizes(int[][] land) {
        List<Integer> sizes = new ArrayList<>();
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[r].length; c++) {
                if (land[r][c] == 0) {
                    int pondSize = computePondSize(r, c, land);
                    sizes.add(pondSize);
                }
            }
        }
        return sizes;
    }

    public static int computePondSize(int row, int col, int[][] ponds) {
        if (row < 0 || row >= ponds.length ||
                col < 0 || col >= ponds[row].length ||
                ponds[row][col] != 0) {
            return 0;
        }
        ponds[row][col] = -1; //marked as visited
        int size = 1;
        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                size += computePondSize(row + dRow, col + dCol, ponds);
            }
        }
        return size;
    }
}


