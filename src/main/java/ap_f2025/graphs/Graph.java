package ap_f2025.graphs;

public interface Graph
{
    Iterable<Node> getNodes();
    Iterable<Edge> getEdges();
    Node getNode(String name);
    Edge getEdge(Node begin, Node end);
}
