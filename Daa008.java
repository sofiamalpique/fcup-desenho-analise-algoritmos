import java.util.*; 
import java.lang.*; 
import java.io.*; 

/** 
* Given a 2D array, find the maximum sum subarray in it 
*/
public class Daa008 { 
	public static void main(String[] args)  
	{ 
		//POR AQUI A MATRIZ ATRAVES DO INPUT!!
	} 

    public static int findMaxSum (int [][] matriz) {
        int numeroLinhas = matriz.length;
        int numeroColunas = matriz[0].length;
        int maxSum=0;
 
    for (int left = 0; left < numeroColunas; left++)
    {
        int temp[numeroLinhas] = {0};
 
        for (int right = left; right < numeroColunas; right++)
        {
            // Find sum of every mini-row between left and right columns and save it into temp[]
            for (int i = 0; i < numeroLinhas; ++i)
                temp[i] += matriz[i][right];
 
            // Find the maximum sum subarray in temp[].
            
            int sum = kadane(temp, numeroLinhas);
 
            if (sum > maxSum)
                maxSum = sum;
        }
    }

    public static int somaMaximaSubArray(int [] sequencia) {
        int tamanho = sequencia.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < tamanho; i++) {
            maxEndingHere = maxEndingHere + sequencia[i];
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }
 
    return maxSum;
}

} 
// Thanks to Ilia Savin for contributing this code. 
