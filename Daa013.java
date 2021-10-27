import java.util.*;

class Segmento implements Comparable<Segmento> {
    public int inicio;
    public int fim;

    Segmento(int i, int f) {
        inicio = i;
        fim = f;
    }

    public int getSize() {
        return this.fim - this.inicio;
    }

    @Override
    public int compareTo(Segmento s) {
        if (inicio < s.inicio)
            return -1;
        if (inicio > s.inicio)
            return +1;
        if (fim > s.fim)
            return -1;
        if (fim < s.fim)
            return +1;
        return 0;
    }
}



public class Daa013 {

    public static int calculate(Segmento[] segmentos, int numeroNaRecta) {
        int contador = 0;
        Segmento[] segmentosPossiveis = new Segmento[segmentos.length];

        for (int i = 0; i < segmentos.length; i++) {
            int x = segmentos[i].inicio;
            int y = segmentos[i].fim;
            int size = segmentos[i].getSize();

            if (numeroNaRecta >= x && numeroNaRecta < y) {
                segmentosPossiveis[contador] = segmentos[i];
                contador++;
            }
        }

        Segmento maiorSegmento = null;
        int maxY = 0;

        for (int i = 0; i < contador; i++) {
            if (segmentosPossiveis[i].fim > maxY) {
                maiorSegmento = segmentosPossiveis[i];
                maxY = segmentosPossiveis[i].fim;
            }
        }

        /*
         * System.out.println("numeroNaRecta: " + numeroNaRecta);
         * System.out.println("X: " + maiorSegmento.inicio); System.out.println("Y: " +
         * maiorSegmento.fim); System.out.println("\n"); System.out.println("\n");
         */

        return maiorSegmento.fim;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int finalPosition_M = stdin.nextInt();

        int numSegmentos_N = stdin.nextInt();

        /*
         * 
         * System.out.println("finalPosition_M: " + finalPosition_M);
         * System.out.println("numSegmentos_N: " + numSegmentos_N);
         */

        Segmento[] segmentos = new Segmento[numSegmentos_N];

        for (int i = 0; i < numSegmentos_N; i++) {
            segmentos[i] = new Segmento(stdin.nextInt(), stdin.nextInt());
        }

        Arrays.sort(segmentos);

        for (int i = 0; i < numSegmentos_N; i++) {
            /*
             * System.out.println("oi_X: " + segmentos[i].inicio);
             * System.out.println("oi_Y: " + segmentos[i].fim); System.out.println("\n");
             */
        }

        int currentNumeroNaRecta = 0;
        int result = 0;

        while (currentNumeroNaRecta < finalPosition_M) {
            int foundMaxPosition = calculate(segmentos, currentNumeroNaRecta);
            if (foundMaxPosition < 0) {
                // faz nada
            } else {
                currentNumeroNaRecta = foundMaxPosition;
                result = result + 1;
            }

        }

        System.out.println(result);
    }
}