import java.util.*;
import java.lang.*;
import java.io.*;

public class Daa026 {

    static int numLinhas;
    static int numColunas;
    static char caixaPetri[][];
    static boolean visited[][];
    static int contador;
    static int maxSoFar;

    static int[] X_move = { -1, 1, 0, 0, -1, -1, 1, 1 }; // Têm de estar aos pares! - IMPORTANTE
    static int[] Y_move = { 0, 0, -1, 1, -1, 1, -1, 1 };

    static void dfs(int y, int x) {
        if (y < 0 || y >= numLinhas || x < 0 || x >= numColunas) {
            return;
        }

        if (visited[y][x] || caixaPetri[y][x] != '#') {
            return;
        }

        
        visited[y][x] = true;

        contador++;

        for (int i = 0; i < 8; i++)
            dfs(y + Y_move[i], x + X_move[i]);

    }

    static void printMatriz() {
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++)
                System.out.print(caixaPetri[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int numCaixas = stdin.nextInt();

        for (int i = 0; i < numCaixas; i++) {

            numLinhas = stdin.nextInt();
            numColunas = stdin.nextInt();

            String buffer = stdin.nextLine(); // Se este não estiver aqui dá erro

            caixaPetri = new char[numLinhas][numColunas];
            visited = new boolean[numLinhas][numColunas];

            for (int j = 0; j < numLinhas; j++)
                caixaPetri[j] = stdin.nextLine().toCharArray();

            // printMatriz();
            contador = 0;
            maxSoFar = 0;

            for (int j = 0; j < numLinhas; j++)
                for (int k = 0; k < numColunas; k++)
                    if (caixaPetri[j][k] == '#' && !visited[j][k]) {
                        contador = 0;
                        dfs(j, k);
                        // System.out.println("----------------------" + contador);
                        if (contador > maxSoFar)
                            maxSoFar = contador;
                    }

            System.out.println(maxSoFar);
        }

    }

    

    

}
