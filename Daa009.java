import java.io.*;
import java.util.*;
import java.util.Scanner;

class Letra implements Comparable <Letra>{
    public String nome;
    public int counter;
    public int position;

    Letra(String nome, int counter, int position){
        this.nome = nome;
        this.counter = counter;
        this.position = position;

    }



    
    public String getNome(){
        return this.nome;
    }

    public int getCounter(){
        return this.counter;
    }

    public int getPosition(){
        return this.position;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void incrementCounter(){
        this.counter++;
    } 

    /*
    public void incrementPosition(){
        this.position++;
    } 
    */



    @Override
    public int compareTo(Letra l) {

        if (counter > l.counter) return -1;
        if (counter < l.counter) return +1;

        if (position < l.position) return -1;
        if (position > l.position) return +1;

        return 0;

    }
}






public class Daa009 {

    public static void main(String[] args) {

        Letra letras[] = {new Letra("A",0,0), new Letra("B",0,1), new Letra("C",0,2), new Letra("D",0,3), 
                            new Letra("E",0,4), new Letra("F",0,5), new Letra("G",0,6), new Letra("H",0,7),
                            new Letra("I",0,8), new Letra("J",0,9), new Letra("K",0,10), new Letra("L",0,11), 
                            new Letra("M",0,12), new Letra("N",0,13), new Letra("O",0,14), new Letra("P",0,15), 
                            new Letra("Q",0,16), new Letra("R",0,17), new Letra("S",0,18), new Letra("T",0,19), 
                            new Letra("U",0,20), new Letra("V",0,21), new Letra("W",0,22), new Letra("X",0,23), 
                            new Letra("Y",0,24), new Letra("Z",0,25)};

        

        Scanner stdin = new Scanner(System.in);

        String ADN = stdin.nextLine();

        //System.out.println("O input é: " + ADN);

        int tamanhoAdn = ADN.length();


        String [] alfabeto = new String[26];

        for (int i = 0; i < 26; i++){
            alfabeto[i] = letras[i].getNome();
        }



        for (int i = 0; i < 26; i++){
            for (int j = 0; j < tamanhoAdn; j++){

                char c = ADN.charAt(j);
                String s = String.valueOf(c);
                if (s.equals(alfabeto[i])){
                    letras[i].incrementCounter();
                    int indice = ADN.indexOf(s);
                    letras[i].setPosition(indice);
                }

                

                
                

            }
            //System.out.println("TXIIIII   --- A letra é " + letras[i].getNome() + ", a frequencia é " + letras[i].getCounter() 
                   //+ " e a posição é " + letras[i].getPosition());
        } 
        Arrays.sort(letras);

        for (int i = 0; i < 26; i++){
            if (letras[i].getCounter() != 0){
                System.out.println(letras[i].getNome() + " " + letras[i].getCounter());
            }
        }



       /*
        if(tamanhoAdn < 26){
            for (int i = 0; i < tamanhoAdn; i++){
                char c = ADN.charAt(i);
                String s = String.valueOf(c);
                int indice = ADN.indexOf(s);
                letras[i].setPosition(indice);

                if (letras[i].getCounter() != 0){
                
                

                    System.out.println("A letra é " + letras[i].getNome() + ", a frequencia é " + letras[i].getCounter() 
                    + " e a posição é " + letras[i].getPosition());
                        
                }
            }
        }
        if(tamanhoAdn >= 26){
            for (int i = 0; i < 26; i++){

                char c = ADN.charAt(i);
                String s = String.valueOf(c);
                int indice = ADN.indexOf(s);
                letras[i].setPosition(indice);

                if (letras[i].getCounter() != 0){
                
                

                    System.out.println("A letra é " + letras[i].getNome() + ", a frequencia é " + letras[i].getCounter() 
                    + " e a posição é " + letras[i].getPosition());
                        
                }

            }
        }        
             
            */





        /* int[] frequencia = new int[tamanhoAdn];

        char string[] = ADN.toCharArray();

        for (int i = 0; i < tamanhoAdn; i++) {
            frequencia[i] = 1;
            //System.out.println("Antes de entrar no loop de j o valor na " + (i + 1) + "ª posição do array frequencia é "
               //     + frequencia[i]);
            //System.out.println("O valor de i é " + i);
            //System.out.println();

            for (int j = i + 1; j < tamanhoAdn; j++) {
                ////System.out.println("O valor de i é " + i + " e o valor de j é " + j);
                if (string[i] == string[j]) {
                    frequencia[i]++;
                    //System.out.println("Agora na " + (i+1) + "ª posiçao temos lá o valor " + frequencia[i]);


                    //System.out.println("Antes de passar a zero, string[" + j + "] tem o valor de " + string[j]);
                    string[j] = '0';

                    //System.out.println("Depois de passar a zero, string[" + j + "] tem o valor de " + string[j]);
                }
                
            }
            
            ////System.out.println("Quando saio do loop j, frequencia[" + i + "] é " + frequencia[i]);
            //System.out.println();
        }

        for (int i = 0; i < string.length; i++) {
            System.out.println("string[" + i + "] = " + string[i]);
            System.out.println("frequencia[" + i + "] = " + frequencia[i]);
            System.out.println();
        }
        

        System.out.println("Characters and their corresponding frequencies");

        for (int i = 0; i < frequencia.length; i++) {
            if (string[i] != '0')
                System.out.println(string[i] + " " + frequencia[i]);
        } */
    }

}