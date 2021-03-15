package Week19;

import Week18.CS2004;
import Week18.ScalesChrome;
import Week18.SimpleGeneticAlgorithm;

import java.util.ArrayList;

public class Week19
{
	public static void main(String args[])
	{
		//Read in the weights
		//Make sure you change the filename as appropriate!
		//This will only work if "c:\temp\1000 Primes.txt" exists!
		ArrayList<Double> w = CS2004.ReadNumberFile("c:\\temp\\1000 Primes.txt");
		//Set the weights
		ScalesChrome.SetWeights(w);
		//Run 10 repeats
		for(int i=0;i<10;++i)
		{
			//Reset the fitness count
			ScalesChrome.ClearFC();
			//The following parameters are not very good!
			//These are the ones you should try and optimise!
			int popsize = 100;
			double mrate = 0.1;
			double crate = 0.5;
			//You will not need to change the following
			Week18.SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,10,1000,mrate,crate);
			//Run the GA for 10,000 function calls
			double f = ga.RunSGA(10000,false).GetFitness();
			System.out.println(f);
		}
	}
}
