// Name: Yvette Boyd
// Email: ev3boyd@gmail.com
// Section Number: 002
// Assignment Title: Program 3
// ID: 1301169
// Date: 10/7/1014


import java.util.*;
import java.text.DecimalFormat;

public class FSCrecurse {

    // Wrapper method for MocsMath
    public static void MocsMath(Scanner in) {
        // scan the input from the input gathered
        int n = in.nextInt();

        System.out.print("MocsMath:");

        // Now call the actual recursive MocsMath method (send the right parameters)
        double recursiveSum = MocsMathRecursive(n);
        // use decimal format to get rid of the . within the numbers
        DecimalFormat decimalformat = new DecimalFormat("0.#");

        // Finally, print  the result:
        System.out.print("  " + decimalformat.format(recursiveSum));
        System.out.println("");
        System.out.println("");

    }

    // Recursive sum method to sum up all the factorials
    public static double MocsMathRecursive(int n) {
        // base case: if n is 0
        if (n == 0) {
            // exit out the loop 
            return 1;
        } else {
            // its not 0, return the factorial of n PLUS n - 1
            return factorial(n) + MocsMathRecursive(n - 1);
        }
    }

    // Recursive factorial method
    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Wrapper method for MocsShape
    public static void MocsShape(Scanner in) {
        // scan the input from the input gathered
        int m = in.nextInt();
        int n = in.nextInt();

        System.out.println("MocsShape:");

        // now call the actual recursive method (send over the right parameters)
        MocsShapeRecursive(m, n);

        // finally, print the result
        System.out.println("");

    }

    // Recursive method for printing the triangle
    public static void MocsShapeRecursive(int m, int n) {
        // Base case for the ascending part
        if (m > n) {
            return;
        }

        // Print the current row of stars for the ascending part
        for (int i = 0; i < m; i++) {
            System.out.print("* ");
        }
        System.out.println();

        // Recursive call to print the next row with one more star
        MocsShapeRecursive(m + 1, n);

        // Print the current row of stars for the descending part
        for (int i = 0; i < m; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    // Wrapper method for MocsGame
    public static void MocsGame(Scanner in) {
        // Read the starting amount of money
        int n = in.nextInt();

        // Call the recursive method starting with n dollars
        boolean canWin = MocsGameRecursive(n);

        // Print the result
        if (canWin == true) {
            System.out.println("MocsGame:  Solvable");
            System.out.println("");
        } else {
            System.out.println("MocsGame:  Not Solvable");
            System.out.println("");
        }

    }

    // Recursive method for MocsGame
    public static boolean MocsGameRecursive(int n) {
        // Base case: If we have exactly 42 dollars, we win
        if (n == 42) {
            return true;
        }

        // If we have less than 42 dollars, we cannot win (return false)
        if (n < 42) {
            return false;
        }

        // Rule 1: If n is even, return n / 2 dollars
        if (n % 2 == 0) {
            if (MocsGameRecursive(n / 2)) {
                return true;
            }
        }

        // Rule 2: If n is divisible by 3 or 4, return the product of the last two digits
        if (n % 3 == 0 || n % 4 == 0) {
            int lastDigit = n % 10;
            int secondLastDigit = (n % 100) / 10;
            int product = lastDigit * secondLastDigit;

            //product needs to be greater than 0
            if (product > 0 && MocsGameRecursive(n - product)) {
                return true;
            }
        }

        // Rule 3: IF n is divisible by 5, return 42 dollars
        if (n % 5 == 0) {
            if (MocsGameRecursive(n - 42)) {
                return true;
            }
        }

        // IF no rule leads to a win, return FALSE
        return false;
    }

    // Wrapper method for MocsHop
    public static void MocsHop(Scanner in) {
        // Read the entire input as a single line
        String gameInput = in.nextLine();

        // Split the input by spaces
        String[] inputs = gameInput.split(" ");

        // The first value is the game type, which we ignore
        String GameType = inputs[0]; // For reference, but we don't use this

        // The second value is the start position
        int Start = Integer.parseInt(inputs[1]);

        // The third value is the size of the array
        int size = Integer.parseInt(inputs[2]);

        // Create an array to store the integers drawn on the ground
        int[] nums = new int[size];

        // Loop over the rest of the inputs, starting at index 3 (where the number line begins)
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(inputs[i + 3]);  // Convert each string to an integer
        }

        // Start the game from the given starting position
        boolean canSolve = MocsHopRecursive(nums, Start, new boolean[size]);

        // Print the result
        if (canSolve) {
            System.out.println("MocsHop:  Solvable");
            System.out.println("");
        } else {
            System.out.println("MocsHop:  Not Solvable");
            System.out.println("");
        }
    }

    // Recursive method to determine if we can reach the 0
    public static boolean MocsHopRecursive(int[] nums, int currentIndex, boolean[] visited) {
        // Base case: if we are at an index with value 0, return true
        if (nums[currentIndex] == 0) {
            // return true
            return true;
        }

        // Mark the current index as visited
        visited[currentIndex] = true;

        // Get the value at the current position (how far we can jump)
        int jumpLength = nums[currentIndex];

        // Try jumping right
        int rightIndex = currentIndex + jumpLength;
        // if the right index is less than the length of the array
        if (rightIndex < nums.length && !visited[rightIndex]) {
            // call the method and true true
            if (MocsHopRecursive(nums, rightIndex, visited)) {
                return true;
            }
        }

        // Try jumping left
        int leftIndex = currentIndex - jumpLength;
        // if the index to the left is >= 0 and it has not been visited
        if (leftIndex >= 0 && !visited[leftIndex]) {
            // return true
            if (MocsHopRecursive(nums, leftIndex, visited)) {
                return true;
            }
        }

        // If neither left nor right worked, return false
        return false;
    }

    public static void main(String[] args) {
        // Make the variables
        Scanner input = new Scanner(System.in);
        int numCommands;
        String command;

        // Scan the # of commands from the file 
        numCommands = input.nextInt();

        // Now loop over the number of commands
        for (int i = 0; i < numCommands; i++) {
            // Scan the next command from the input file
            command = input.next();

            // Now check which command was read, and call the appropriate methods
            // Command: MocsMath
            if (command.equals("MocsMath")) {
                // We are calling the wrapper methods first
                MocsMath(input);
            } // Command: MocsShape
            else if (command.equals("MocsShape")) {
                // We call the WRAPPER method fibValue()
                MocsShape(input);
            }// Command: MocsGame 
            else if (command.equals("MocsGame")) {
                MocsGame(input);
            }// Command: MocsHop  
            else if (command.equals("MocsHop")) {
                MocsHop(input);
            } // for the wrong choice
            else {
                // do nothing

            }
        }
    }

}
