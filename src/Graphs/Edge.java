package Graphs;

public class Edge {

    private String edge;
    private long weight;

    public Edge(String edge,long weight){
        this.edge = edge;
        this.weight = weight;
    }

    public String getEdge() {
        return edge;
    }

    public long getWeight() {
        return weight;
    }
}
