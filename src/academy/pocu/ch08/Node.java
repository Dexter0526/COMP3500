package academy.pocu.ch08;

import java.util.List;

public class Node {
    private int data;
    private List<Node> children;

    public Node(){

    }

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
