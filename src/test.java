import java.util.Random;

public class test {

   public static void main(String[] args) {
      Integer[] arr = new Integer[6];
      Random rand = new Random();
      
      arr[0] = 5;
      arr[1] = 3;
      arr[2] = 2;
      arr[3] = 7;
      arr[4] = 4;
      arr[5] = 1;
      
      System.out.println("initial array: \n");
      for(int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " " );
      }
      
      System.out.println("\n\noutput array: ");
      //Sorts.mergeSortedHalves(arr, 0, (0 + arr.length - 1)/2, arr.length - 1);
      Sorts.bubbleSort(arr, arr.length);
      for(int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      
      System.out.println("output array: ");
      arr = new Integer[10000];

      for (int i = 0; i < arr.length; i++) {
         arr[i] = rand.nextInt(10000);
      }
      Sorts.bubbleSort(arr, arr.length);
      for(int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      

   }

}
