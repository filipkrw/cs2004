//package Week21;
//
//import Week18.CS2004;
//import Week18.ScalesChrome;
//
//import java.util.ArrayList;
//
//public class TSPGenetic {
//    private ArrayList<TSPChrome> population = new ArrayList<>();
//    int populationSize;
//    double[][] dists;
//    double crossoverRate;
//    double mutationRate;
//
//    TSPGenetic(double[][] dists, int populationSize, double crossoverRate, double mutationRate) {
//        this.populationSize = populationSize;
//        this.dists = dists;
//        this.crossoverRate = crossoverRate;
//        this.mutationRate = mutationRate;
//    }
//
//    public void Run(int maxFitnessCalls) {
//        InitPopulation();
//
//        int i = 0;
//        while (i < maxFitnessCalls) {
//            CrossOver();
//            Mutation();
//            Survival();
//            i++;
//        }
//    }
//
//    private void Survival() {
//    }
//
//    private void Mutation() {
//        //Might be bigger than popsize due to crossover
//        int n = population.size();
//        for(int i=0;i<n;++i)
//        {
//            Integer[] chrome = population.get(i).tour.clone();
//            boolean changed = false;
//
//            for(int j=0;j<populationSize;++j)
//            {
//                if (CS2004.UR(0.0,1.0) < mutationRate)
//                {
//                    Integer x = chrome[j];
//                    x = (x + 1) % 2;
//                    chrome[j] = x;
//                    changed = true;
//                }
//            }
//            //Only add a new Chromosome if at least one bit/gene has changed
//            if (changed) population.add(new ScalesChrome(chrome));
//        }
//    }
//
//    private void CrossOver() {
//        //Decide who gets to breed
//        ArrayList<Integer> xlist = new ArrayList<>();
//        for(int i=0; i < populationSize; i++)
//        {
//            if (CS2004.UR(0.0,1.0) < crossoverRate) xlist.add(i);
//        }
//
//        //Pair up random parents
//        while(xlist.size() > 1)
//        {
//            int a = -1, b = -2;
//            while(a >= b)
//            {
//                a = CS2004.UI(0,xlist.size()-1);
//                b = CS2004.UI(0,xlist.size()-1);
//            }
//
//            DoUniformCrossOver(xlist.get(a), xlist.get(b));
//            xlist.remove(b);
//            xlist.remove(a);
//        }
//    }
//
//    private void InitPopulation() {
//        population.clear();
//
//        for (int i = 0; i < populationSize; i++) {
//            population.add(new TSPChrome(dists));
//        }
//    }
//
//    private void DoUniformCrossOver(int p1id,int p2id)
//    {
//        Integer[] p1 = population.get(p1id).tour;
//        Integer[] p2 = population.get(p2id).tour;
//        Integer[] c1 = new Integer[populationSize];
//        Integer[] c2 = new Integer[populationSize];
//
//        for(int i=0;i<populationSize;++i)
//        {
//            int xopos = CS2004.UI(0,1);
//
//            if (xopos == 0)
//            {
//                c1[i] = p1[i];
//                c2[i] = p2[i];
//            }
//            else
//            {
//                c1[i] = p2[i];
//                c2[i] = p1[i];
//            }
//        }
//
//        population.add(new TSPChrome(dists, c1));
//        population.add(new TSPChrome(dists, c2));
//    }
//}
