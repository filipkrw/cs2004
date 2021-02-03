package Week16;

import java.util.Random;

public class CannonSolution {
    double angle;
    double velocity;

    int minAngle = 25;
    int maxAngle = 55;

    int minVelocity = 1500;
    int maxVelocity = 1650;

    double angleChangeRate = ((double) (maxAngle - minAngle)) / 100;
    double velocityChangeRate = ((double) (maxVelocity - minVelocity)) / 100;

    public CannonSolution() {
        this.RandomStartingPoint();
    }

    public CannonSolution(CannonSolution toCopy) {
        this.angle = toCopy.angle;
        this.velocity = toCopy.velocity;
    }

    public double FitnessForLimit() {
        return Cannon.GetMaxRange(angle, velocity);
    }

    public double FitnessForTarget(double target) {
        double range = Cannon.GetMaxRange(angle, velocity);
        return Math.abs(range - target);
    }

    public void SmallChange() {
        Random rand = new Random();
        int parameterChoice = rand.nextDouble() >= 0.5 ? 1 : 0;
        int directionChoice = rand.nextDouble() >= 0.5 ? 1 : 0;

        if (parameterChoice > 0) {
            double angleChange = directionChoice > 0 ? angleChangeRate : angleChangeRate * -1;
            angle = Math.min(maxAngle, Math.max(minAngle, angle + angleChange));
        } else {
            double velocityChange = directionChoice > 0 ? velocityChangeRate : velocityChangeRate * -1;
            velocity = Math.min(maxVelocity, Math.max(minVelocity, velocity + velocityChange));
        }
    }

    public void RandomStartingPoint() {
        Random rand = new Random();

        this.angle = (double) rand.nextInt(maxAngle - minAngle) + minAngle;
        this.velocity = (double) rand.nextInt(maxVelocity - minVelocity) + minVelocity;
    }
}
