public class Main {
    public static void main(String[] args) {
    }

    public static void RunAlgorithm()
    {
        long StartTime, EndTime, ElapsedTime;
        System.out.println("Testing algorithm…");
        StartTime=System.currentTimeMillis();



        EndTime=System.currentTimeMillis();
        ElapsedTime= EndTime- StartTime;
        System.out.println("The algorithm took " + ElapsedTime + " milliseconds to run.");
    }
}
