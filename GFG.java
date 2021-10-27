
// Java program to find 
// unique count of 
// connected components
import java.util.*;
import java.util.List;
import java.util.ArrayList;

class GFG {

    // Function to add edge in the garph
    static void add_edge(int u, int v, Vector<Integer> graph[]) {
        graph[u].add(v);
        graph[v].add(u);
    }

    // Function to traverse the undirected graph
    // using DFS algorithm and keep a track of
    // individual lengths of connected chains
    static int depthFirst(int v, Vector<Integer> graph[], Vector<Boolean> visited, int ans) {
        // Marking the visited vertex as true
        visited.add(v, true);
        //System.out.print(v + " ");

        // Incrementing the count of
        // connected chain length
        ans++;

        for (int i : graph[v]) {
            if (visited.get(i) == false) {
                // Recursive call to the DFS algorithm
                ans = depthFirst(i, graph, visited, ans);
            }
        }
        return ans;
    }

    // Function to initialize the graph
    // and display the result
    static void UniqueConnectedComponent(int n, Vector<Integer> graph[]) {
        // Initializing boolean visited array
        // to mark visited vertices
        Vector<Boolean> visited = new Vector<>();
        for (int i = 0; i < n + 1; i++)
            visited.add(false);

        // Initializing a Set container
        HashSet<Integer> result = new HashSet<>();

        // Following loop invokes DFS algorithm
        for (int i = 1; i <= n; i++) {
            if (visited.get(i) == false) {
                // ans variable stores the
                // individual counts
                int ans = 0;

                // DFS algorithm
                ans = depthFirst(i, graph, visited, ans);

                // Inserting the counts of connected
                // components in set
                result.add(ans);
                //System.out.print("Count = " + ans + "\n");
            }
        }
        //System.out.print("Unique Counts of " + "connected components: ");

        // The size of the Set container
        // gives the desired result
        System.out.print(result.size() + "\n");
    }

    // Driver code
    public static void main(String[] args) {

       
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int edges = stdin.nextInt();

        // Create graph
        Vector<Integer>[] graph = new Vector[n + 1];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new Vector<Integer>();

        // Constructing the undirected graph

        for (int i = 0; i < edges; i++){
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            add_edge(a, b, graph);
        }

        // Function call
        UniqueConnectedComponent(n, graph);
    }
}

// This code is contributed by Princi Singh
