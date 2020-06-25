# Viterbi Algorithm

* The Decoding problem is asking us to find the best sequence of hidden states Q given the observation sequence O.
* Like the forward algorithm, Viterbi is a kind of dynamic programming
that makes uses of a dynamic programming trellis.
* **Dynamic programming**: it refers to simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner.
* And this is why, the Viterbi algorithm features similar steps to the forward algorithm: Initialization, Recursion and Termination, but also the Backtracking step to find the sequence of hidden states.


**Initialization**

![Initialization](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/9.png)

* It’s the same as the initialization equation of the Forward Algorithm.
* Here we multiply the initial probability of state i by the emission probability from state i to observable O at time t = 1.
* To retrieve the state sequence we also need to keep track of the argument which maximized for each t and j, i.e. the previous state that maximized the result of the equation.
* We do this via the array ψ, and in the initialization step the first ψ variable of every state will be equal to 0 because no specific argument coming from the initial probability maximized the value of the first state.

![](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/13.png)



**Recursion**

![Recursion](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/10.png)

Unlike in the Forward and Backward algorithms, in the Viterbi algorithm we’re not going to sum up the results of all the multiplications. Instead we’re going to find the maximum value among the multiplication results and assign that to the new Viterbi variable.
* The multiplication consists of the previous Viterbi variable of state i, times the transition probability from state i to j, times the emission probability from state j to observation O.


**Termination**

![Termination](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/12.png)

This equation represents the probability of the entire state sequence up to point T + 1 having been produced given the observation and the HMM’s parameters.
* So, we need to find the maximized value among all Viterbi variables at time T, i.e. all the variables of every state at the end of the observation sequence.

**Backtracking**

The start of the backtrace corresponds to the last state of the hidden state sequence, and is given by the ψ equation at the termination step above
* The equation below is meant to find the hidden state sequence by backtracing through the ψ arrays.

![Backtracking](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/11.png)

* The q*s are the states of the state sequence we’re trying to find. So, when t+1 is equal to T the state q* is the last state Sunny.
* Now, to find q* at time t we’re basically searching in the array ψ of the state q*t+1 at time t+1.


