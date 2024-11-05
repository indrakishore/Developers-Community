#include <stdio.h>
#include <limits.h>

#define MAXV 100
#define MAXE 100

int V, E;
int source, destination, weight;
int graph[MAXE][3];
int distance[MAXV];

void BellmanFord() {
    for (int i = 0; i < V; i++) {
        distance[i] = INT_MAX;
    }
    distance[source] = 0;

    for (int i = 1; i <= V - 1; i++) {
        for (int j = 0; j < E; j++) {
            int u = graph[j][0];
            int v = graph[j][1];
            int w = graph[j][2];
            if (distance[u] != INT_MAX && distance[u] + w < distance[v]) {
                distance[v] = distance[u] + w;
            }
        }
    }

    for (int i = 0; i < E; i++) {
        int u = graph[i][0];
        int v = graph[i][1];
        int w = graph[i][2];
        if (distance[u] != INT_MAX && distance[u] + w < distance[v]) {
            printf("Graph contains a negative-weight cycle.\n");
            return;
        }
    }

    printf("Vertex \t Distance from Source\n");
    for (int i = 0; i < V; i++) {
        printf("%d \t %d\n", i, distance[i]);
    }
}

int main() {
    printf("Enter the number of vertices: ");
    scanf("%d", &V);
    printf("Enter the number of edges: ");
    scanf("%d", &E);

    printf("Enter details of each edge (source, destination, weight):\n");
    for (int i = 0; i < E; i++) {
        scanf("%d %d %d", &source, &destination, &weight);
        graph[i][0] = source;
        graph[i][1] = destination;
        graph[i][2] = weight;
    }

    printf("Enter the source vertex: ");
    scanf("%d", &source);

    BellmanFord();

    return 0;
}
