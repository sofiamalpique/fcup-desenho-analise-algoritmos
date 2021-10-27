import java.util.*;

public class Daa018 {

    public static void calcula(int goal) {
        minimumCoinsForQuantityX[0] = 0;
        for (int i = 1; i <= goal; i++) {
            minimumCoinsForQuantityX[i] = Integer.MAX_VALUE;
            useThisCoin[i] = 0;
            // System.out.print("I: "+ i + "-> ");
            for (int j = 1; j <= typeOfCoins.length; j++) {
                int moeda = typeOfCoins[j - 1];
                if (moeda <= i && (1 + minimumCoinsForQuantityX[i - moeda] < minimumCoinsForQuantityX[i])) {
                    minimumCoinsForQuantityX[i] = 1 + minimumCoinsForQuantityX[i - moeda];
                    useThisCoin[i] = moeda;
                    // System.out.print(moeda + " ");
                }
            }
            // System.out.println();
        }
    }

    // vai guardar os tipos de moeda que existem
    static int[] typeOfCoins;

    // vai guardar o número mínimo de moedas que precisamos para a quantia i
    static int[] minimumCoinsForQuantityX;

    // na posição i vai ter o valor da moeda que
    // temos de usar para que o nº de moedas seja mínimo
    static int[] useThisCoin;

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        // estou a ir buscar o número de moedas diferentes
        int numMoedas = stdin.nextInt();

        // estou a inicializar o array que me vai guardar os diferentes tipos de moedas
        typeOfCoins = new int[numMoedas];

        // vamos preencher o array com as moedas
        for (int i = 0; i < numMoedas; i++) {
            typeOfCoins[i] = stdin.nextInt();
        }

        // vou agora buscar o número de "queries", i.e. o nº de quantias que desejam
        // calcular
        int numQueries = stdin.nextInt();

        // agora para cada uma das queries temos de calcular então o nº mínimo de moedas
        for (int i = 0; i < numQueries; i++) {
            // vamos buscar a quantia desejada
            int quantia = stdin.nextInt();

            // inicializamos o array minimumCoinsForQuantityX
            // que vai da posição 0 até à posição X, i.e. quantia + 1
            minimumCoinsForQuantityX = new int[quantia + 1];

            // inicializamos o array useThisCoin que vai
            // da posição 0 até à posição X, i.e. quantia + 1
            // para que quando nos deparamos com um determinado valor menor
            // que a quantia sabermos já o nº mínimo de moedas para esse mesmo valor
            useThisCoin = new int[quantia + 1];

            calcula(quantia);

            System.out.print(quantia + ": [" + minimumCoinsForQuantityX[quantia] + "]");

            /*
             * for (int j = 0; j <= quantia; j++){ System.out.print(useThisCoin[j] + " "); }
             */

            String res = "";
            while (quantia > 0) {
                res = res + " " + useThisCoin[quantia];
                //System.out.print("RES: " + res);
                quantia = quantia - useThisCoin[quantia];
            }

            System.out.println(res);

        }

    }
}
