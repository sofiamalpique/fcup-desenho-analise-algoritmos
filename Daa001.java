import java.util.Scanner;

public class Daa001 {

  public static void main(String[] args) {
    
    Scanner stdin = new Scanner(System.in);  

    int n = stdin.nextInt(); // n é o número de inteiros que o input tem

  
    int counter = 0;
    //iterar sobre o input que tem tamanho n
    for(int i = 0; i < n; i++){
        
        if (stdin.nextInt() == 42) counter++; //se a entrada de input seguinte for o numero 42 o contador guarda essa info
    }

    System.out.println(counter);

  }
}