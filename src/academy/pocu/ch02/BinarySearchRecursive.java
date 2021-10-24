package academy.pocu.ch02;

// 이진 탐색(재귀)
public class BinarySearchRecursive {
    static int count = 0;

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9,13,44};
        int answer = binarySearchRecursive(nums, 0, nums.length, 6);
        System.out.println(answer);
        System.out.println("Count:::" + count);
    }

//    l : 시작점, r : 끝점
    public static int binarySearchRecursive(int nums[], int l, int r, int value){
        count++;
        int m = (l + r) / 2;
        if(nums[m] == value) return m;

        return value < nums[m] ? binarySearchRecursive(nums, l, m - 1, value) : binarySearchRecursive(nums, m + 1, r, value);
    }
}
