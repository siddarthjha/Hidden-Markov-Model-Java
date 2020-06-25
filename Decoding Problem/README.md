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

![Termination](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/11.png)

![](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/12.png)

**Backtracking**
![Backtracking](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/13.png)
