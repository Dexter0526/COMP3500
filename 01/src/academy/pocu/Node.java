package src.academy.pocu;

public class Node {
    private String data;
    private Node node;

    public Node(){

    }

    public Node(String data){
        this.data = data;
    }

    public Node(String data, Node node){
        this.data = data;
        this.node = node;
    }

    public String getData(){
        return this.data;
    }

    public Node getNode(){
        return this.node;
    }

    public void setData(String data){
        this.data = data;
    }

    public void setNode(Node node){
        this.node = node;
    }
}
