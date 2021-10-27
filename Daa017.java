import java.util.*;

public class Daa017 {
    public static void calcula(){
        for (int i = 1; i <= numCamadas; i++){
            for (int j = 1; j <= numCamadas - i +1; j++){
                if (piramide[i][j] == 0){
                    continue;
                }
                if (i == 1) {
                    piramide[i][j] = 1;
                    //System.out.println("Se i = 1 ficamos com a piramide assim: ");
                    //printMatrix(piramide);
                    //System.out.println();
                    //System.out.println();
                }else {
                    piramide[i][j] = piramide[i-1][j] + piramide[i-1][j + 1];
                    //System.out.println("Se i =/= 1 então ficamos com a piramide assim: ");
                    //printMatrix(piramide);
                    //System.out.println();
                    //System.out.println();
                }
                    
            }

        }
    }

    public static void printMatrix (long [][] matriz){
        System.out.print("[");
        for (int i = 0; i < matriz.length; i++){
            System.out.print("[");
            for (int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print( i==matriz.length-1 ? ("]") : ("]\n"));
        }
        System.out.print("]\n");
    }

    static int numCamadas;
    static long [] [] piramide;
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        numCamadas = stdin.nextInt();

        piramide = new long [numCamadas+1] [numCamadas+1];

        //vou começar por preencher a matriz com 1 na metade relevante.

        for (int i = 1; i <= numCamadas; i++){
            for (int j = 1; j <= numCamadas; j++){
                piramide[i][j] = -1;
            }
        }
        //System.out.println("piramide inicializada: ");
        //printMatrix(piramide);
        //System.out.println();
        //System.out.println();

        int numPedrasDesgastadas = stdin.nextInt();

        for (int i = 0; i< numPedrasDesgastadas; i++){
            int camadaEmQuestao = stdin.nextInt();
            int posicao = stdin.nextInt();

            piramide[camadaEmQuestao][posicao] = 0;
        }
        //System.out.println("piramide já com as pedras - as pedras estão assinaladas com 0");
        //printMatrix(piramide);

        calcula();
        System.out.println(piramide[numCamadas][1]);








        
    }
}
