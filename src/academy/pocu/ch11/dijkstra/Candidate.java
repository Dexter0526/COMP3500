package academy.pocu.ch11.dijkstra;

public class Candidate implements Comparable<Candidate>{
    private final Node node;
    private final int distance;

    public Candidate(final Node node, final int distance){
        this.node = node;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Node getNode() {
        return node;
    }

    @Override
    public int compareTo(Candidate o){
        return this.distance - o.distance;
    }
}
