# 그래프 2

## 너비 우선 탐색
- 원래는 그래프에 사용 가능한 것
    - 트리는 특별한 제약이 있는 그래프
- 단, 방문한 노드를 기억해야 함
    - 실제로는 발견한 노드를 기억
    - 깊이 우선 탐색에서 이미 본 것
- 시간 복잡도 : O(N + E)
    
```
public static void searchBreadthFirst(Node node){
    HashSet<Node> discovered = new HashSet<>();
    Queue<Node> queue = new LinkedList<>();
    
    queue.add(node);
    discovered.add(node);
    
    while(!queue.isEmpth()){
        Node next = queue.remove();
        System.out.println(next.data + " ");
        
        for(Node neighbor : next.neighbors){
            if(!discovered.contains(neighbor)) {
                queue.add(neighbor);
                discovered.add(next);
            }
        }
    }
}
```

### 최단 경로 찾기(shortest path)
![img.png](img/img.png)
- 집에서 학교로 가는 길
- 각 변은 두 노드를 연결하는 도로를 의미
- 학교로 가는 경로는 여러 가지
- 사실 순환(cycle)이 있기네 경로는 무한
- 가장 간단한 방법은 주먹구구식
    - 모든 가능한 조합을 만든 뒤, 그중 가장 짧은 것을 선택
    - 단, 순환이 없게끔 해야함
- 하지만 이 방법은 엄청난 시간 복잡도
- BFS를 사용하면 최단 경로를 찾을 수 있음
    - 시간 복잡도도 O(N+E)
- 기본적인 BFS와 크게 다르지 않음
- 그러나 시작점부터 현재 노드까지의 거리를 기억해야 함
    - 거리 = BFS 깊이
- 저장법은 여러 가지
    - 해시 맵에 모든 노드의 거리를 저장
    - 2D 배열로 저장(인접 행렬과 비슷)
    - 각 노드 안에 거리를 저장(BFS를 실행하기 전에 리셋)

```
public static int findShortestDistance(Node s, Node d){
    HashMap<Node, Integer> distances = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    
    queue.add(s);
    distances.put(s, 0);
    
    while(!queue.isEmpth()){
        Node next = queue.remove();
        int distance = distances.get(next);
        
        if(next.equals(d)){
            return distance;        
        }
        
        for(Node neighbor : next.neighbors){
            if(!distances.containsKey(neighbor)) {
                queue.add(neighbor);
                distances.put(neighbor, distance + 1);
            }
        }
    }
    
    return -1;
}
```

- 최종 노드부터 반대 방향으로 추적
- 추적을 위해 추가 정보 필요
    - 선행 노드 : '누가 나를 큐에 넣었는가?'
    - 큐에 다음 노드를 넣을 때 선행 노드도 같이 기재
- 정보 저장 방법은 여러 가지
    - 해시 맵에 기억
    - 노드 속에 선행 노드를 기억 (BFS 실행 전에 이 값을 리셋해줘야 함)
    - ...
    
## 다익스트라 알고리즘
![img.png](img/img_1.png)
- 두 노드 사이의 최단 경로를 찾음
- 방대한 노드 네트워크에 사용하기 충분히 빠름
- 변의 가중치가 음수인 경우에는 제대로 작동하지 않음
- 실세계에서 많이 사용
    - 지도/내비게이션
    - IP라우팅
    - 경유 항공편 찾기
    - ...
    
### 다익스트라 알고리즘의 기초
- 모든 노드를 한번씩 방문하며 아래의 연산을 함
    1. 아직 방문 안한 노드 중 가장 가까운 노드 n을 선택
    2. n의 각 이웃 노드 m으로 여행하는 거리를 계산(n의 거리 + n -> m의 거리)
    3. 이 결과가 m의 기존 거리보다 가까우면 m의 거리를 업데이트
- 모든 노드를 방문하면 최단 거리를 찾음
    - 모든 노드를 거쳐 온 경로 중 최솟값을 취했기 때문
    
### 알고리즘
1. 아직 방문 안 한 노드 중 가장 거리 값이 작은 노드 n을 선택
2. n의 가장 미방문 이웃 m으로 가는 더 짧은 경로가 있다면 업데이트
3. 다음 조건 중 하나를 만족하기 전까지 1~2를 반복
    - 모든 노드를 방문했음
    - n이 목적지임
4. 목적지까지의 거리/경로를 반환

#### 인접 행렬로 표현한 그래프
![img.png](img/img_2.png)


