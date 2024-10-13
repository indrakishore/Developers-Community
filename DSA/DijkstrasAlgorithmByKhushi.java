/*
    Approach:
    1. Create an adjacency list to represent the weighted graph.
    2. Initialize distances from the source node to all other nodes as infinity, except for the source itself, which is zero.
    3. Utilize a priority queue to always process the node with the smallest distance next.
    4. For each neighboring node, calculate the potential new distance and update if it's smaller than the current known distance.
    5. Repeat until all nodes are processed.
*/

import java.util.*;

class Dijkstra {

    // Class to represent a node in the graph
    static class GraphNode {
        int vertex, weight;

        // Constructor to initialize the node's vertex and the weight of the edge
        GraphNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Dijkstra's Algorithm implementation
    public static void dijkstraAlgorithm(List<List<GraphNode>> graph, int source) {
        int n = graph.size();  // Number of nodes in the graph
        int[] distances = new int[n];  // Array to store shortest distances from the source
        Arrays.fill(distances, Integer.MAX_VALUE);  // Initialize all distances to infinity
        distances[source] = 0;  // Distance to the source is 0

        // PriorityQueue to select the node with the smallest distance (min-heap)
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new GraphNode(source, 0));  // Add the source node to the queue

        // While there are nodes left to process
        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();  // Get the node with the smallest distance
            int u = current.vertex;

            // Explore all neighbors of the current node
            for (GraphNode neighbor : graph.get(u)) {
                int v = neighbor.vertex;  // Neighboring node
                int newDist = distances[u] + neighbor.weight;  // Calculate new tentative distance

                // If the new distance is shorter, update it and push the neighbor into the queue
                if (newDist < distances[v]) {
                    distances[v] = newDist;  // Update distance
                    pq.add(new GraphNode(v, newDist));  // Add updated node to the queue
                }
            }
        }

        // After processing all nodes, print the shortest distances
        printShortestPaths(distances, source);
    }

    // Function to print the shortest paths from the source node
    private static void printShortestPaths(int[] distances, int source) {
        System.out.println("Shortest paths from node " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int nodes = 5;  // Number of nodes in the graph

        // Creating an adjacency list for the graph
        List<List<GraphNode>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());  // Initialize empty list for each node
        }

        // Adding edges (vertex, weight) to the graph
        graph.get(0).add(new GraphNode(1, 9));
        graph.get(0).add(new GraphNode(2, 6));
        graph.get(0).add(new GraphNode(3, 5));
        graph.get(0).add(new GraphNode(4, 3));
        graph.get(2).add(new GraphNode(1, 2));
        graph.get(2).add(new GraphNode(3, 4));

        // Run Dijkstra's algorithm from source node 0
        dijkstraAlgorithm(graph, 0);
    }
}
