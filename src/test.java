import java.util.Random;

public class test {

   public static void main(String[] args) {
      Integer[] arr = new Integer[6];
      Random rand = new Random();
      
      
      arr[0] = 10;
      arr[1] = 5;
      arr[2] = 9;
      arr[3] = 7;
      arr[4] = 8;
      arr[5] = 13;
      
      
      System.out.println("initial array: \n");
      for(int i = 0; i < arr.length; i++) {
         System.out.println(arr[i]);
      }
      
      System.out.println("\n\noutput array: \n");
      //Sorts.mergeSortedHalves(arr, 0, (0 + arr.length - 1)/2, arr.length - 1);
      Sorts.mergeSort(arr, arr.length);
   }

}
