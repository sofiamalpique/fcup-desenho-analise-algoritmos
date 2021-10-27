public class DescendingBinarySearch {

    public static int DBS(int low, int high, int key, int [] inteiros){
        while (low <= high){
            //System.out.println("Entrei no ciclo");
            int mid = low + (high-low)/2;
            System.out.println("O mid vai em: " + mid);
            if (inteiros[mid] == key){
                return mid;
            } else if (inteiros[mid] < key){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] v = {9,6,3,2,1};

        System.out.println(DBS(0,4,9,v));
    }
}
