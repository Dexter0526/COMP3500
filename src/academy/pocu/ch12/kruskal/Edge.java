package academy.pocu.ch12.kruskal;

public class Edge implements Comparable<Edge> {
    private final String node1;
    private final String node2;
    private final int weight;

    public Edge(final String node1, final String node2, final int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getNode1() {
        return node1;
    }

    public String getNode2() {
        return node2;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
