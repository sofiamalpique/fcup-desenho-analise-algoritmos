import java.io.*;
import java.util.StringTokenizer;

public class Daa007 {

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);

        // isto diz-me com quantos números constam na sequência inteira
        int quantidadeDeNumeros = in.nextInt();
        // System.out.println("A quantidade de números a considerar é " +
        // quantidadeDeNumeros );

        int[] arraySequencia = new int[quantidadeDeNumeros];
        for (int i = 0; i < quantidadeDeNumeros; i++) {
            arraySequencia[i] = in.nextInt();
            // FastPrint.out.println("A " + (i+1) + "ª posição do array é " +
            // arraySequencia[i]);
        }

        FastPrint.out.println(somaMaximaSubArray(arraySequencia));

        FastPrint.out.close();

    }

    public static int somaMaximaSubArray(int [] sequencia) {
        int tamanho = sequencia.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < tamanho; i++) {
            maxEndingHere = maxEndingHere + sequencia[i];
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }
}