import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class rd
{
static int n;
	static boolean markovChain()
	{
		double m[][]=new double[n][n];
		double sum=0;
		int s;
		Scanner in = new Scanner(System.in);
		// Checking validity of markov chain
		for(int i = 0; i <n; i++)
		{
			for(int j = 0; j<n; j++)
			{
				out.println("Enter the value");
				m[i][j]=in.nextFloat();
				sum=sum+m[i][j];	
			}	
		}
		s=(int)sum;
		if(s==3)
			return true;
		else
			return false;  
	}
	
	public static void main(String[] args)
	{
		out.print("Hello");
		Scanner in = new Scanner(System.in);
		out.println("Enter size of Markov chain");
		n=in.nextInt();
		
		if(markovChain())
			out.println("Yes Markov chain");
		else
			out.println("No not markov chain");
		out.println("End");
	}	
}
