package academy.pocu.ch08;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void searchBreadthFirst(Node root){
        Queue<Node> queue = new LinkedList();

        queue.add(root);

        while (!queue.isEmpty()){
            Node next = queue.remove();

            System.out.println(next.getData());

            for(Node child : next.getChildren()){
                queue.add(child);
            }
        }

    }
}
