package src.academy.pocu;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        head = null;
    }

    public void add(String data){
        if(head == null){
            addFirst(data);
        }else{
            addLast(data);
        }
    }

    public void add(String data, Node preNode){
        Node newNode = new Node(data);

        if(preNode.getNode() == null){
            preNode.setNode(newNode);
            this.tail = newNode;
        }else{
            newNode.setNode(preNode.getNode());
            preNode.setNode(newNode);
        }

        size++;
    }

    public void addFirst(String data){
        if(head != null){
            Node newNode = new Node(head.getData(), head.getNode());
            head.setNode(newNode);
        }
        this.head.setData(data);
        size++;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(tail != null){
            Node preNode = new Node(tail.getData(), newNode);
        }
        tail = newNode;


        size++;
    }

    public void clear(){

    }

    public boolean contains(){
        return false;
    }

    public Node get(){
        return null;
    }

    public void remove(){

    }



}
