package Week21;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class TSP {
    double[][] dists;
    DecimalFormat df = new DecimalFormat("#.####");

    TSP(double[][] dists) {
        this.dists = dists;
    }

    public void RMHC() {
        Integer[] bestTour = RandomTour();

        for (int i = 0; i < 1000000; i++) {
            Integer[] newTour = SmallChange(bestTour);
            if (Fitness(newTour) < Fitness(bestTour)) {
                bestTour = newTour;
            }
        }

        System.out.println(Fitness(bestTour));
//        System.out.println(Arrays.toString(bestTour));
    }

    public void SHC() {
        Integer[] bestTour = RandomTour();
        Random rng = new Random();

        for (int i = 0; i < 1000000; i++) {
            Integer[] newTour = SmallChange(bestTour);

            double bestTourFitness = Fitness(bestTour);
            double newTourFitness = Fitness(newTour);
            double T = 200;

            double acceptWorseProb = 1 / (1 + Math.exp((newTourFitness - bestTourFitness) / T));

            double random = rng.nextDouble();

            if (Fitness(newTour) < Fitness(bestTour)) {
                bestTour = newTour;
            } else if (random < acceptWorseProb) {
//                System.out.println(df.format(random) + " < " + df.format(acceptWorseProb) + " = " + (random < acceptWorseProb));
                bestTour = newTour;
            }
        }

        System.out.println(Fitness(bestTour));
//        System.out.println(Arrays.toString(bestTour));
    }

    public void RRHC() {
        Integer[] bestGlobalTour = RandomTour();

        for (int j = 0; j < 10; j++) {
            Integer[] bestTour = RandomTour();

            for (int i = 0; i < 100000; i++) {
                Integer[] newTour = SmallChange(bestTour);
                if (Fitness(newTour) < Fitness(bestTour)) {
                    bestTour = newTour;
                }
            }

            if (Fitness(bestTour) < Fitness(bestGlobalTour)) {
//                System.out.println("New global");
                bestGlobalTour = bestTour;
            }
        }

        System.out.println(Fitness(bestGlobalTour));
//        System.out.println(Arrays.toString(bestGlobalTour));
    }

    public void SA() {
        Random rng = new Random();
        int iter = 100000;
        double temp = 4500;
        double coolingRate = Math.pow(0.25 / temp, 1.0 / iter);
        Integer[] bestTour = RandomTour();

        for (int i = 0; i < iter; i++) {
            Integer[] newTour = SmallChange(bestTour);
            double bestFitness = Fitness(bestTour);
            double newFitness = Fitness(newTour);

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

        System.out.println(Fitness(bestTour));
    }

    public Integer[] RandomTour() {
        Integer[] cities = IntStream.range(0, dists.length).boxed().toArray(Integer[]::new);
        List<Integer> citiesList = Arrays.asList(cities);
        Collections.shuffle(citiesList);
        Integer[] tour = citiesList.toArray(cities);
        return tour;
    }

    public Integer[] SmallChange(Integer[] tour) {
        int a = CS2004.UI(0, tour.length - 1);
        int b = CS2004.UI(0, tour.length - 1);

        while (a == b) {
            b = CS2004.UI(0, tour.length - 1);
        }

        Integer[] newTour = tour.clone();

        int temp = newTour[a];
        newTour[a] = newTour[b];
        newTour[b] = temp;

        return newTour;
    }

    public double Fitness(Integer[] tour) {
        double fitness = 0;
        for (int i = 0; i < tour.length - 1; i++) {
            fitness += dists[tour[i]][tour[i+1]];
        }
        fitness += dists[tour[tour.length - 1]][tour[0]];
        return fitness;
    }
}
