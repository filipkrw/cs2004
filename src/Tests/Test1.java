package Tests;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Float> X = new ArrayList<>();

        X.add(5F);
        X.add(2.32F);
        X.add(1.43F);
        X.add(125.9F);
        X.add(1F);

        System.out.println(PrefixAverage(X));
    }

    public static ArrayList<Float> PrefixAverage(ArrayList<Float> X){
        if (X == null || X.size() == 0) {
            return null;
        }

        ArrayList<Float> A = new ArrayList<>();
        float sum = 0;

        for (int i = 0; i < X.size(); i++) {
            sum += X.get(i);
            A.add(sum / (i + 1));
        }

        return A;
    }
}
