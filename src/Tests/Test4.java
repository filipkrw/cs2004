package Tests;

import java.util.ArrayList;

public class Test4 {
    public static void main(String[] args) {

    }

    public static double OneMaxFitness(ArrayList<Integer> rep){
        if (rep == null || rep.size() == 0) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < rep.size(); i++) {
            if (rep.get(i) != 1 && rep.get(i) != 0) {
                return -2;
            }
            sum += rep.get(i);
        }
        return sum;
    }
}
