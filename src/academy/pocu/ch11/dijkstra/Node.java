package academy.pocu.ch11.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private final String name;
    private final HashMap<Node, Integer> roads = new HashMap<>();

    public Node(final String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public HashMap<Node, Integer> getRoads() {
        return roads;
    }

    public void addRoad(final Node to, final int dist){
        this.roads.put(to, dist);
    }

    public int getDistance(final Node to){
        return this.roads.get(to);
    }
}
