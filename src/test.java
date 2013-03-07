import java.util.Random;

//shallow copy test
public class test {

   public static void main(String[] args) {
      Integer[] arr = new Integer[10];
      Random rand = new Random();
      Integer[] temp;
      
      for(int i = 0; i < arr.length; i++) {
         arr[i] = rand.nextInt();
      }
      temp = arr;
      
      Sorts.selectionSort(arr, arr.length);
      
      for(int i = 0; i < temp.length; i++) {
         System.out.println(temp[i]);
      }
   }

}
