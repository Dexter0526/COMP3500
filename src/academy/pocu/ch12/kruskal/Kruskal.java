package academy.pocu.ch12.kruskal;

import java.util.ArrayList;
import java.util.Arrays;

public class Kruskal {
    private Kruskal() {
    }

    public static ArrayList<Edge> run(final String[] nodes, final Edge[] edges) {
        DisjointSet set = new DisjointSet(nodes);

        ArrayList<Edge> mst = new ArrayList<>(edges.length);

        Arrays.sort(edges);

        for (int i = 0; i < edges.length; ++i) {
            String n1 = edges[i].getNode1();
            String n2 = edges[i].getNode2();

//            node1, node2의 root 찾기
            String root1 = set.find(n1);
            String root2 = set.find(n2);

            if (!root1.equals(root2)) {
                mst.add(edges[i]);
                set.union(n1, n2);
            }
        }

        return mst;
    }
}
