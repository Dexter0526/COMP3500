package academy.pocu.ch06;

public class Bst {

    public static void main(String[] args) {

    }

    public static Node getNodeOrNull(Node node, int data){
        if(node == null) return null;

        if(node.getData() == data) return node;

        if(data < node.getData()) return getNodeOrNull(node.getLeft(), data);

        return getNodeOrNull(node.getRight(), data);
    }

    public static Node insertNode(Node node, int data){
        if(node == null) return new Node(data);

        if(data < node.getData()) return insertNode(node.getLeft(), data);

        return insertNode(node.getRight(), data);
    }
}
