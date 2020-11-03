import java.io.*;
import java.util.StringTokenizer;

public class Daa005 {

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);

        // isto diz-me com quantos bankugans vou trabalhar
        int numeroDeBakugans = in.nextInt();

        // isto cria um array que guarda a energia de cada bankugan
        int[] arrayDeEnergia = new int[numeroDeBakugans];

        for (int i = 0; i < numeroDeBakugans; i++) {
            arrayDeEnergia[i] = in.nextInt();
        }

        int[] somasAcumuladas = new int[numeroDeBakugans + 1];

        for (int i = 1; i <= numeroDeBakugans; i++) {
            somasAcumuladas[i] = somasAcumuladas[i - 1] + arrayDeEnergia[i - 1];

        }


        int numeroDeFotos = in.nextInt();
        //FastPrint.out.println("O número de fotografias que vão ser tiradas é " + numeroDeFotos);

        for (int i = 0; i < numeroDeFotos; i++) {
            int posicaoInicial = in.nextInt();
            int posiscaoFinal = in.nextInt();
            int somaEnergia = somasAcumuladas[posiscaoFinal] - somasAcumuladas[posicaoInicial - 1];

            FastPrint.out.println(somaEnergia);
        }

        FastPrint.out.close();

    }
}