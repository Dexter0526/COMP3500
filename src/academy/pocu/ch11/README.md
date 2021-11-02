# 그래프 2

## 너비 우선 탐색
- 원래는 그래프에 사용 가능한 것
    - 트리는 특별한 제약이 있는 그래프
- 단, 방문한 노드를 기억해야 함
    - 실제로는 발견한 노드를 기억
    - 깊이 우선 탐색에서 이미 본 것
    
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