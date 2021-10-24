package academy.pocu.ch08;
import java.util.Stack;

public class DFS {
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
        if(node.getChildren().isEmpty()){
            System.out.println("End!!!");
            return;
        }

        
    }
}
