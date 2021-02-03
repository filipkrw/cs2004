package Weeks10and11;

import java.util.ArrayList;

public class Week10and11 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; ++i) {
//            int x = CS2004.UI(-1, 1);
//            System.out.println(x);
//        }

        ArrayList<Double> weights = new ArrayList<>();

        weights.add(1D);
        weights.add(2D);
        weights.add(3D);
        weights.add(4D);
        weights.add(10D);

        ScalesSolution s = new ScalesSolution("xxxxxx");
//        s.println();

//        System.out.println(s.ScalesFitness(weights));
//
//        s.SmallChange();
//        s.println();

//        ScalesSolution s1 = new ScalesSolution(10);
//        s1.println();
//        ScalesSolution s2 = new ScalesSolution(s1.GetSol());
//        s2.println();

        ArrayList<Double> weightsFromFile = CS2004.ReadNumberFile("src/Weeks10and11/primes.txt");
        ArrayList<Double> weights100 = new ArrayList<>(weightsFromFile.subList(0, 100));

        ScalesSolution sf = RMHC(weightsFromFile, 1000, 1000);
        sf.println();
    }

    public static ScalesSolution RMHC(ArrayList<Double> weights, int n, int iter) {
        ScalesSolution sol = new ScalesSolution(n);

        for (int i = 0; i < iter; i++) {
            ScalesSolution newSol = new ScalesSolution(sol.GetSol());
            newSol.SmallChange();
            if (newSol.ScalesFitness(weights) < sol.ScalesFitness(weights)) {
                sol = newSol;
            }
            System.out.println((i + 1) + ": " + sol.ScalesFitness(weights));
        }

        return sol;
    }
}
