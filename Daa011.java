import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Daa011{

    boolean condicao(int numero) {
        if(numero < 10) {
            return false;
        }
        return true;
    }

    int bsearch(int low, int high){
        int middle;
        while (low < high) {

            middle = low + (high - low)/2;

            if (condicao(middle)) {
                high = middle;
            }
            else {
                low = middle +1;
            }

        }
        if (!condicao(low)){
            return -1;
        }
        return low;
    }

}