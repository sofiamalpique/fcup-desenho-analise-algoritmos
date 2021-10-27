
// Java program for above approach
import java.io.*;
import java.util.*;

public class ConnectedComponentCount {

    private int v;
    private int e;
    private Map<Integer, HashSet<Integer>> adjMap;
    private static Map<Integer, Integer> visited;

    ConnectedComponentCount(int vertices) {
        v = vertices;
        adjMap = new HashMap<Integer, HashSet<Integer>>();
        visited = new HashMap<Integer, Integer>();
    }

    // Function to add edges
    private void addEdge(int s, int d) {
        adjMap.putIfAbsent(s, new HashSet<Integer>());
        adjMap.putIfAbsent(d, new HashSet<Integer>());
        adjMap.get(s).add(d);
        adjMap.get(s).add(s);
        adjMap.get(d).add(s);
        adjMap.get(d).add(d);
        visited.put(s, 0);
        visited.put(d, 0);
    }

    // To mark vertices which can be visites
    private void findDFS(int vertex) {

        // Mark as visited
        visited.put(vertex, 1);

        // Print the vertex
        //System.out.println("vertex " + vertex + " visited");
        for (Integer child : adjMap.get(vertex)) {
            if (visited.get(child) == 0) {
                findDFS(child);
            }
        }
    }

    // Function to print graph
    private void printGraph() {
        for (HashSet<Integer> v : adjMap.values()) {
            //System.out.println(v.toString());
        }
    }

    // Driver Code
    public static void main(String args[])
	{
		
		Scanner stdin = new Scanner(System.in);
		//System.out.println("Enter the number of vertices (V): ");
		int vertices = stdin.nextInt();
		
		//System.out.println("Enter the number of edges (E): ");
		int edges = stdin.nextInt();
		
		// To count total number of
		// components
		int numeroComponentes = 0;
		
		ConnectedComponentCount ccc = new ConnectedComponentCount(vertices);
		
		// Input of edges
		while (edges > 0)
		{
			//System.out.println("Enter the nodes s & d: ");
			int s = stdin.nextInt();
			int d = stdin.nextInt();
			ccc.addEdge(s,d);
			edges-- ;
		}
		
		// Function to print graph					 
		ccc.printGraph();
		
		// Traversing every node 
		for(Integer vertex : visited.keySet())
		{
			
			// Check if vertex is already
			// visited or not
			if(visited.get(vertex) == 0)
			{
				
				// Function Call for findDFS
				ccc.findDFS(vertex);
			
				// Print Component Found
				//System.out.println("CC Found");
			
				// Increase the counter
				numeroComponentes++;
			}
		}
		
		// Print number of components					 
		System.out.println("Number of cc component: " + numeroComponentes);
	}
}

// The code is contributed by Alfred Skaria
