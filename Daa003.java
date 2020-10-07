import java.util.Scanner;

public class Daa003 {

    public static int MAX_GERACAO_1 = 5290000;
    public static int MAX_GERACAO_2 = 5290000;
    public static int MAX_GERACAO_3 = 5290000;
    public static int MAX_GERACAO_4 = 27984100;

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int casosTeste = Integer.parseInt(stdin.nextLine());

        for (int i = 0; i < casosTeste; i++) {

            String parMatriculas = stdin.nextLine();

            String[] par = parMatriculas.split(" ");

            String[] matricula1 = par[0].split("-");
            String[] matricula2 = par[1].split("-");

            String primeiraMatricula = matricula1[0] + matricula1[1] + matricula1[2];
            String segundaMatricula = matricula2[0] + matricula2[1] + matricula2[2];

            int geracaoMatricula1 = verificarGeracao(matricula1);
            int geracaoMatricula2 = verificarGeracao(matricula2);

            int[] arrayMatricula1 = transformarMatriculaEmNumeros(primeiraMatricula);
            int[] arrayMatricula2 = transformarMatriculaEmNumeros(segundaMatricula);

            int positionM1 = getPosicaoPorGeracao(geracaoMatricula1, arrayMatricula1);
            int positionM2 = getPosicaoPorGeracao(geracaoMatricula2, arrayMatricula2);

            System.out.println(diferencaDeMatriculas(positionM1, positionM2, geracaoMatricula1, geracaoMatricula2));

        }

    }

    public static int getPosicaoPorGeracao(int geracao, int[] matriculaEmNumeroArray) {
        int posicao = 0;
        switch (geracao) {
            case 1:
                posicao = matriculaEmNumeroArray[0] * 230000 + matriculaEmNumeroArray[1] * 10000
                        + matriculaEmNumeroArray[2] * 1000 + matriculaEmNumeroArray[3] * 100
                        + matriculaEmNumeroArray[4] * 10 + matriculaEmNumeroArray[5] + 1;
                break;
            case 2:
                posicao = matriculaEmNumeroArray[4] * 230000 + matriculaEmNumeroArray[5] * 10000
                        + matriculaEmNumeroArray[0] * 1000 + matriculaEmNumeroArray[1] * 100
                        + matriculaEmNumeroArray[2] * 10 + matriculaEmNumeroArray[3] + 1;
                break;
            case 3:
                posicao = matriculaEmNumeroArray[2] * 230000 + matriculaEmNumeroArray[3] * 10000
                        + matriculaEmNumeroArray[0] * 1000 + matriculaEmNumeroArray[1] * 100
                        + matriculaEmNumeroArray[4] * 10 + matriculaEmNumeroArray[5] + 1;
                break;
            case 4:
                posicao = matriculaEmNumeroArray[0] * 1216700 + matriculaEmNumeroArray[1] * 52900
                        + matriculaEmNumeroArray[4] * 2300 + matriculaEmNumeroArray[5] * 100
                        + matriculaEmNumeroArray[2] * 10 + matriculaEmNumeroArray[3] + 1;
                break;
            default:
                break;
        }
        return posicao;
    }

    public static int[] transformarMatriculaEmNumeros(String matriculaEmString) {
        int[] arrayAuxiliar = new int[6];
        String letras = "ABCDEFGHIJLMNOPQRSTUVXZ";
        String numeros = "0123456789";
        for (int j = 0; j < 6; j++) {
            if (letras.contains(String.valueOf(matriculaEmString.charAt(j)))) {
                arrayAuxiliar[j] = ((int) letras.indexOf(matriculaEmString.charAt(j)));
            }
            if (numeros.contains(String.valueOf(matriculaEmString.charAt(j)))) {
                arrayAuxiliar[j] = ((int) numeros.indexOf(matriculaEmString.charAt(j)));
            }
        }
        return arrayAuxiliar;
    }

    public static int verificarGeracao(String[] matriculaEmArray) {
        int geracao = 0;

        String parte1 = matriculaEmArray[0];
        String parte2 = matriculaEmArray[1];
        String parte3 = matriculaEmArray[2];

        // 1º Geração
        if (!isNumeric(parte1) && isNumeric(parte2) && isNumeric(parte3)) {

            return 1;
        }

        // 2º Geração
        if (isNumeric(parte1) && isNumeric(parte2) && !isNumeric(parte3)) {

            return 2;
        }

        // 3º Geração
        if (isNumeric(parte1) && !isNumeric(parte2) && isNumeric(parte3)) {

            return 3;
        }

        // 4º Geração
        if (!isNumeric(parte1) && isNumeric(parte2) && !isNumeric(parte3)) {

            return 4;
        }

        return geracao;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static int diferencaDeMatriculas(int positionMatricula1, int positionMatricula2, int geracaoMatricula1,
            int geracaoMatricula2) {
        int diferenca = -1;

        if (geracaoMatricula1 == geracaoMatricula2) {
            diferenca = (positionMatricula1 <= positionMatricula2) ? positionMatricula2 - positionMatricula1
                    : positionMatricula1 - positionMatricula2;

        }
        if (geracaoMatricula1 < geracaoMatricula2) {
            int numeroDeGeracoes = geracaoMatricula2 - geracaoMatricula1 - 1;
            diferenca = positionMatricula2 + (MAX_GERACAO_1 - positionMatricula1) + numeroDeGeracoes * MAX_GERACAO_1;

        }
        if (geracaoMatricula1 > geracaoMatricula2) {
            int numeroDeGeracoes = geracaoMatricula1 - geracaoMatricula2 - 1;
            diferenca = positionMatricula1 + (MAX_GERACAO_1 - positionMatricula2) + numeroDeGeracoes * MAX_GERACAO_1;

        }

        return diferenca;
    }

}