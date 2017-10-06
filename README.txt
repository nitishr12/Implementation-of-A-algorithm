Nitish Rangarajan
800963268
8-Puzzle Problem Formation:
The 8-Puzzle problem is a puzzle invented and popularized by Noyes Palmer Chapman in the 1870s. It is played on a 3-by-3 grid with 8 square blocks labelled 1 through 8 and a blank square (Zero in our case). The goal is to rearrange the blocks of a given input state so that they are equal to the goal state. The blocks can be moved either horizontally (left or right) or vertically (up or down) into the blank square. The following shows a sequence of feasible moves from an starting state to the final state.


Input State: 
123
456
780


The Output state
023
145
786  
Program Structure:
1. Get the input and the output states
2. Find the zero in the input state(where one can swap).
3. Swap all the possibilities and take the one with the least heuristic and do a recursive call with the state.
   1. Generate multiple states which is the operation done by swapping.
   2. Store the previously visited states.
   3. Check if the state has been visited already
      1. If yes, skip
      2. If no, then find the heuristic
         1. Find the state with the least f(n)
f(n)=g(n)+h(n)
Where n - current state
h(n) - heuristic
g(n) - cost
         1. Pass the state to the checkState function to do a recursive call.  
1. If the state is equal to the final state, stop and print the iterations.


Functions Used:
1. CheckState(state, iterations) - Computes the different possible states, checks if visited, computes heuristic and ends in a recursion using the state with least heuristic value.         
Global Variables:
1. Static inputState - The input state from the console
2. Static OutputState - The output state from the console
3. newStateA - One of the four possible states on swapping
4. newStateB - One of the four possible states on swapping
5. newStateC - One of the four possible states on swapping
6. newStateD - One of the four possible states on swapping
7. Static states - The list of states traversed
Other variables:
1. Heuristics - HashMap containing the state name with the heuristic value of the state


Execution Results(Console Output):


Enter the input state one by one
1
2
3
4
5
6
7
8
0
Enter the output state one by one
0
2
3
1
4
5
7
8
6
The Input state
123
456
780
The Output state
023
145
786
In iteration 1
StateC
123
450
786
StateD
123
456
708
[{A=100, B=100, C=3, D=5}]
The least heuristic value 3
Stored States Size 3
In iteration 2
StateA
123
456
780
The state is already visited
StateC
120
453
786
StateD
123
405
786
[{A=100, B=100, C=4, D=2}]
The least heuristic value 2
Stored States Size 5
In iteration 3
StateA
123
485
706
StateB
123
450
786
StateC
103
425
786
StateD
123
045
786
[{A=3, B=3, C=3, D=1}]
The least heuristic value 1
Stored States Size 9
In iteration 4
StateA
123
745
086
StateB
123
405
786
StateC
023
145
786
[{A=2, B=2, C=0, D=100}]
The least heuristic value 0
Stored States Size 12
Final State Reached at iteration 4




# of nodes generated: 13(using the number of states)
# of nodes expanded:  4 (Including the node in the input state)