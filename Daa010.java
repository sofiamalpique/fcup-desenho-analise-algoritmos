import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Daa010 {

    public static Integer[] findClosest(Integer a[], Integer key) {
        // 1. criar o retorno vazio
        Integer[] resultado = new Integer[2];
        resultado[0] = null;
        resultado[1] = null;

        // 2. popular o retorno

        int tamanhoArray = a.length;

        if (key <= a[0]) {
            resultado[0] = a[0];
            return resultado;
        }

        if (key >= a[tamanhoArray - 1]) {
            resultado[0] = a[tamanhoArray - 1];
            return resultado;
        }

        // binary search
        int i = 0;
        int j = tamanhoArray;
        int middle = 0;

        while (i < j) {
            middle = (i + j) / 2;

            if (a[middle] == key) {
                resultado[0] = a[middle];
                return resultado;
            }

            if (key < a[middle]) {
                if (middle > 0 && key > a[middle - 1]) {
                    System.out.println("XX" + getClosest(a[middle - 1], a[middle], key));
                    resultado[0] = getClosest(a[middle - 1], a[middle], key);
                    return resultado;
                }
                j = middle;
            }

            if (key > a[middle]) {
                if (middle < tamanhoArray - 1 && key < a[middle + 1]) {
                    System.out.println("YY" + getClosest(a[middle], a[middle + 1], key));
                    resultado[1] = getClosest(a[middle], a[middle + 1], key);

                    // 1 existe numero anterior?

                    // 2 se sim, qual é?

                    // existe numero posterrio?

                    // se sim qual é

                    // o numero anterior tem a mesma diferença para a key do que o que está no resultado[0]?

                    // e o numero posterior?

                    // se sim, em algum deles, preencher o resultado[1] e retornar como estºa
                    return resultado;
                }
                i = middle + 1;
            }

        
        }

        // 3. retornar
        resultado[0] = a[middle];
        return resultado;
    }

    public static Integer getClosest(Integer limiteInferior, Integer limiteSuperior, Integer key) {
        if (key - limiteInferior >= limiteSuperior - key) {
            return limiteSuperior;
        }
        return limiteInferior;
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int cardinalidadeDoConjunto = stdin.nextInt();

        int[] arrayConjunto = new int[cardinalidadeDoConjunto];

        for (int i = 0; i < cardinalidadeDoConjunto; i++) {
            arrayConjunto[i] = stdin.nextInt();
        }

        Arrays.sort(arrayConjunto);

        /*
         * for(int i = 0; i < cardinalidadeDoConjunto; i++){
         * System.out.print(arrayConjunto[i] + "  "); } System.out.println();
         */

        Integer paresDeSomas = (cardinalidadeDoConjunto * (cardinalidadeDoConjunto - 1)) / 2;
        Integer[] soma = new Integer[paresDeSomas];
        Integer counter = 0;

        // System.out.print("Somas: ");
        for (int i = 0; i < cardinalidadeDoConjunto; i++) {
            for (int j = i + 1; j < cardinalidadeDoConjunto; j++) {
                soma[counter] = arrayConjunto[i] + arrayConjunto[j];

                // System.out.print(soma[counter] + " ");

                counter++;
            }

        }
        // System.out.println();

        Arrays.sort(soma);

        /*
         * System.out.print("Somas ordenadas: "); for (int i = 0; i < paresDeSomas;
         * i++){ System.out.print(soma[i] + "    "); } System.out.println();
         */

        Integer cardinalidadePerguntas = stdin.nextInt();

        Integer[] somasDesejadas = new Integer[cardinalidadePerguntas];

        // System.out.print("Somas pretendidas [");
        for (int i = 0; i < cardinalidadePerguntas; i++) {
            somasDesejadas[i] = stdin.nextInt();
            // System.out.print(somasDesejadas[i] + ", ");
        }

        Integer[] resultado = findClosest(soma, 21);

        System.out.println(resultado[0] + " " + resultado[1]);

    }

}
