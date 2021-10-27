
// Java program to check if a connected 
// graph is bipartite or not suing DFS 
import java.util.*;

class Bipartite {

    // Function to store the connected nodes
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Function to check whether a
    // graph is bipartite or not
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int v, boolean visited[], int color[]) {
        for (int u : adj.get(v)) {

            // If vertex u is not explored before
            if (visited[u] == false) {

                // Mark present vertic as visited
                visited[u] = true;

                // Mark its color opposite to its parent
                color[u] = 1 - color[v];

                // If the subtree rooted at vertex
                // v is not bipartite
                if (!isBipartite(adj, u, visited, color))
                    return false;
            }

            // If two adjacent are colored with
            // same color then the graph is
            // not bipartite
            else if (color[u] == color[v])
                return false;
        }
        return true;
    }

    // Driver Code
    public static void main(String args[]) {

        // No of nodes
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();

        // To maintain the adjacency list of graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n + 1);

        // Initialize all the vertex
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // To keep a check on whether
        // a node is discovered or not
        boolean visited[] = new boolean[n + 1];

        // To color the vertices
        // of graph with 2 color
        int color[] = new int[n + 1];

        // The value '-1' of colorArr[i] is
        // used to indicate that no color is
        // assigned to vertex 'i'. The value
        // 1 is used to indicate first color
        // is assigned and value 0 indicates
        // second color is assigned.
        Arrays.fill(color, -1);

        // Adding edges to the graph
        int edges = stdin.nextInt();

        for (int i = 0; i < edges; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            addEdge(adj, a, b);
        }

        // Marking the source node as visited
        visited[1] = true;

        // Marking the source node with a color
        color[1] = 0;

        // Function to check if the graph
        // is Bipartite or not
        if (isBipartite(adj, 1, visited, color)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is not Bipartite");
        }
    }
}

// This code is contributed by adityapande88
