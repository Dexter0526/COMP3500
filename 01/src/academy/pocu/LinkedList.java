package src.academy.pocu;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList(){
        head = null;
    }

    public void add(String data){
        if(head == null){
            addFirst(data);
        }else{
            addLast(data);
        }
        this.size++;
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

        this.size++;
    }

    public void addFirst(String data){
        if(head != null){
            if(tail == null) tail = new Node(head.getData());
            Node newNode = new Node(head.getData(), head.getNode());
            head.setNode(newNode);
        }
        head.setData(data);
        this.size++;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(tail != null){
            Node preNode = new Node(tail.getData(), newNode);
            tail.setNode(preNode);
        }

        tail = newNode;


        this.size++;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean contains(String data){
        Node tempNode = head;

        while (tempNode != null){
            if(data.equals(tempNode.getData())){
                return true;
            }else{
                tempNode = tempNode.getNode();
            }
        }

        return false;
    }

    public Node get(String data){
        Node tempNode = head;

        if(tempNode == null) throw new NoSuchElementException();

        while (tempNode != null){
            if(data.equals(tempNode.getData())){
                return tempNode;
            }else{
                tempNode = tempNode.getNode();
            }
        }

        return null;
    }

    public void remove(String data){
        Node tempNode = head;
        Node preNode = null;

        if(tempNode == null) throw new NoSuchElementException();

        while (tempNode != null){
            if(data.equals(tempNode.getData())){
                preNode.setNode(null);
                size--;
                break;
            }else{
                preNode = tempNode;
                tempNode = tempNode.getNode();
            }
        }

    }

    public void remove(){
        Node tempNode = head;
        Node preNode = null;

        if(tempNode == null) throw new NoSuchElementException();
        if(tail == null) this.head = null;

        while (tempNode != null){
            preNode = tempNode;
            tempNode = tempNode.getNode();
        }

        preNode.setNode(null);
    }



}
