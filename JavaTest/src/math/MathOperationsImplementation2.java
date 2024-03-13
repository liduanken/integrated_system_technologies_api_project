package math;
public class MathOperationsImplementation2 implements MathematicalOperations {

  @Override
  public int multiplyAndAdd(int[] arrayA, int[] arrayB) {
    if (arrayA.length != arrayB.length) {
      throw new IllegalArgumentException("Arrays must be of the same length");
    }

    int totalSum = 0;
    for (int i = 0; i < arrayA.length; i++) {
      if (arrayA[i] != 3 && arrayB[i] != 3) {
        totalSum += arrayA[i] * arrayB[i];
      }
    }

    return totalSum;
  }
}