// Implementation of Forward Algorithm which computes the likelihood of given input observation.

import static java.lang.System.*;
import java.util.Scanner;
public class Forward
{
	
	// obs        ->Given observation for which likelihood has to be calculated.
	// states     ->The various states HMM goes through.
	// start_prob ->The start probability of each state.
	// trans_prob ->The transition probability from state to state.
	// emiss_prob ->The emission probability assosciated with each observation.
	// prob       ->The likelihood probability of the input observation sequence.
	
	public static double compute(int obs[], int states[], double start_prob[], double trans_prob[][], double emiss_prob[][]) throws ArrayIndexOutOfBoundsException
	{
		double forward[][] = new double[obs.length][states.length];
		
		out.println("The observation sequence - ");
		for(int i=0; i<obs.length; i++)
		{
			out.print(obs[i]+" ");
		}
		out.println();
		
		// Initializing the Forward Matrix
		for(int state : states)
		{
			forward[0][state] = start_prob[state] * emiss_prob[state][obs[0]-1];
		}
		
		for(int i=1; i<obs.length; i++)
		{
			for(int state1 : states)
			{
				forward[i][state1] = 0;
				
				for(int state2 : states)
				{
					forward[i][state1] += forward[i - 1][state2] * trans_prob[state2][state1];
					
					// Forward Algorithm adds up every probability calculated, takes to the maximum.
				}
				forward[i][state1] *= emiss_prob[state1][obs[i] - 1];
			}
		}
		
		// To check the status of Forward Matrix.
		for(int i=0; i<obs.length; i++)
		{
			for(int j=0; j<states.length; j++)
			{
				out.println(forward[i][j]+"");
			}
			//out.println();
		}
		
		// Calculation of final likelihood probability.
		double prob = 0;
		for(int state: states)
		{
			prob += forward[obs.length - 1][state];
		}
		
		
		return prob;
	}
	/*
	
	public static void main(String[] args)
	{
		
		out.println("We have enetered in implementation phase");
		int obs[]             = {3, 3, 2, 2, 1, 1, 3, 1, 3};
		int states[]           = {0, 1, 2, 3};               // 0-Mon, 1-Tue, 2-Wed, 3-Thu.
		double start_prob[]   = {1, 1, 1, 1};
		double trans_prob[][] = 
		{
			                    {0, 0.8, 0.2, 0},
							    {0, 0.6, 0.3, 0.1},
								{0, 0.4, 0.5, 0.1},
								{0, 0, 0, 0} 
		};
		double emiss_prob[][] = 
		{
			                	{0, 0, 0},
								{0.2, 0.4, 0.4},
								{0.5, 0.4, 0.1},
								{0, 0, 0}
		};
		double final_prob     = algo(obs, states, start_prob, trans_prob, emiss_prob);
		out.println("The final probability for the given observation is  "+ final_prob);
		
	}
	*/
	
}
