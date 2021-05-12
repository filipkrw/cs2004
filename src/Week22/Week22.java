package Week22;

import java.util.ArrayList;

public class Week22 {
    public static void main(String[] args) {
        Bezdeklris();
    }

    public static void Bezdeklris() {
        double[][] file = KMeans.ReadArrayFile("D:\\Pracownia\\Java\\cs2004\\src\\Week22\\bezdekIris.data.txt", ",");

        ArrayList<Integer> expectedArrangement = new ArrayList<>();

        for (int i = 0; i < file.length; i++) {
            expectedArrangement.add((int) file[i][4]);
        }

        KMeans kMeans = new KMeans(file, 4, 150);

        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> clusters = kMeans.RunIter(3, 10, expectedArrangement, false);
            System.out.println(KMeans.GroupingWK(expectedArrangement, clusters));
        }
    }

    public static void ClusterLab() {
        ArrayList<Integer> expectedArrangement = new ArrayList<>();
        for (int i = 0; i < 25; i++) expectedArrangement.add(0);
        for (int i = 0; i < 50; i++) expectedArrangement.add(1);
        for (int i = 0; i < 25; i++) expectedArrangement.add(2);

        double[][] file = KMeans.ReadArrayFile("D:\\Pracownia\\Java\\cs2004\\src\\Week22\\ClusterLab.txt", ",");

        KMeans kMeans = new KMeans(file, 3, 100);

        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> clusters = kMeans.RunIter(3, 10, expectedArrangement, false);
            System.out.println(KMeans.GroupingWK(expectedArrangement, clusters));
        }
    }
}
