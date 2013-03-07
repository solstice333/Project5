import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

//sanity checking for sort method functionality
public class JunitTest {

   @Test
   public void test() {

      Random rand = new Random();
      Integer[] arr = new Integer[100];

      for (int i = 0; i < arr.length; i++) {
         arr[i] = rand.nextInt(100);
      }

      Sorts.bubbleSort(arr, arr.length);

      for (int i = 0; i < arr.length - 1; i++) {
         Assert.assertTrue(arr[i] <= arr[++i]);
      }
   }
}
