import java.util.Scanner;

public class Daa004 {

    public static long soma(long numeroIncrementado) {

        long sum = 0;
        long num = numeroIncrementado;

        while (num > 0) {
            long lastDigit = num % 10;
            sum = sum + lastDigit;
            num = (long) num / 10;
        }

        return sum;

    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int casosteste = Integer.parseInt(stdin.nextLine());

        // System.out.println("O número de vezes que vamos fazer este jogo é: " +
        // casosteste);

        for (int i = 0; i < casosteste; i++) {

            String linhaDeInput = stdin.nextLine();
            // System.out.println(linhaDeInput);

            String[] separarNumeroDaSoma = linhaDeInput.split(" ");

            int tamanhoDoNumero = separarNumeroDaSoma[0].length();
            //System.out.println("O número dado tem " + tamanhoDoNumero + " dígitos.");

            long numeroDado = Long.parseLong(separarNumeroDaSoma[0]);

            int somaDesejada = Integer.parseInt(separarNumeroDaSoma[1]);

            int alternativaAoTamanho = ((int)somaDesejada / 9) + 1;
            
            //System.out.println("O número de dígitos do número dado é " + tamanhoDoNumero + " e a alternativa é "
                    //+ alternativaAoTamanho);

            String comporNumeroK = "1";
            for (int j = 0; j < alternativaAoTamanho; j++){
                comporNumeroK = comporNumeroK + "0";
            }
            System.out.println("O número mínimo para k é: " + comporNumeroK);

            long novoValorDeK = Long.parseLong(comporNumeroK);

            //System.out.println(novoValorDeK);
            
            long valorParaK = (tamanhoDoNumero < alternativaAoTamanho) ?  novoValorDeK : (numeroDado + 1);
            
            long k = valorParaK;



            while (soma(k) != somaDesejada) {

                k++;

            }

            System.out.println(k);

        }

    }

}