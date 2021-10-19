package academy.pocu.ch01;

public class Application {
    public static void main(String[] args) {
        System.out.println("This is run");
    }

    //    코드1
    /*
     *시간 복잡도 : O(1)
     * */
    public int add1(int num1, int num2){
        return num1 + num2;
    }

    //    코드2
    /*
     * 시간 복잡도 : O(N)
     * */
    public int add2(int num1, int num2){
        int sum = num1;
        for(int i = 0; i < num2; ++i){
            ++sum;
        }
        return sum;
    }
}

