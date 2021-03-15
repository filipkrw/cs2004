package Tests.Test5;

import Week21.TSP;
import Week21.TSPData;
import Weeks10and11.CS2004;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Double> weightsFromFile = CS2004.ReadNumberFile("D:\\Pracownia\\Java\\cs2004\\src\\Tests\\Test5\\1000 Primes.txt");
//        ArrayList<Double> weights100 = new ArrayList<>(weightsFromFile.subList(0, 100));
//
//        for (int i = 0; i < 10; i++) {
//            ArrayList<Short> solution = CS2004_Scales_B.RunScales(1000, weights100);
//            System.out.println(CS2004_Scales_B.Fitness(solution, weights100));
//        }

        double[][] dists = TSPData.ReadArrayFile("D:\\Pracownia\\Java\\cs2004\\src\\Week21\\TSPData\\TSP_48.txt", " ");
        Integer[] optimal = TSPData.ReadIntegerFile("D:\\Pracownia\\Java\\cs2004\\src\\Week21\\TSPData\\TSP_100_OPT.txt").toArray(new Integer[0]);

        float[][] distsFloat = new float[dists.length][dists[0].length];

        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                distsFloat[i][j] = (float) dists[i][j];
            }
        }

        for (int i = 0; i < 1; i++) {
            CS2004_TSP_B.RunTSP(1000, distsFloat);
        }
    }
}
