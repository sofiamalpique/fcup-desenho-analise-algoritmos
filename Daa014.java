import java.util.*;

class Encomenda implements Comparable<Encomenda> {
    public int diasFabrico;
    public int multa;

    Encomenda(int df, int m) {
        diasFabrico = df;
        multa = m;
    }

    @Override
    public int compareTo(Encomenda e) {
        if (multa > e.multa)
            return -1;
        if (multa < e.multa)
            return +1;
        if (diasFabrico < e.diasFabrico)
            return -1;
        if (diasFabrico > e.diasFabrico)
            return +1;
        return 0;
    }
}

public class Daa014 {

    public static int custoMulta (Encomenda [] encomendas){
        int custo = 0;

        for (int i = 0; i < encomendas.length; i++){
            custo = encomendas[i].diasFabrico;
        }


        return custo;
    }



    public static void main(String[] args) {

        Scanner stdin = new Scanner (System.in);

        int numEncomendas = stdin.nextInt();

        Encomenda [] encomendas = new Encomenda[numEncomendas];

        for (int i = 0; i < numEncomendas; i++){
            encomendas[i] = new Encomenda(stdin.nextInt(), stdin.nextInt());
        }

        Arrays.sort(encomendas);

        for (int i = 0; i < numEncomendas; i++){
            System.out.println("Dias Fabrico: " + encomendas[i].diasFabrico);
            System.out.println("Multa: " + encomendas[i].multa);
            System.out.println();
        }

        int totalDiasNecessarios = 0;

        for (int i = 0; i < numEncomendas; i++){
            totalDiasNecessarios = totalDiasNecessarios + encomendas[i].diasFabrico;
        }

        System.out.println("Para completar a encomenda toda são precisos " + totalDiasNecessarios + " dias.");


    }

}
