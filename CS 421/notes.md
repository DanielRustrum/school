# 421 Algorithms
  [Professor's Notes](https://nau0-my.sharepoint.com/:o:/g/personal/dieter_otte_nau_edu/EpSQ_NdQnExNnQvFRgHyZcEBOw7ChciODVm9rFUCf9jSlA?e=X4KMt0)

  [NancyPi Algorithm Youtube](https://www.youtube.com/watch?v=Zw5t6BTQYRU)

## Day 1
### **Introduction**
Algorithms:
- Algorithms are recursive by nature
- Sort Things
- Linear in nature
- Greedy Algorithms

  
Anaylizing:
- runtime behaviour

dynamic programming
helps with preformence



### **Needs**
- textbook, Introduction to algorithms, on syllabus
- Works outside of class
- Reading assignments
- Sign up sheet or quiz **Don't Miss**
- actively be apart of the class
- Motivated, self critical
- ask questions

### **What will he do?**
- exercise
- mid-term and final practices

---
## Day 2
### **Algorithms**
What are algorithms?
- Input and Output
- Babies are algorithms 👶😿🐹
- Computational procedures, 
that transform an input into output to solve a problem<br><br>

What is important?
- Reusable
- Time Complexity
- Correctness, fine with approximation or 100%
- most complex construct is a loop

Loop Invariant

efficency:<br>
time:
- analysis<br>
- algorithm design
  
space:

termination:
- collatz-conjecture
- whether a algorithm terminates or not is a decision problem
- halting problem

<br>
Is there a halting machine?<br>
No? Proof by Allen Turning

You can verify the result easily, just redo the problem
P vs. NP problem

unexpected input,
may terminate or may not terminate

feed the halting machine its own program(X)
<br>
the halting machine finds x terminates,
the negator negates the T if decided. Either way ther is a contadiction,all the predictinos are the opposite.<br><br>
it tells us that we can't have a halting machine.

>To Terminate or not to terminate that is the question🥀💀👨
---
## Day 3
### **Correctness Of Algorithms**
How to prove correctness of algorithms by way of loop invariants:
- What? A Statement, whether a loop computes the correct result
- Statement awnsered with either true or false
- needs to hold true:
  -  at the initilization(Right before the loop, first time)
  - maintenance(after each run of the loop)
  - termination(Loop invariant has to provide a useful property that show the loop is correct)
  
invariant means does not change

<br><br>
*Loop Invarient Example:<br>*
```python
    sum(u)
        sum = 0
        i = 1
        # Initilization here
        while(i <= u) # Maintence Here
            sum += i
            i++
        # Termination Here
        return sum 
```
loop invariant:<br>
    At the start of each iteration , some contains the first i - 1 elements summed up.

init: <br>
    sum = 0, i = 1 i-1 = 0<br>
    sum contains the first 0 element summed up, which is true<br><br>

main:<br>
    We loop the first time<br>
    sum += i -> 1, i++ -> 2<br>
    sum contains the first 1 elements summed up, which is true
    incrementing i reestablishes the Loop invariant<br><br>

term:
    by the end of the loop<br>
    i = u + 1<br>
    By loop Invariant -> i = u+1-1 = u, we have summed up i-1 elements, which is true

<br><br><br><br><br><br>

### **Analyzing Algorithms**

Concentrate on the runtime, most important for us

Runtime Analyses:<br>
Goal - Determine order of growth, depends on the number of elements(asymtotic runtime O(n squared))<br>
Scheme of Reference - is called Random Access Machine(A standardized computer)<br><br>
RAM has on CPU that can run basic operations, operations are sequentially executed, constent runtime, memory access is also constant time.<br>

Some algorithms can be ran in parrell and some can't 😢

**runtime analysis of non-recursive algorithms:**<br>
Big O:
1. Come up with abstract cost per line of code
2. Add up all Cost
3. order cost according to significance or magnitude
4. abstract cost of abstract cost(c1 + c2 + c3 = C, make one C)
5. Keep most significant term
6. Drop Coeficient

---

## Day 4
### **Run Time Analysis**

generalization:

```python
    I1  
    I2
    I3
```
T(?) = T(I1)+T(I2)...
What if we have a desicion:
T(?) = Max(T(I1), I(I2))
Account for the worst runtime

```python
L1(N):
    I1

L2(M):
    I2
```

T(?) = n * T(I1) + m * T(I2)

Nested Loop
```python
L1(n):
    L2(m):
        I1
```

T(?) = n * m * T(I1)

Best Case Vs. Worst Case?<br>
Intrested in the Worst Case

Most of the medium case is typically the worst case

recursion:<br>
This notation is helpful with the linear parts<br>
Divide, conquer, and combine

Goal-
    reduce problem size

=> Divide a problem into smaller sub problems(s)<br>
typically, all of the sub problems are the same

=> Conquer the sub problems & combine the results<br>
Represents the recursive part

=> Combine result<br>

D&C+C T(n) = aT(n/b)+D(n)+C(n)<br>
doesn't always look like such (n/b)<br>
D() is the cost of the divide, C is the cost of the Combine<br>
a is the number of sub problems, b is size of sub problems (Conquer part)

Merge Sort-<br>
>T(N) = 2T(N/2) + O(1) + O(N)<br>
T(N) = 2T(N/2) + cN (Runtime Recurrance)

The recocurrence is the recursion tree

How to solve?<br>
-> follow the recursion<br>
-Results in a recursion tree<br>
-> Master Method<br>
-> Substitution Method

At one point you need to stop with the recursion

step 1:<br>
>cn<br>
|<br>
|_ T(N/2)<br>
|_ T(N/2)<br>


step 2:<br>
>T(n/2) = 2T(n/2/2) + cn/2<br>
T(x) = 2T(x/2) + c(x), where x is n over a constant





---

## Day 5
### **Recursion**
builds on Day 4 notes

Why we do it: Need to get rid of recurrsive terms
<br> The only thing that grows are the recurssive terms, thats why we put them as leaves.

divide by log(n) to find when the recursion bottoms out

Step 3:<br>
How may levels do we have?<br>
> ex: n = 8 -> 2^3 -> 1<br>
we have 4 levels, 2^height times till we reach 1<br>
n = 2^(l-1)|lg, in algorithms is usually 2 based<br>
lgn = l-1<br>
l = lgn+1

The dificulty of recursion trees is to see the order in the chaos

Step 4:<br>
Add up costs<br>
We see that we have a cost of cn per level<br>
>cn*#oflevels<br>
cn*(lgn+1)
cnlgn+cn = O(nlgn)

🤕

Example(Fibinaci Sequence):
>F(n) = <u>F(n-1)</u> + <u>F(n-2)</u><br>
T(n) = T(n-1) + T(n-2) + (C1 + C2) = C<br>
the ( -1) and ( -2) is the divide part

Critical Thinking:

- Tinker with recurrence<br><br>
solution:
> T(n) = T(n-1) + T(n-1) + C<br>
> T(n) = 2T(n-1) + C

The problem became harder, In this case our solution is appropiate. Although when making this judgement make sure you think things through

Results in n levels, 2^n<br>
O(2^n) is the run time behaviour

---

## Day 6
### **Exercise**
> On loose leaf paper, do number 2 at home
<!-- Image Here -->

### **Recursion Tree Summary**
- create recursion tree by continuous expansion
- Come up with generalized cost per level
- Find number of levels, "How many times can I divide n by x"
- Sum up all the costs
- If done percisely, that is your solution
- I done "sloppy", verify result

How to do "sloppy":
- Change recurrence slightly, ask is runtime better or worse
  - if it is worst than you are garenteed to have the upper bound
  - if it is better you got to be very careful because it can be better
- look for dominance
  - is most of cost in top or bottom of tree
  - go with that


Algorithms:<br>
x! = sqrt(2(pi)x)*x^x*e^(-x)<br>
nLgn:<br> 
x_n+1 = x_n - (y_n/y'n)

### **Asymptotic Notation**
    => Compact and convenient way to express runtime behaviour(resource consumption, time and space, by an algorithm)
    
Big O fn(n) = O(g(n))
(/) <= f(n) <= Cg(n)

Big Omega f(n) = Big Omega(g(n))
(/) <= Cg(n) <= f(n)

Theta f(n) = Theta(g(n))

To Be Continued...

---

## Day 6
### **Proofs involving asymptotic notation**
*Proofs:*

If F(n) = 2^(n+1), then F(n) = O(2^n)<br>
(Alternative, f(n) = 2^(n+1) implies f(n) = O(2^n))<br>

Rewrite assertion:<br>
(/) <= 2^n+1 <= C2^n<br>
How do we prove?<br>
(/)<= 2 * 2^n <= C2^n<br>
C >= 2 for any N

2^2n = 2^n<br>

rewrite assertion:<br>
(/) <= 2^2n <= c2^n<br>
2^n * 2^n = 2^2n<br>
c >= 2^n

Can not hold because C is a constant and can't outrun 2^n

If F(n) = O(g(n)) then g(n) = |\_n_|(f(n))

rewrite assertion:<br>
(/) <= f(n) <= c_1 g(n)<br>
(/) <= c_2 <= g(n)

Holds for 1/c_1 = c_2

General Approach:
- Think😄
- to disprove, it takes just one example, where the assertion doesn't hold
- to prove, run the proof for the general case
- when proving:
  - rewrite assertion to mathematically precise equivelent
  - come up with creative idea to prove or disprove assertion

### **Runtime Projections**
Example: Assume n^2 algorithm (O(n^2))<br>
A concrete run over 10 elements yields a runtime of 100 seconds<br>
what is the runtime for 20 elements?<br><br>
400 seconds is the answer because 20^2 = 400<br>
T(n) = (-)(n^(c_1))<br>
T(n') = (-)(n'^(C_1)) for n' = (c_2)n<br>
T(n') = (-)((c_2n)^(c_1)) = (-)(C_2^C_1*n^C_1) = c_2^c_1T(n)

---
## After The Loss, Day 10?
