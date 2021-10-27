import java.util.*;
import java.lang.String;

public class Daa027 {

    static int n; // Numero de nos do grafo
    static boolean adjMatrix[][]; // Matriz de adjacencias
    static boolean visited[]; // Que nos ja foram visitados?
    static int cores[];

    static boolean dfs(int vertice, int cor) {

        visited[vertice] = true;
        for (int i = 1; i <= n; i++) {

            if (adjMatrix[vertice][i] && !visited[i]) {
                if (cores[i] != cor) {
                    if (dfs(i, -cor)) {
                        cores[i] = -cor;
                    } else
                        return false;

                }

            } else if (adjMatrix[vertice][i] && visited[i]) {
    
                if (cores[i] == cor)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int numCasos = stdin.nextInt();

        for (int i = 0; i < numCasos; i++) {

            n = stdin.nextInt();
            adjMatrix = new boolean[n + 1][n + 1];
            visited = new boolean[n + 1];
            cores = new int[n + 1];
            int edges = stdin.nextInt();
            for (int j = 0; j < edges; j++) {
                int a = stdin.nextInt();
                int b = stdin.nextInt();
                adjMatrix[a][b] = adjMatrix[b][a] = true;
                // System.out.println("Scanning: " + a + " " + b);
            }
            //printAdjMatrix();
            System.out.println(dfs(1, 1) ? "sim" : "nao");
            //System.out.println("----------");
        }

    }

    static void printAdjMatrix() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(adjMatrix[i][j] ? "1" : "0");
            System.out.println();
        }
    }

}
