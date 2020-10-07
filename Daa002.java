import java.util.Scanner;

public class Daa002 {



    public static int Soma(int numeroIncrementado) {

        int sum = 0;
        int num = numeroIncrementado;

        while (num > 0) {
            int lastDigit = num % 10; 
            sum = sum + lastDigit;
            num = num/10;
        }

        return sum;


    
        
    
      }

    public static void main(String[] args) {
    
        Scanner stdin = new Scanner(System.in);  

        int casosteste = stdin.nextInt();

        //System.out.println("O número de vezes que vamos fazer este jogo é: " + casosteste);


        for (int i = 0; i < casosteste; i++){

            int numeroDado = stdin.nextInt();
    
            //System.out.println("O primeiro número com que vamos trabalhar é: " + numeroDado);


            int somaDesejada = stdin.nextInt();

            //System.out.println("A soma desejada é: " + somaDesejada);

            
            int k = numeroDado + 1;

            while(Soma(k) != somaDesejada){

                k++;

            }
            
            System.out.println(k);

        }


        

    }
    
    

}