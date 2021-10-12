package src.academy.pocu;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] numbers = {1,4, 3, 1, 2, 0};
        bubbleSort(numbers);
        System.out.println("버블 정렬 ::: " + Arrays.toString(numbers));

        numbers = new int[]{1, 4, 3, 1, 2, 0};
        selectionSort(numbers);
        System.out.println("선택 정렬 ::: " + Arrays.toString(numbers));
    }

//    버블 정렬
    public static void bubbleSort(int[] numbers){
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - i - 1; j++){
                if(numbers[j] > numbers[j + 1]){
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] numbers){
        for(int i = 0; i < numbers.length - 1; i++){
            int min = numbers[i];
            int index = i;
            for(int j = i + 1; j < numbers.length; j++){
                if(min > numbers[j]) {
                    min = numbers[j];
                    index = j;
                }
            }
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }
    }
}
