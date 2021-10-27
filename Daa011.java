import java.util.Scanner;

public class Daa011 {

    public static int binarySearchCondition(int low, int high, int[] paragens, int particao) {

        while (low < high) {
            int middle = low + (high - low) / 2;
            // System.out.println("middle: " + middle);
            if (isPossible(paragens, middle, particao)) {
                high = middle;
                // System.out.println("high: " + high);
            } else {
                low = middle + 1;
                // System.out.println("low: " + low);
            }
        }
        
        if (!isPossible(paragens, low, particao)) {

            return -1;
        }

        return low;
    }

    public static boolean isPossible(int[] paragens, int km, int particao) {
        int somaTemporaria = 0;
        int particoesSoFar = 0;

        for (int i = 0; i < paragens.length; i++) {
            if (paragens[i] > km) {
                return false;
            }

            somaTemporaria = somaTemporaria + paragens[i];

            if (somaTemporaria > km) {
                particoesSoFar++;

                somaTemporaria = paragens[i];
                // System.out.println("Soma Temp.: "+ somaTemporaria);

            }

        }
        if (particoesSoFar <= particao - 1) {
            return true;
        } else {
            return false;
        }

    }

    public static int sumArray(int[] inteiros) {
        int soma = 0;
        for (int i = 0; i < inteiros.length; i++) {
            soma = soma + inteiros[i];
        }
        return soma;
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int numPragens = stdin.nextInt();

        int[] paragens = new int[numPragens];

        for (int i = 0; i < numPragens; i++) {
            paragens[i] = stdin.nextInt();
        }

        int lowerBound = 1;
        int upperBound = sumArray(paragens);

        // System.out.println("U: " + upperBound);
        // System.out.println("L: " + lowerBound);

        int tamanhosParticoes = stdin.nextInt();

        int[] particoes = new int[tamanhosParticoes];

        for (int i = 0; i < tamanhosParticoes; i++) {
            particoes[i] = stdin.nextInt();
        }

       
        for (int i = 0; i < tamanhosParticoes; i++) {
            System.out.println(binarySearchCondition(lowerBound, upperBound, paragens, particoes[i]));
        }

        

    }
}
