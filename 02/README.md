# 2. 재귀함수, 주먹구구식 알고리듬, 이진 탐색

## 재귀함수
간단한 예) 피보나치 수열
- Fn = Fn-1 + Fn-2, (n > 1)

<pre>
* 재귀 함수
public int fibonacciRecursive(int number){
    if(number <= 1) return number;

    return fibonacciRecursive(number - 2)
            + fibonacciRecursive(number - 1);
}
</pre>

<pre>
* 반복문
public int fibonacciRecursive(int number){
    if(number <= 1) return number;

    int fib = 1;
    int prev = 1;
    for(int i = 2; i < number; i++) {
        int temp = fib;
        fib += prev;
        prev = temp;
    }

    return fib;
}
</pre>

- 장점
    - 가독성이 좋음
    - 코드가 짧음
    - 각 단계의 변수 상태가 저장
    - 코드 검증 쉬움
- 단점
    - 분석 / 설계가 비직관적
    - 논리에 대한 믿음 필요
    - 스택 오버플로 발생 가능
    - 함수 호출에 따른 과부하
    
### 꼬리 호출(tail call)
- 함수 코드 제일 마지막에서 다른 함수를 호출하는 경우
- 그 후 실행 명령어가 없음

<pre>
public int calculateSignature(int[] data, int multiplier){
    int[] tempData = new int[data.length];
    for(int i = 0; i < data.length; i++){
        tempData[i] = data[i] * multiplier;
    }
    return accumulate(tempData);
}
</pre>

### 꼬리 호출과 스택 프레임
- 스택 프레임이 존재하는 이유
    - 함수에서 사용 중인 변수 값을 유지하기 위해
    - 타 함수 호출 후 반환되면 스택에 저장했던 값을 되돌려 사용
- 꼬리 호출의 경우는 타 함수로부터 반환 후 더 이상 연산이 없음
- 따라서... 스택 프레임에 저장해 놓은 변수 값을 재사용하지 않음
- 이런 경우 컴파일러가 스택 프레임을 따로 안 만드는 최적화를 하기도 함
    - 꼬리 호출 제거(tail call elimination)
    - 꼬리 호출 최적화(tail call optimization)
    - 언어따라 다름

### 꼬리 재귀
- 꼬리 호출의 특수한 경우
- 마지막에 호출하는 함수(꼬리 호출)가 자기 자신(재귀)
- 꼬리 호출과 똑같은 최적화가 적용됨

<pre>
ex) 팩토리얼 재귀 함수
int factorialRecursive(int n){
    if(n <= 1) return 1;

    return n * factorialRecursive(n - 1);
}
</pre>
** 꼬리 재귀 : Nope

Why? 마지막 함수 호출 후 종료가 아닌 변수 n을 사용하기 때문에 꼬리 재귀가 아니다.

<pre>
팩토리얼 꼬리 재귀 함수
int factorial(int n){
    return factorialRecursive(n, 1);
}

int factorialRecursive(int n, int fac){
    if(n <= 1) return fac;

    return factorialRecursive(n - 1, n * fac);
}
</pre>
** 꼬리 재귀 : Yep

Why? factorialRecursive(n - 1, n * fac); 이 코드가 마지막 실행이기 때문에 꼬리 재귀 함수다.

- 보통 꼬리 재귀 함수가 덜 직관적
- 그럼에도 작성 이유는 최적화 때문(자바는 지원 X)
- 꼬리 재귀는 반복문으로 쉽게 변경 가능!