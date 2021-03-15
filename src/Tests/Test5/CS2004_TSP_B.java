package Tests.Test5;

import Week21.CS2004;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CS2004_TSP_B {
    public static ArrayList<Integer> RunTSP(int iterations, float[][] distances) {
        if (distances == null) {
            return new ArrayList<>();
        } else if (distances.length == 0 || iterations < 0) {
            return null;
        }

        return SA(iterations, distances);
    }

    public static ArrayList<Integer> SA(int iter, float[][] dists) {
        Random rng = new Random();
        double temp = 4500;
        double coolingRate = Math.pow(0.25 / temp, 1.0 / iter);
        ArrayList<Integer> bestTour = RandomTour(dists);


        for (int i = 0; i < iter; i++) {
            ArrayList<Integer> newTour = SmallChange(bestTour);
            double bestFitness = Fitness(bestTour, dists);
            double newFitness = Fitness(newTour, dists);

            System.out.println(temp);

            if (newFitness < bestFitness) {
                bestTour = newTour;
            } else {
                double acceptProbability = Math.exp((-Math.abs(bestFitness - newFitness)) / temp);
                if (rng.nextDouble() < acceptProbability) {
                    bestTour = newTour;
                }
            }

            temp *= coolingRate;
        }

        System.out.println(Fitness(bestTour, dists));
        return bestTour;
    }

    public static ArrayList<Integer> RandomTour(float[][] dists) {
        List<Integer> tour = IntStream.range(0, dists.length).boxed().collect(Collectors.toList());
        Collections.shuffle(tour);
        return (ArrayList<Integer>) tour;
    }

    public static ArrayList<Integer> SmallChange(ArrayList<Integer> tour) {
        int a = Week21.CS2004.UI(0, tour.size() - 1);
        int b = Week21.CS2004.UI(0, tour.size() - 1);

        while (a == b) {
            b = CS2004.UI(0, tour.size() - 1);
        }

        ArrayList<Integer> newTour = new ArrayList<>(tour);

        int temp = newTour.get(a);
        newTour.set(a, newTour.get(b));
        newTour.set(b, temp);

        return newTour;
    }

    public static double Fitness(ArrayList<Integer> tour, float[][] dists) {
        double fitness = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            fitness += dists[tour.get(i)][tour.get(i + 1)];
        }
        fitness += dists[tour.get(tour.size() - 1)][tour.get(0)];
        return fitness;
    }
}
