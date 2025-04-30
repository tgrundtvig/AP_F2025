package ap_f2025.graphs;

public interface Node
{
    String getName();
    Iterable<Edge> getOutgoingEdges();
    Iterable<Node> getNeighbors();
}
