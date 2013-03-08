import java.util.ArrayList;
import java.util.Random;

public class SortTimes3 {

   public static void main(String[] args) {
      final int[] N = { 5000, 10000, 20000, 40000, 80000 };
      Random rand = new Random();
      ArrayList<Integer[]> arr;
      ArrayList<Integer[]> ss;
      ArrayList<Integer[]> bs;
      ArrayList<Integer[]> is;
      ArrayList<Integer[]> ms;
      ArrayList<Integer[]> qs;

      long startTime, endTime;
      long[] T_ss = new long[15];
      long[] T_bs = new long[15];
      long[] T_is = new long[15];
      long[] T_ms = new long[15];
      long[] T_qs = new long[15];

      System.out.println("TEST3: unsorted list");

      int start = 0;
      for (int ndx = 0; ndx < 3; ndx++) {
         arr = new ArrayList<Integer[]>(5);
         ss = new ArrayList<Integer[]>(5);
         bs = new ArrayList<Integer[]>(5);
         is = new ArrayList<Integer[]>(5);
         ms = new ArrayList<Integer[]>(5);
         qs = new ArrayList<Integer[]>(5);

         for (int i = 0; i < 5; i++) {
            arr.add(new Integer[80000]);
            ss.add(new Integer[80000]);
            bs.add(new Integer[80000]);
            is.add(new Integer[80000]);
            ms.add(new Integer[80000]);
            qs.add(new Integer[80000]);
         }

         // create reference arrays
         for (int i = 0; i < N[0]; i++) {
            arr.get(0)[i] = rand.nextInt(N[0]);
         }

         for (int i = 1; i < 5; i++) {
            for (int j = 0; j < N[i]; j++) {
               if (j < N[i - 1])
                  arr.get(i)[j] = arr.get(i - 1)[j];
               else
                  arr.get(i)[j] = rand.nextInt(N[i]);
            }
         }

         // copy content of reference arrays into input arrays
         for (int i = 0; i < 5; i++) {
            for (int j = 0; j < N[i]; j++) {
               ss.get(i)[j] = arr.get(i)[j];
               bs.get(i)[j] = arr.get(i)[j];
               is.get(i)[j] = arr.get(i)[j];
               ms.get(i)[j] = arr.get(i)[j];
               qs.get(i)[j] = arr.get(i)[j];
            }
         }

         // time the operations for every sorting method, every array at size
         // N[i]
         for (int i = start; i < 5 + 5 * ndx; i++) {
            startTime = System.nanoTime();
            Sorts.selectionSort(ss.get(i - 5 * ndx), N[i - 5 * ndx]);
            endTime = System.nanoTime();
            T_ss[i] = (endTime - startTime) / 1000000;

            startTime = System.nanoTime();
            Sorts.bubbleSort(bs.get(i - 5 * ndx), N[i - 5 * ndx]);
            endTime = System.nanoTime();
            T_bs[i] = (endTime - startTime) / 1000000;

            startTime = System.nanoTime();
            Sorts.insertionSort(is.get(i - 5 * ndx), N[i - 5 * ndx]);
            endTime = System.nanoTime();
            T_is[i] = (endTime - startTime) / 1000000;

            startTime = System.nanoTime();
            Sorts.mergeSort(ms.get(i - 5 * ndx), N[i - 5 * ndx]);
            endTime = System.nanoTime();
            T_ms[i] = (endTime - startTime) / 1000000;

            startTime = System.nanoTime();
            Sorts.quickSort(qs.get(i - 5 * ndx), N[i - 5 * ndx]);
            endTime = System.nanoTime();
            T_qs[i] = (endTime - startTime) / 1000000;
            
            System.out.println("Finished getting times for N[" + (i - 5*ndx) + "]");
         }
         start += 5;
         System.out.println("Finished iteration " + (ndx + 1));
      }
      System.out.println("Done!");

      /*
       * for (int i = 0; i < 5; i++) { System.out.println("N=" + N[i] +
       * ", T_ss=" + T_ss[i] + ", T_bs=" + T_bs[i] + ", T_is=" + T_is[i] +
       * ", T_ms=" + T_ms[i] + ", T_qs=" + T_qs[i]); }
       * System.out.println("END TEST3");
       */
   }
}
