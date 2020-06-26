// Implementation of Forward Algorithm which computes the likelihood of given input observation.

import static java.lang.System.*;
import java.util.Scanner;
public class Forward
{
	
	@param obs        ->Given observation for which likelihood has to be calculated.
	@param states     ->The various states HMM goes through.
	@param start_prob ->The start probability of each state.
	@param trans_prob ->The transition probability from state to state.
	@param emiss_prob ->The emission probability assosciated with each observation.
	@param prob       ->The likelihood probability of the input observation sequence.
	
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

