package Week16;

import java.util.ArrayList;

public class Week16 {
    public static void main(String[] args) {
//        LimitSolution("max", 200);
        TargetSolution(95000, 200);
    }

    public static CannonSolution LimitSolution(String limit, int iter) {
        CannonSolution sol = new CannonSolution();

        for (int i = 0; i < iter; i++) {
            CannonSolution newSol = new CannonSolution(sol);
            newSol.SmallChange();

            if (limit.equals("max")) {
                if (newSol.FitnessForLimit() > sol.FitnessForLimit())
                    sol = newSol;
            } else {
                if (newSol.FitnessForLimit() < sol.FitnessForLimit())
                    sol = newSol;
            }

            System.out.println((i + 1) + ": " + sol.FitnessForLimit() + "; a: " + sol.angle + ", v: " + sol.velocity);
        }

        return sol;
    }

    public static CannonSolution TargetSolution(double target, int iter) {
        CannonSolution sol = new CannonSolution();

        for (int i = 0; i < iter; i++) {
            CannonSolution newSol = new CannonSolution(sol);
            newSol.SmallChange();

            if (newSol.FitnessForTarget(target) < sol.FitnessForTarget(target)) {
                sol = newSol;
            }

            System.out.println((i + 1) + ": " + sol.FitnessForLimit() + "; a: " + sol.angle + ", v: " + sol.velocity);
        }

        return sol;
    }
}
