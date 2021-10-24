package academy.pocu.ch02;

// 합계 구하기(꼬리 재귀)
public class Sumtailrecursive {
    public static void main(String[] args) {
        int sum = sumtailrecursive(10, 0);
        System.out.println(sum);

//        꼬리 재귀 최적화를 지원하면 실행(자바는 TCO를 지원하지 않으므로 스택 오버플로 발생)
//        sum = sumtailrecursive(100000, 0);
//        System.out.println(sum);
    }

    private static int sumtailrecursive(int n, int sum){
        if(n <= 0) return sum;

        return sumtailrecursive(n - 1, sum + n);
    }
}
