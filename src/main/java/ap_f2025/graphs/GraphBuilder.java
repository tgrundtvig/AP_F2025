package ap_f2025.graphs;

public interface GraphBuilder
{
    Node createNode(String name);
    Edge createEdge(Node begin, Node end, double weight);
    Graph createGraph();
}
