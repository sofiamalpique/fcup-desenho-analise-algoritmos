// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)

import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited; // Valor booleano que indica se foi visitado numa pesquisa
    public int distance; // Distancia ao no origem da pesquisa

    Node() {
        adj = new LinkedList<Integer>();
    }
}

// Classe que representa um grafo
class Graph {
    int n; // Numero de nos do grafo
    Node nodes[]; // Array para conter os nos

    Graph(int n) {
        this.n = n;
        nodes = new Node[n + 1]; // +1 se nos comecam em 1 ao inves de 0
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node();
    }

    public void addLink(int a, int b) {
        nodes[a].adj.add(b);
        nodes[b].adj.add(a);
    }

    // Algoritmo de pesquisa em largura
    public int bfs(int v) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            nodes[i].visited = false;

        q.add(v);
        nodes[v].visited = true;
        nodes[v].distance = 0;

        int maxSoFar = 0;
        while (q.size() > 0) {
            int u = q.removeFirst();
            if (maxSoFar <= nodes[u].distance) {
                maxSoFar = nodes[u].distance;
            }
            for (int w : nodes[u].adj)
                if (!nodes[w].visited) {
                    q.add(w);
                    nodes[w].visited = true;
                    nodes[w].distance = nodes[u].distance + 1;
                }
        }
        return maxSoFar;
    }
}

public class Daa030 {

    public static void getCentralNodes(int[] excentricidades, int raio) {
        int contador = 0;
        for (int i = 0; i < excentricidades.length; i++) {
            //System.out.println("excentr: " + excentricidades[i]);
        }
        for (int i = 0; i < excentricidades.length; i++) {

            if (excentricidades[i] == raio) {
                contador++;
                if (contador > 1){
                    System.out.print(" ");
                }
                System.out.print(i + 1);

                
            }
            
        }
        System.out.println();
    }

    public static void getPerifericalNodes(int[] excentricidades, int diametro) {
        int contador = 0;
        for (int i = 0; i < excentricidades.length; i++) {
            if (excentricidades[i] == diametro) {
                contador++;
                if (contador > 1){
                    System.out.print(" ");
                }
                System.out.print(i + 1);

                
            }
        }
        System.out.println();
    }

    public static int getMaxElmFromArray(int[] excentricidades) {
        int biggestElm = 0;
        for (int i = 0; i < excentricidades.length; i++) {
            biggestElm = Integer.max(biggestElm, excentricidades[i]);
        }

        return biggestElm;
    }

    public static int getMinElmFromArray(int[] excentricidades, int diametro) {
        int smallestElm = diametro;
        for (int i = 0; i < excentricidades.length; i++) {
            smallestElm = Integer.min(smallestElm, excentricidades[i]);
        }
        return smallestElm;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        Graph g = new Graph(num);
        int e = in.nextInt();
        for (int i = 0; i < e; i++) {
            g.addLink(in.nextInt(), in.nextInt());
        }

        int[] excentricidades = new int[num];

        for (int i = 1; i <= num; i++) {
            excentricidades[i - 1] = g.bfs(i);
        }

        /*
        for (int i = 0; i < num; i++) {
            System.out.println("Exc: " + excentricidades[i]);
        }
        */

        int diametro = getMaxElmFromArray(excentricidades);
        int raio = getMinElmFromArray(excentricidades, diametro);

        System.out.println(diametro);
        System.out.println(raio);
        getCentralNodes(excentricidades, raio);
        getPerifericalNodes(excentricidades, diametro);

    }
}