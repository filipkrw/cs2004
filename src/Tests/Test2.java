package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
//        System.out.println(RandomArray(0, (short) 2, (short) 20));
        int[][] rm = RandomMatrix(5, 2, 10);

        assert rm != null;
        for (int[] row : rm) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] RandomMatrix(int n, int lower, int upper){
        if (n < 1 || lower > upper) {
            return null;
        }

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (i == j) {
                    result[i][j] = lower;
                } else {
                    int r = random.nextInt((upper - lower) + 1) + lower;
                    result[i][j] = r;
                    result[j][i] = r;
                }
            }
        }

        return result;
    }

    public static ArrayList<Short> RandomArray(int n, short maxVal, short minVal){
        if (n < 1) {
            return null;
        }

        ArrayList<Short> result = new ArrayList<>();

        if (minVal > maxVal) {
            return result;
        }

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < n; i++) {
            Short r = (short) (Math.abs(random.nextInt() % (maxVal - minVal + 1)) + minVal);
            result.add(r);
        }

        return result;
    }
}
