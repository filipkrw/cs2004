package Tests;

import Weeks10and11.CS2004;

import java.util.ArrayList;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
//        ScalesFitness(null, null);
        System.out.println(RandomBinaryString(1));
    }

    public static String RandomBinaryString(int n){
        if (n < 1) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        Random random = new Random();
        random.setSeed(System.nanoTime());

        for (int i = 0; i < n; i++) {
            int randBinaryNum = Math.abs(random.nextInt() % 2);
            s.append(randBinaryNum);
        }

        return s.toString();
    }

    public static double ScalesFitness(ArrayList<Boolean> rep, ArrayList<Double> weights) {
        if (rep == null
                || weights == null
                || rep.size() == 0
                || weights.size() == 0
                || rep.size() > weights.size()) {
            return -100.0;
        }

        double lhs = 0.0, rhs = 0.0;

        for (int i = 0; i < rep.size(); i++) {
            if (rep.get(i)) {
                lhs += weights.get(i);
            } else {
                rhs += weights.get(i);
            }
        }

        return (Math.abs(lhs - rhs));
    }
}
