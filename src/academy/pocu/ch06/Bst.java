package academy.pocu.ch06;

public class Bst {

    public static void main(String[] args) {
        Node root = new Node(50);

        insertNode(root, 24);
        insertNode(root, 42);
        insertNode(root, 33);
//        insertNode(root, 34);
        insertNode(root, 22);
        insertNode(root, 19);

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
        System.out.println(num);

        deleteNode(root, 24, null);

        System.out.println("after delete ::: " + getNodeOrNull(root, 50).getLeft().getLeft().getData());
    }

    public static Node getNodeOrNull(Node node, int data){
        if(node == null) return null;

        if(node.getData() == data) return node;

        if(data < node.getData()) return getNodeOrNull(node.getLeft(), data);

        return getNodeOrNull(node.getRight(), data);
    }

//    부모 노드 찾기
    public static Node getParentNodeOrNull(Node node, int data){
        if(node == null) return null;

        if(node.getRight().getData() == data) return node;
        else if(node.getLeft().getData() == data) return node;

        if(data < node.getData()) return getParentNodeOrNull(node.getLeft(), data);

        return getParentNodeOrNull(node.getRight(), data);
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
    
    public static Node deleteNode(Node node, int data, Node parentNode){
        if(parentNode == null){
            parentNode = getParentNodeOrNull(node, data);

            if(parentNode.getLeft() != null && parentNode.getLeft().getData() == data){
                if(parentNode.getLeft().getLeft() == null){
                    parentNode.setLeft(parentNode.getLeft().getRight());
                    return parentNode;
                }else{
                    deleteNode(parentNode.getLeft().getLeft(), data, parentNode);
                }

            }else if(parentNode.getRight() != null && parentNode.getRight().getData() == data){
                if(parentNode.getRight().getLeft() == null){
                    parentNode.setRight(parentNode.getRight().getRight());
                    return parentNode;
                }else{
                    deleteNode(parentNode.getRight().getLeft(), data, parentNode);
                }

            }

            return null;
        }

        if(node.getRight() == null) {

            if(parentNode.getLeft() != null && parentNode.getLeft().getData() == data){
                parentNode.getLeft().setData(node.getData());
            }else if(parentNode.getRight() != null && parentNode.getRight().getData() == data){
                parentNode.getRight().setData(node.getData());
            }

            if(node.getLeft() != null){
                node.setData(node.getLeft().getData());
                node.setRight(node.getLeft().getRight());
                node.setLeft(node.getLeft().getLeft());
            }

            return parentNode;
        }
        return deleteNode(node.getRight(), data, parentNode);
    }
}
