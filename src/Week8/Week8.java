package Week8;

public class Week8 {
    public static void main(String[] args) {
        double[][] g = {{0,1,2},{1,0,3},{2,3,0}};
        double[][] mst = MST.PrimsMST(g);

        showMatrix(mst);
    }

    public static void showMatrix(double[][] m) {
        for (double[] row : m) {
            for (double cell : row) {
                System.out.print((int) cell + " ");
            }
            System.out.println();
        }
    }
}
