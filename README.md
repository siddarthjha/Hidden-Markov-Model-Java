# Hidden-Markov-Model-Java
Implementation of Forward-Backward and Viterbi Algorithm in Java

**Hidden Markov Model (HMM)** is a statistical Markov model in which the system being modeled is assumed to be a Markov process with unobserved (i.e. hidden) states.

* In probability theory, a Markov model is a stochastic model used to model randomly changing systems. It is assumed that future states depend only on the current state, not on the events that occurred before it (that is, it assumes the Markov property).

**Example:** Lets Assume,
To start off, a Hidden Markov Model consists of the following properties:

![States photo](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/5.png)


**Hidden States S**: in the example above the hidden states are Sunny and Rainy, and they get grouped into a set S.

**Observables O**: Paint, Clean, Shop and Bike. They get grouped into a set O.

**Initial Probabilities 𝜋**: a matrix of the initial likelihood of the state at time t = 0. In this case the likelihood that it is Sunny on the first day is 0.6, while the likelihood that it is Rainy is 0.4.
𝜋 = |0.6, 0.4|

**Note**: every row of the following matrices must add up to 1 since they represent a probability.

**Transition Probabilities A**: a matrix that represents the probability of transitioning to another state given the current state.

###### For example,
if the current state is Sunny the probability that the day after is Sunny as well is 0.8, whereas the probability that the day after is Rainy is 0.2.

![Transition probability](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/1.jpeg)

Similarly if today is Rainy, the probability that tomorrow is Rainy as well is 0.6, while the probability that tomorrow is Sunny is 0.4.

**Emission Probabilities B**: a matrix that represents the probability of seeing a specific observable given a hidden state. 
###### For example,
the probability of Clean on a Sunny day is 0.1, whereas the probability of Clean on a Rainy day is 0.45.

![Emission Probability](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/images/2.png)

<br>
This is all very nice, but immediately we are faced with three problems:

* [The Likelihood problem](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/Forward.java) (Forward-Backward)

* [The Decoding problem](https://github.com/siddarthjha/Hidden-Markov-Model-Java/blob/master/Viterbi.java) (Viterbi)

* The Learning problem (Waum-Belch)
