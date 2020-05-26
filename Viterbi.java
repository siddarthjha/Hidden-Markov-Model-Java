// Implementation of Viterbi Algorithm used for decoding purpose of input observation based on given HMM.

import java.util.Scanner;
import static java.lang.System.*;
public class Viterbi
{
	// obs        ->Given observation for which the path has to be calculated.
	// states     ->The various states HMM goes through.
	// start_prob ->The start probability of each state.
	// trans_prob ->The transition probability from state to state.
	// emiss_prob ->The emission probability assosciated with each observation.
	// path       ->The resultant path of the given input observation sequence.
	
	
	public static int[] compute(int obs[], int states[], double start_prob[], double trans_prob[][], double emiss_prob[][]) throws ArrayIndexOutOfBoundsException
	{
		double[][] viterbi = new double[obs.length][states.length];
		int [][] path = new int[states.length][obs.length];
		
		out.println("The observation sequence -");
		for(int i=0; i<obs.length; i++)
		{
			out.print(obs[i] + " ");
		}
		
		// Viterbi matrix initializing.
		for(int state : states)
		{
			viterbi[0][state] = start_prob[state] * emiss_prob[state][obs[0] - 1];
			path[state][0] = state;
		}
		
		for(int i=1; i<obs.length; i++)
		{
			int [][] newpath = new int[states.length][obs.length];
			
			for(int cur_state : states)
			{
				double prob = -1.0;
				int state;
				for(int from_state: states)
				{
					double nprob = viterbi[i - 1][from_state] * trans_prob[from_state][cur_state] * emiss_prob[cur_state][obs[i] - 1];
					if(nprob > prob)
					{
						// Re-assign, if only greater.
						prob = nprob;
						state = from_state;
						viterbi[i][cur_state] = prob;
						System.arraycopy(path[state], 0, newpath[cur_state], 0, i);
						newpath[cur_state][i] = cur_state;
						
					}
				}
			}
			path = newpath;
				
		}
		
		// Construction of Viterbi matrix.
		
		for(int i =0; i<obs.length; i++)
		{
			for(int j=0; j<states.length; j++)
			{
				out.print(viterbi[i][j]+" ");
			}
			out.println();
		}
		
		double prob = -1;
        int state = 0;
		// The final path computataion.
		for(int state1: states)
		{
			if(viterbi[obs.length - 1][state1] > prob)
			{
				prob = viterbi[obs.length - 1][state1];
				state = state1;
			}
			
		}
		
		
		return path[state];
	}
	
	/*
	public static void main(String[] args)
	{
		
		out.print("Hello We have entered in Viterbi Implementation phase");
		int obs[]             = {3, 3, 2, 2, 1, 1, 3, 1, 3};
		int states[]          = {0, 1, 2, 3};               // 0-Start, 1-Tue, 2-Wed, 3-Thu.
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
		int final_path[] 	  = algo1(obs, states, start_prob, trans_prob, emiss_prob);
		out.println("The resultant path of first observation ");
		for(int path: final_path)
		{
			if(path == 1)
				out.print("Tue ");
			else if(path == 2)
				out.print("Wed ");
			else
			{
				out.print("Thu ");
			}
		}
		out.println();
	}
	*/
} 