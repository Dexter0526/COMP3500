package academy.pocu.ch03;

import java.util.Arrays;
import java.util.Random;

// 배열의 최소 차이 찾기
public class Minimumdiff {
    public static void main(String[] args) {
        Random random = new Random(512);

        int[] numbers = new int[15];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }

        System.out.println("numbers ::: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("numbers ::: " + Arrays.toString(numbers));

        int minDiff = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i < numbers.length - 1; i++) {
            int diff = Math.abs(numbers[i] - numbers[i + 1]);

            if (diff < minDiff) {
                minDiff = diff;
                num1 = numbers[i];
                num2 = numbers[i + 1];
            }
        }

        System.out.println("Minimum diff ::: " + "Number 1 = " + num1 + ", Number 2 = " + num2);
    }

}
