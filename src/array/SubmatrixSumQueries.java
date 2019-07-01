package array;

public class SubmatrixSumQueries {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3, 4, 6}, {5, 3, 8, 1, 2}, {4, 6, 7, 5, 5}, {2, 4, 8, 9, 4}};
        int row = mat.length;
        int cols = mat[0].length;

        int aux[][] = new int[row][cols];

        preProcess(mat, aux);

        int tli = 2, tlj = 2, rbi = 3, rbj = 4;
        System.out.print("Query1: " + sumQuery(aux, tli, tlj, rbi, rbj));

        tli = 0;
        tlj = 0;
        rbi = 1;
        rbj = 1;
        System.out.print("\nQuery2: " + sumQuery(aux, tli, tlj, rbi, rbj));

        tli = 1;
        tlj = 2;
        rbi = 3;
        rbj = 3;
        System.out.print("\nQuery3: " + sumQuery(aux, tli, tlj, rbi, rbj));
    }

    private static int sumQuery(int aux[][], int tli, int tlj, int rbi, int rbj) {

        int res = aux[rbi][rbj];

        if (tli > 0) {
            res = res - aux[tli - 1][rbj];
        }

        if (tlj > 0) {
            res = res - aux[rbi][tlj - 1];
        }

        if (tli > 0 && tlj > 0) {
            res = res + aux[tli - 1][tlj - 1];
        }

        return res;
    }

    private static void preProcess(int mat[][], int aux[][]) {

        int row = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < cols; i++) {
            aux[0][i] = mat[0][i];
        }

        for (int i = 1; i < row; i++)
            for (int j = 0; j < cols; j++) {
                aux[i][j] = mat[i][j] + aux[i - 1][j];
            }

        for (int i = 0; i < row; i++)
            for (int j = 1; j < cols; j++) {
                aux[i][j] += aux[i][j - 1];
            }
    }
}
