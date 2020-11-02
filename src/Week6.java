import java.util.ArrayList;
import java.util.Random;

public class Week6 {
    public static void main(String[] args) {
        Test();
    }

    public static void Test()
    {
        int[] samples = {1000, 10000, 25000};
        int testsCount = 50;

        for (int sample : samples) {
            ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
            for (int k = 0; k < testsCount; k++) {
                numbers.add(RandomArray(sample));
            }

            long StartTime, EndTime;
            System.out.println("Testing for " + sample + " samples...");

            StartTime = System.currentTimeMillis();
            for (int j = 0; j < testsCount; j++) {
                ThreeSorts.SortA(numbers.get(j));
            }
            EndTime = System.currentTimeMillis();
            System.out.println("SortA: " + (EndTime - StartTime));

            StartTime = System.currentTimeMillis();
            for (int j = 0; j < testsCount; j++) {
                ThreeSorts.SortB(numbers.get(j));
            }
            EndTime = System.currentTimeMillis();
            System.out.println("SortB: " + (EndTime - StartTime));

            StartTime = System.currentTimeMillis();
            for (int j = 0; j < testsCount; j++) {
                ThreeSorts.SortB(numbers.get(j));
            }
            EndTime = System.currentTimeMillis();
            System.out.println("SortC: " + (EndTime - StartTime));
        }
    }

    public static ArrayList<Integer> RandomArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < n; i++) {
            Integer r = Math.abs(random.nextInt() % 256);
            result.add(r);
        }

        return result;
    }

    public static void ShowArray(ArrayList<Integer> array) {
        System.out.println(array);
    }
}
