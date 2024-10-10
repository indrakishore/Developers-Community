// Dijkstra’s Algorithm Implementation

// Problem Statement:
// Given a weighted graph represented as an adjacency matrix and a source vertex,
// the task is to find the shortest paths from the source vertex to all other vertices
// in the graph. This is achieved using Dijkstra’s algorithm, which efficiently computes
// the shortest path from a single source to all other vertices in a graph with non-negative weights.

import java.io.*;
import java.lang.*;
import java.util.*;

class ShortestPath {
    static final int V = 9;  // Number of vertices in the graph

    // Function to find the vertex with the minimum distance value from the set of vertices
    // not yet included in the shortest path tree (SPT)
    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        // Iterate through all vertices to find the minimum distance vertex
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;  // Update min_index
            }

        return min_index;  // Return the vertex index with the minimum distance
    }

    // Function to print the constructed distance array
    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path algorithm
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];  // Output array dist[i] holds the shortest distance from src to i

        Boolean sptSet[] = new Boolean[V];  // sptSet[i] will be true if vertex i is included in the SPT

        // Initialize all distances as infinite and sptSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;  // Distance from source to itself is always 0

        // The main loop to find the shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);  // Pick the minimum distance vertex from the set of vertices not processed

            sptSet[u] = true;  // Mark the picked vertex as processed

            // Update dist value of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0
                    && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];  // Update the distance if shorter path is found
        }

        printSolution(dist);  // Print the shortest distances from the source
    }

    public static void main(String[] args) {
        // Representation of the input graph using an adjacency matrix
        int graph[][] = new int[][] {
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);  // Call the dijkstra method with the graph and source vertex
    }
}
