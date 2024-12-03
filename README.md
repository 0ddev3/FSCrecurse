# FSCrecurse

# Overview
This program solves four recursive problems based on user commands. Each command specifies one of the problems and includes parameters necessary for its execution. The program reads user input, processes commands using wrapper methods, and prints results to the console.

# Problems
1. MocsMath
Calculates the sum of factorials from 0 to n recursively.
Input: Single integer n.
Output: Sum of factorial values as a double.

2. MocsShape
Prints a recursive triangle pattern of stars with a specified range.
Input: Two integers, m and n (1 ≤ m ≤ n).
Output: Triangle pattern with increasing and decreasing rows of stars.

3. MocsGame
Determines if you can reduce a starting amount to exactly 42 dollars by following specific rules.
Input: Single integer n (starting dollars).
Output: true if 42 dollars can be reached; otherwise, false.

4. MocsHop
Checks if you can reach the rightmost 0 in a line of numbers by jumping according to the values on the ground.
Input: Starting position, size of the number line, and the sequence of numbers.
Output: true if the rightmost 0 can be reached; otherwise, false.

# Execution Flow
Read Input: The first line specifies the number of commands.
Process Commands: Each subsequent line contains a command and its parameters.
Wrapper Methods: Each problem has a wrapper method handling input, calling the recursive function, and printing output.

# Commands
MocsMath n
MocsShape m n
MocsGame n
MocsHop start size [numbers]
Example Command Line Usage
Copy code
4  
MocsMath 5  
MocsShape 3 5  
MocsGame 250  
MocsHop 0 10 4 4 1 5 2 6 3 4 2 0  
