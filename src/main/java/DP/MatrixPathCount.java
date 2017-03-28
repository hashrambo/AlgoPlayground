package DP;

/**
 * Created by hashrambo on 3/26/17.
 * Given that there is a mxn matrix which contains some obstacles in some of the grids.
 * To travel the grids, one could only make a right or downward operation.
 * Find the number of the possible paths going from the top left corner to the bottom right corner.
 *
 * e.g. A 6x6 matrix with obstacles indicated as 'x'
 * at coordinates (0,4), (1,2), (3,1), (3,4), (5,3)
 * +---+---+---+---+---+---+
 * |   |   |   |   | x |   |
 * +---+---+---+---+---+---+
 * |   |   | x |   |   |   |
 * +---+---+---+---+---+---+
 * |   |   |   |   |   |   |
 * +---+---+---+---+---+---+
 * |   | x |   |   | x |   |
 * +---+---+---+---+---+---+
 * |   |   |   |   |   |   |
 * +---+---+---+---+---+---+
 * |   |   |   | x |   |   |
 * +---+---+---+---+---+---+
 */
public class MatrixPathCount {



    /**
     * Typical recursive solution to count the number of paths.
     * This is from top left to bottom right.
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private static int pathCount(int[][] matrix, int row, int col){

        if (matrix[row][col] == -1)
            return 0;
        else if (row == getRowSize(matrix) || col == getColSize(matrix))
            return 1;
        else
            return pathCount(matrix, row+1, col) + pathCount(matrix, row, col+1);

    }

    /**
     * Typical recursive solution to count the number of paths.
     * This is from bottom right to top left
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private static int pathCountReverse(int [][] matrix, int row, int col){

        if (matrix[row][col] == -1)
            return 0;
        else if (row == 0 || col == 0)
            return 1;
        else
            return pathCountReverse(matrix, row-1, col) + pathCountReverse(matrix, row, col -1);
    }


    private static int getRowSize(int [][] matrix) {
        return matrix.length - 1;
    }

    private static int getColSize(int [][] matrix) {
        return matrix[0].length - 1;
    }

    /**
     * Count path with the technique of using memoization
     * @param matrix
     * @param row
     * @param col
     * @param mem
     * @return
     */
    private static int dpPathCount(int [][] matrix, int row, int col, int[][] mem){

        if (matrix[row][col] == -1)
            return 0;
        if (row == getRowSize(matrix) || col == getColSize(matrix))
            return 1;
        if (mem[row][col] == 0)
            mem[row][col] = dpPathCount(matrix, row+1, col, mem) + dpPathCount(matrix, row, col+1, mem);
        return mem[row][col];

    }


    public static void main(String[] args) {

        // Build the 6x6 matrix
        final int [][] matrix = new int [6][6];

        // initialize matrix values
        // -1 for obstacles, 0 for empty
        for (int i=0; i<6; i++) {
            for (int j=0; j<6; j++) {
                matrix[i][j] = 0;
            }
        }

        // set obstacles
        // coordinates (0,4), (1,2), (3,1), (3,4), (5,3)
        matrix[0][4] = -1;
        matrix[1][2] = -1;
        matrix[3][1] = -1;
        matrix[3][4] = -1;
        matrix[5][3] = -1;

        System.out.println(pathCount(matrix, 0, 0));
        System.out.println(pathCountReverse(matrix, 5, 5));

        // initialize memo table
        final int [][] mem = new int [6][6];
        for (int i=0; i<6; i++) {
            for (int j=0; j<6; j++) {
                mem[i][j] = 0;
            }
        }
        System.out.println(dpPathCount(matrix, 0, 0, mem));
    }

}
