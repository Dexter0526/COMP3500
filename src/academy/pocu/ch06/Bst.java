package academy.pocu.ch06;

public class Bst {

    public static void main(String[] args) {
        Node root = new Node(50);

        insertNode(root, 24);
        insertNode(root, 42);
        insertNode(root, 33);
        insertNode(root, 22);

        insertNode(root, 55);
        insertNode(root, 52);
        insertNode(root, 57);

        int num = root.getData();
        System.out.println(num);

        num = root.getLeft().getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getRight().getData();
        System.out.print(num);

        System.out.println();

        num = root.getLeft().getLeft()
                .getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getLeft().getRight()
                .getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getRight().getLeft()
                .getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getRight().getRight()
                .getData();
        System.out.print(num);

        System.out.println();

        num = root.getLeft().getRight()
                .getLeft().getData();
        System.out.print(num);

        System.out.println();

        insertNode(root, 53);

        num = root.getRight().getLeft()
                .getRight().getData();
        System.out.print(num);
    }

    public static Node getNodeOrNull(Node node, int data){
        if(node == null) return null;

        if(node.getData() == data) return node;

        if(data < node.getData()) return getNodeOrNull(node.getLeft(), data);

        return getNodeOrNull(node.getRight(), data);
    }

    public static Node insertNode(Node node, int data){
        if(node == null) return new Node(data);

        if(data < node.getData()) {
            node.setLeft(insertNode(node.getLeft(), data));
        }else{
            node.setRight(insertNode(node.getRight(), data));
        }

        return node;
    }
}
