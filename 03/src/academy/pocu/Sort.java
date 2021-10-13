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

        numbers = new int[]{1, 4, 3, 1, 2, 0};
        insertionSort(numbers);
        System.out.println("삽입 정렬 ::: " + Arrays.toString(numbers));

        numbers = new int[]{1, 4, 3, 1, 2, 0};
        quickSort(numbers);
        System.out.println("퀵 정렬 ::: " + Arrays.toString(numbers));

        numbers = new int[]{1, 4, 3, 1, 2, 0};
        mergeSort(numbers);
        System.out.println("병합 정렬 ::: " + Arrays.toString(numbers));
    }

//    버블 정렬
    public static void bubbleSort(int[] numbers){
        int count = 0;
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - i - 1; j++){
                if(numbers[j] > numbers[j + 1]){
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                    count++;
                }
            }
        }
        System.out.println("count:::" + count);
    }

//    선택 정렬
    public static void selectionSort(int[] numbers){
        int count = 0;
        for(int i = 0; i < numbers.length - 1; i++){
            int min = numbers[i];
            int index = i;
            for(int j = i + 1; j < numbers.length; j++){
                if(min > numbers[j]) {
                    min = numbers[j];
                    index = j;
                    count++;
                }
            }
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }
        System.out.println("count:::" + count);
    }

//    삽입 정렬
    public static void insertionSort(int[] numbers){
        int count = 0;
        for(int i = 0; i < numbers.length; i++){
            int index = i;
            while (index > 0 && numbers[index] < numbers[index - 1]){
                int temp = numbers[index - 1];
                numbers[index - 1] = numbers[index];
                numbers[index] = temp;

                index--;
                count++;
            }
        }
        System.out.println("count:::" + count);
    }

//    퀵 정렬
    public static void quickSort(int[] numbers){
        quickSortRecursive(numbers, 0, numbers.length - 1);
    }

    public static void  quickSortRecursive(int[] numbers, int left, int right){
        if(left >= right) return;
//        정렬
        int pivotPos = partition(numbers, left, right);

//        좌
        quickSortRecursive(numbers, left, pivotPos - 1);
//        우
        quickSortRecursive(numbers, pivotPos + 1, right);
    }

//    로무토(Lomuto) 분할법
    public static int partition(int[] numbers, int left, int right){
        int pivot = numbers[right];

        int i = left - 1;
        for(int j = left; j < right; j++){
            if(numbers[j] < pivot){
                i++;
                swap(numbers, i, j);
            }
        }
        int pivotPos = i + 1;
        swap(numbers, pivotPos, right);

        return pivotPos;
    }

//    호어(Hoare) 분할법 (작성)


    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = temp;
    }

    public static int[] sorted;
//    병합 정렬
    public static void mergeSort(int[] numbers){
        sorted = new int[numbers.length];

        mergeSortRecursive(numbers, 0, numbers.length - 1);
        sorted = null;
    }

    public static void mergeSortRecursive(int[] numbers, int left, int right){
        if(left == right) return;

        int mid = (left + right) / 2;

        mergeSortRecursive(numbers, left, mid);
        mergeSortRecursive(numbers, mid + 1, right);

        merge(numbers, left, right, mid);
    }

    public static void merge(int[] numbers, int left, int right, int mid){
        int i, j, k, start, end;
        i = left;
        j = left;
        k = mid + 1;

//        i : 좌, k : 우
        while (i <= mid && k <= right){
            if(numbers[i] <= numbers[k]){
                sorted[j++] = numbers[i++];
            }else{
                sorted[j++] = numbers[k++];
            }
        }

        if(i > mid){
            start = k;
            end = right;
        }else{
            start = i;
            end = mid;
        }

        for(int l = start; l <= end; l++){
            sorted[j++] = numbers[l];
        }

        for(int l = left; l <= right; l++){
            numbers[l] = sorted[l];
        }

    }
}
