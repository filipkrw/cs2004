package Week21;

import java.util.ArrayList;
import java.util.Arrays;

public class Week21 {
    public static void main(String[] args) {
        double[][] dists = TSPData.ReadArrayFile("D:\\Pracownia\\Java\\cs2004\\src\\Week21\\TSPData\\TSP_100.txt", " ");
        Integer[] optimal = TSPData.ReadIntegerFile("D:\\Pracownia\\Java\\cs2004\\src\\Week21\\TSPData\\TSP_100_OPT.txt").toArray(new Integer[0]);

        TSP tsp = new TSP(dists);

        for (int i = 0; i < 10; i++) {
//            tsp.RMHC();
//            tsp.RRHC();
//            tsp.SHC();
            tsp.SA();
        }
        System.out.println("Optimal fitness: " + tsp.Fitness(optimal));

//        tsp.RandomTour();
//        System.out.println(Arrays.toString(tsp.tour));
//        System.out.println(tsp.Fitness());
//
//        tsp.SmallChange();
//        System.out.println(Arrays.toString(tsp.tour));
//        System.out.println(tsp.Fitness());
    }
}
