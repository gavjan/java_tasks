/* To solve the problem it is enough to take the complement of the given graph
*  and count the its number of components. In the solution below complement
*  of the graph is taken by taking the complete graph with the vertex count
*  and removing edges that we are asked to have.
*  --
*  The solution below uses vertex numbers from 0 to V-1 instead of 1 to V
* */
import java.util.LinkedList;
import java.util.Scanner;

class Graph {
    int V;
    LinkedList<Integer>[] adjListArray;

    // constructor
    Graph(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<Integer>();
        }
        // Make a complete graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) addEdge(i, j);
            }

        }
    }

    // Adds an edge to an undirected graph
    void addEdge(int src, int dest) {
        // Add an edge from src to dest.
        if (!adjListArray[src].contains(dest) || !adjListArray[dest].contains(src)) {
            adjListArray[src].add(dest);
            adjListArray[dest].add(src);
        }
    }
    // Removes an edge
    void removeEdge(int src, int dest) {
        if (adjListArray[src].contains(dest)) {
            adjListArray[src].removeFirstOccurrence(dest);
        }
        if (adjListArray[dest].contains(src)) {
            adjListArray[dest].removeFirstOccurrence(src);
        }
    }


    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited
        visited[v] = true;
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray[v]) {
            if (!visited[x]) DFSUtil(x, visited);
        }

    }

    int connectedComponents() {
        // Mark all the vertices as not visited
        int count = 0;
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                count++; // Upon stumbling upon an unvisited vertex we discover a new component
                DFSUtil(v, visited);
            }
        }
        return count;
    }
}

class Solution {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        Graph g = new Graph(V);
        int E = sc.nextInt();
        for (int i = 1; i <= E; i++) {
            g.removeEdge(sc.nextInt() - 1, sc.nextInt() - 1);
        }

        System.out.println(g.connectedComponents());
    }
}
