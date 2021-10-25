# 9. 동적 계획법, 그리디 알고리즘

## 동적 계획법(dynamic programming, dp)
- 특별한 속성을 가진 복잡한 문제를 푸는 방법
- 복잡한 문제를 그보다 단순한 하위 문제로 나눠서 풂
  - 재귀적
  - 가장 단순한 문제 + 1은 그 다음으로 단순한 문제
  - 이걸 반복하면 원래의 복잡한 문제까지 해결
- 당연히 모든 문제를 이렇게 풀 수는 없음
  - 특별한 속성이 필요
  
### 배낭(knapsack) 문제
- 크기와 가격이 다른 여러 물품이 있음
- 값어치가 최대가 되도록 물건 넣기
- 당연히 배낭에는 크기 제한이 있음
- 판정 버전은 약한 NP-완전 문제
  - "최소 어떤 값어지 V만큼 넣을 수 있는가?"
  - 의사 다항식 시간 안에 풀 수 있음
- 시간 복잡도 : O(2^n)

### 메모이제이션(memoization)
- 계산 결과를 캐시에 저장해 둔 뒤, 나중에 재사용하는 기법
  - **처음 계산할 때 그 결과를 캐시에 저장**
  - 나중에 동일한 계산을 다시 하는 대신 저장해둔 값을 가져다 씀
  - 값비싼 계산(예: 깊은 재귀 호출)에 적합
  - 최적화 기법 중 하나, 캐싱 기법 중 하나
- 보통 함수가 매개변수에 따라 반환하는 값을 캐싱하는 것을 지칭
- 컴퓨터 프로그래밍에서만 사용하는 용어

```
메모이제이션을 사용한 피보나치 함수
public static int fibonacciRecursive(int number, int[] cache){
  if(number <= 1){
    return number;
  }
  
  if(cache[number] != 0){
    return cache[number];
  }
  
  int ret = fibonacciRecursive(number - 2, cache)
              + fibonacciRecursive(number - 1, cache);
  cache[number] = ret;
  
  return ret;
}
```
  