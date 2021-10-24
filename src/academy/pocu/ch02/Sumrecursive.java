package academy.pocu.ch02;

// 합계 구하기(재귀)
public class Sumrecursive {
    public static void main(String[] args) {
        int sum = sumRecursive(10);
        System.out.println(sum);

        sum = sumRecursive(100);
        System.out.println(sum);

//        큰 숫자 스택 오버플로 발생!
        sum = sumRecursive(100000);
        System.out.println(sum);
    }

//    꼬리 재귀가 아니다.
    private static int sumRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumRecursive(n - 1);
    }
}
