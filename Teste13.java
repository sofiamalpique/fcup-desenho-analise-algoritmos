import java.util.*;

class Segmentos implements Comparable<Segmentos> {
    int start, finish, tamanho;

    Segmentos(int s, int f) {
        start = s;
        finish = f;
        tamanho = f - s;
    }

    @Override
    public int compareTo(Segmentos s) {
        if (start < s.start)
            return -1;
        if (start > s.start)
            return +1;
        if (tamanho > s.tamanho)
            return -1;
        return 1;
    }

}

class Teste13 {

    public static int procura(Segmentos[] data, int time) {
        int melhor = 0;
        int temp = 0;

        for (int i = 0; i < data.length; i++) {
            System.out.println("Entramos no ciclo for da função auxiliar 'procura' ");

            System.out.println("i = " + i + "; melhor= " + melhor + "; temp= " + temp + "; time=" + time);

            if (data[i].start > time)
                break;

            int resposta = data[i].finish - time;
            System.out.println("Resposta: " + data[i].finish + "-" + time + " = " + resposta);
            if (resposta > melhor) {
                System.out.println(resposta + " > " + melhor + ", portanto entrei no 2º if");
                melhor = resposta;
                temp = i;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);

        int tamanho = in.nextInt();
        int nrSegmentos = in.nextInt();
        Segmentos[] data = new Segmentos[nrSegmentos];

        for (int i = 0; i < nrSegmentos; i++)
            data[i] = new Segmentos(in.nextInt(), in.nextInt());

        Arrays.sort(data);

        /*
         * for(int i=0;i<nrSegmentos;i++){ System.out.println(data[i].start + " : " +
         * data[i].finish); }
         */

        // for(int i=0;i<nrSegmentos;i++)
        // FastPrint.out.println(data[i].start + " " + data[i].finish);

        int time = 0;
        int counter = 0;

        while (time < tamanho) {
            
            int temp = procura(data, time);
            System.out.println();
            System.out.println("AGORA NO MAIN:");
            System.out.println("O temp agora é: " + temp);
            time = data[temp].finish;
            System.out.println("time = data["+temp+"].finish = " + data[temp].finish);
            counter++;
            System.out.println("O counter vai em " + counter);
        }

        FastPrint.out.println(counter);
        FastPrint.out.close();
    }
}
