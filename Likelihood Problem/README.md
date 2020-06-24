# Forward Algorithm


The Forward algorithm comprises of three steps:

* Initialization
* Recursion
* Termination

**Initialization**


![Initialization](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/1.png)

The above equation means that the first forward variable is calculated by multiplying the initial probability of state i by the emission probability b of that state given the observable O at time 1.

**Recursion**

Forward algorithm recursion equation
![Recursion](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/3.png)


For t = 1, 2, …, T-1 we make use of the recursion equation which defines the forward variable of state j as the product of the previous forward variable of state i, multiplied by the transition probability a between the previous state i to state j, multiplied by the emission probability b from state j to the observable O.

**Termination**

![Termination](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/4.png)

This final equation tells us that to find the probability of an observation sequence O deriving from an HMM model λ, we need to sum up all the forward variables at time T, i.e. all the variables of every state at the end of the observation sequence.
# Backward Algorithm

* Usually, to find the solution to the Likelihood problem we don’t really require to know the Backward Algorithm.
* However, its explanation and resolution is a good litmus test to show that the Forward algorithm works proficiently, and moreover, by understanding it now, we can be ready for when the time will come to use it for the resolution of the third problem of Learning.
* The Backward Algorithm is similar to the Forward algorithm, but like the name suggests it goes backward in time. There’s again an Initialization, a Recursion and a Termination.


**Initialization**

![Initialization](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/6.png)

What this simple equation is telling us is that at time T (at the end of the observation sequence) the backward variables of every state is equal to 1. Simple as that.

**Recursion**

![Recursion](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/7.png)

The equation above tells us to sum up all the multiplications of the transition probability from the current State i to the next State j, times the emission probability of the observable O at time t+1 from the next State j, times the backward variable of the next State j at time t+1.

**Termination**

![Termination](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/8.png)

What this equation wants us to do is to sum the multiplications of the initial probability π of state i, times the emission probability b of the observable O at time t=1 from state i, times the backward variable at time t=1 of state i.

