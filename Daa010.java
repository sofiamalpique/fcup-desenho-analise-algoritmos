import java.util.*;

class BinarySearchResult {
    public int numeroCerto;
    public int numeroProximoBaixo;
    public int numeroProximoCima;

    BinarySearchResult(int numeroCerto, int numeroProximoBaixo, int numeroProximoCima) {
        this.numeroCerto = numeroCerto;
        this.numeroProximoBaixo = numeroProximoBaixo;
        this.numeroProximoCima = numeroProximoCima;
    }
}

public class Daa010 {

    public static void somaProxima(int[] somas, int procurado) {

        BinarySearchResult resultado = binarySearch(somas, 0, somas.length-1, procurado);

        if (procurado <= somas[0]) {
            System.out.println(somas[0]);
        } else if (procurado >= somas[somas.length - 1]) {
            System.out.println(somas[somas.length - 1]);
        } else if (resultado.numeroCerto >= 0) {
            System.out.println(somas[resultado.numeroCerto]);
        } else if (resultado.numeroProximoBaixo >= 0 && resultado.numeroProximoCima >= 0) {
            int cima = somas[resultado.numeroProximoCima];
            int baixo = somas[resultado.numeroProximoBaixo];

            if (procurado - baixo == cima - procurado) {
                System.out.println(somas[resultado.numeroProximoBaixo] + " " + somas[resultado.numeroProximoCima]);
            } else if (procurado - baixo < cima - procurado) {
                System.out.println(somas[resultado.numeroProximoBaixo]);
            } else {
                System.out.println(somas[resultado.numeroProximoCima]);
            }
        }

    }
  

    public static BinarySearchResult binarySearch(int[] vetor, int low, int high, int key) {
        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (key == vetor[middle]) {
                return new BinarySearchResult(middle, -1, -1);
            } else if (key < vetor[middle]) {
                high = middle - 1;

            } else {
                low = middle + 1;

            }
        }
        return new BinarySearchResult(-1, low-1, high + 1);
    }

    public static int sizeArraySomas(int n) {

        int resultado = (n * (n - 1)) / 2;
        return resultado;

    }

    public static int[] criarArraySomas(int[] numeros) {

        int tamanho = sizeArraySomas(numeros.length);

        int[] somas = new int[tamanho];

        int contador = 0;

        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                somas[contador] = numeros[i] + numeros[j];
                contador++;
            }
        }

        Arrays.sort(somas);

        return somas;

    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int cardinalInteiros = stdin.nextInt();

        int[] inteiros = new int[cardinalInteiros];

        for (int i = 0; i < cardinalInteiros; i++) {
            inteiros[i] = stdin.nextInt();
        }

        Arrays.sort(inteiros);

        int[] somas = criarArraySomas(inteiros);
       
        

        int tamanhoQueries = stdin.nextInt();

        int[] queries = new int[tamanhoQueries];

        for (int i = 0; i < tamanhoQueries; i++) {
            queries[i] = stdin.nextInt();

        }

        for (int i = 0; i < queries.length; i++) {
            somaProxima(somas, queries[i]);
        }

        
    }
}
