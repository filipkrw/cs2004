package Tests.Test5;

import Weeks10and11.CS2004;

import java.util.ArrayList;

public class CS2004_Scales_B {
    public static ArrayList<Short> RunScales(int iterations, ArrayList<Double> weights){
        if (weights == null || iterations < 0) {
            return null;
        } else if (weights.isEmpty()) {
            return new ArrayList<>();
        }

        double temperature = 250;
        double coolingRate = Math.pow(0.001 / temperature, 1.0 / iterations);

        ArrayList<Short> bestSolution = RandomSolution(weights.size());

        for (int i = 0; i < iterations; i++) {
            ArrayList<Short> newSolution = SmallChange(bestSolution);
            double bestFitness = Fitness(bestSolution, weights);
            double newFitness = Fitness(newSolution, weights);

            if (newFitness < bestFitness) {
                bestSolution = newSolution;
            }
            else {
                double acceptProbability = Math.exp((-Math.abs(bestFitness - newFitness)) / temperature);
                if (CS2004.UR(0, 1) < acceptProbability) {
                    bestSolution = newSolution;
                }
            }

            temperature *= coolingRate;
        }

        return bestSolution;
    }

    public static ArrayList<Short> SmallChange(ArrayList<Short> solution) {
        ArrayList<Short> newSolution = new ArrayList<>(solution);

        int r = CS2004.UI(0, solution.size() - 1);
        Short newValue = newSolution.get(r) == 0 ? (short) 1 : (short) 0;
        newSolution.set(r, newValue);

        return newSolution;
    }

    public static ArrayList<Short> RandomSolution(int n) {
        ArrayList<Short> solution = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            solution.add(CS2004.UI(0, 1) == 0 ? (short) 0 : (short) 1);
        }

        return solution;
    }

    public static double Fitness(ArrayList<Short> solution, ArrayList<Double> weights) {
        double left = 0;
        double right = 0;

        for (int i = 0; i < solution.size(); i++) {
            if (solution.get(i) == 1) {
                left += weights.get(i);
            } else {
                right += weights.get(i);
            }
        }

        return Math.abs(left - right);
    }
}
