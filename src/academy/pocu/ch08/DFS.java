package academy.pocu.ch08;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {

    }

    public static void searchDepthFirst(Node root){
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            Node next = stack.pop();

            System.out.println(next.getData());

            for (Node child : next.getChildren()){
                stack.push(child);
            }
        }
    }

    public static void searchDepthRecursive(Node node){
        System.out.println("방문한 노드 ::: " + node.getData());
        List<Node> children = node.getChildren();

        if(children.isEmpty()){
            System.out.println("End!!!");
            return;
        }

        for(Node child : children){
            searchDepthRecursive(child);
        }
    }
}
