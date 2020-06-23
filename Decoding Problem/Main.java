import static java.lang.System.*;
class HM
{
	public static void main(String [] args)
	{
		out.println("Yup!!");
		out.println("We have enetered in implementation phase/n1.Forward Algorithm/n2.Viterbi Algorithm");
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
		// Forward object creation 
		
		Forward obj = new Forward();
		out.println("------Forward Algorithm------");
		double final_prob     = obj.compute(obs, states, start_prob, trans_prob, emiss_prob);
		out.println("The final probability for the given observation is  "+ final_prob);
		
		// Viterbi object creation
		
		Viterbi obj1 = new Viterbi();
		out.println("------Viterbi Algorithm------");
		int final_path[] 	  = obj1.compute(obs, states, start_prob, trans_prob, emiss_prob);
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
		
		
		// Backward object creation
		
		Backward obj2 = new Backward();
		out.println("------Backward Algorithm------");
		//double final_prob1    = obj2.compute(obs, states, start_prob, trans_prob, emiss_prob);
		out.println("The final probability for the given observation with Backward probability is "+ final_prob);
		out.println("------End------");
		
	}
}
