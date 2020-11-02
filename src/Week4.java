import java.util.Random;

public class Week4 {
    public static void main(String[] args) {
        Test();
    }

    public static void PrefixAverages2(double[] X) {
        double[] A = new double[X.length];
        double sum = 0;

        for (int i = 0; i < X.length; i++) {
            sum += X[i];
            A[i] = sum / (i + 1);
        }
    }

    public static void Test()
    {
        int samples[] = {500000, 5000000, 50000000};
        long avgTime[] = new long[samples.length];
        int testsCount = 50;

        for(int i = 0; i < samples.length; i++) {
            System.out.println("Testing for " + samples[i] + " samples...");
            long timeSum = 0;

            for (int j = 0; j < testsCount; j++) {
                double[] X = getRandomX(samples[i]);
                long StartTime = System.currentTimeMillis();

                PrefixAverages2(X);

                long EndTime = System.currentTimeMillis();
                long ElapsedTime = EndTime - StartTime;

//                System.out.println("Test " + (j + 1) + " time: " + ElapsedTime);
                timeSum += ElapsedTime;
            }

            avgTime[i] = timeSum / testsCount;
            System.out.println("Average time (ms) for " + (i + 1) + " samples: " + avgTime[i]);
            System.out.println();
        }


    }

    public static double[] getRandomX(int size) {
        double[] X = new double[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            X[i] = rand.nextDouble();
        }

        return X;
    }
}
