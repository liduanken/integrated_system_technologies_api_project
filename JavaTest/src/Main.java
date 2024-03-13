import math.MathOperationsImplementation;
import math.MathOperationsImplementation2;
import math.MathematicalOperations;

public class Main {

    public static void main(String[] args) {

        int[] arrayA = {1,8,5,4,6,3,2,3,7,10};
        int[] arrayB = {2,3,4,8,7,2,3,1,4,9};

        /*
        Q1
        Calculate the dot product of arrayA and arrayB
         */
        MathematicalOperations op1 = new MathOperationsImplementation();
        int sum = op1.multiplyAndAdd(arrayA, arrayB);
        System.out.printf("Total sum: %d\n", sum);
        /*
        Q2
        Calculate the dot product of arrayA and arrayB, this time remove
         all occurrences of the number 3 before calculating it.
         */
        MathematicalOperations op2 = new MathOperationsImplementation2();
        int sum2 = op2.multiplyAndAdd(arrayA, arrayB);
        System.out.printf("Total sum after removing 3: %d\n", sum2);

    }
}