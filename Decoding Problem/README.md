# Viterbi Algorithm

* The Decoding problem is asking us to find the best sequence of hidden states Q given the observation sequence O.
* Like the forward algorithm, Viterbi is a kind of dynamic programming
that makes uses of a dynamic programming trellis.
* **Dynamic programming**: it refers to simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner.
* And this is why, the Viterbi algorithm features similar steps to the forward algorithm: Initialization, Recursion and Termination, but also the Backtracking step to find the sequence of hidden states.
**Initialization**

![Initialization](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/9.png)

**Recursion**

![Recursion](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/10.png)


**Termination**

![Termination](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/11.png)

![](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/12.png)

**Backtracking**
![Backtracking](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/13.png)
