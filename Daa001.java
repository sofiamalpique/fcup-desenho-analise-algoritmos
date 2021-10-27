import java.util.Scanner;

public class Daa001 {

    public static void main(String[] args) {
        
        Scanner ficheiroRecebido = new Scanner(System.in);

        int numTestes = ficheiroRecebido.nextInt();
        int contador = 0;
        for( int i = 0; i < numTestes; i++){
            int numComparar = ficheiroRecebido.nextInt();
            if (numComparar == 42) {
                contador++;
            }
        }
        System.out.println(contador);
    }
}