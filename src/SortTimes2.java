/*
 * Casey Wu and Kevin Navaro
 * Project 5
 * CPE 103 section 04
 */

import java.util.ArrayList;

/*
 * Description: runs sorts algorithms with input of reverse-sorted lists 
 */
public class SortTimes2 {

   /*
    * Description: main method for SortTimes2 - inputs reverse-sorted lists into sort algorithms and
    * calculates the execution time
    */
   public static void main(String[] args) {
      final int[] N = { 5000, 10000, 20000, 40000, 80000 };
      ArrayList<Integer[]> arr = new ArrayList<Integer[]>(5);
      ArrayList<Integer[]> ss = new ArrayList<Integer[]>(5);
      ArrayList<Integer[]> bs = new ArrayList<Integer[]>(5);
      ArrayList<Integer[]> is = new ArrayList<Integer[]>(5);
      ArrayList<Integer[]> ms = new ArrayList<Integer[]>(5);
      ArrayList<Integer[]> qs = new ArrayList<Integer[]>(5);

      for (int i = 0; i < 5; i++) {
         arr.add(new Integer[80000]);
         ss.add(new Integer[80000]);
         bs.add(new Integer[80000]);
         is.add(new Integer[80000]);
         ms.add(new Integer[80000]);
         qs.add(new Integer[80000]);
      }

      long startTime, endTime;
      long[] T_ss = new long[5];
      long[] T_bs = new long[5];
      long[] T_is = new long[5];
      long[] T_ms = new long[5];
      long[] T_qs = new long[5];

      System.out.println("TEST2: reversed sorted list");

      // create reference arrays
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < N[i]; j++) {
            arr.get(i)[j] = N[i] - j;
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

      // time the operations for every sorting method, every array at size N[i]
      for (int i = 0; i < 5; i++) {
         startTime = System.nanoTime();
         Sorts.selectionSort(ss.get(i), N[i]);
         endTime = System.nanoTime();
         T_ss[i] = (endTime - startTime) / 1000000;

         startTime = System.nanoTime();
         Sorts.bubbleSort(bs.get(i), N[i]);
         endTime = System.nanoTime();
         T_bs[i] = (endTime - startTime) / 1000000;

         startTime = System.nanoTime();
         Sorts.insertionSort(is.get(i), N[i]);
         endTime = System.nanoTime();
         T_is[i] = (endTime - startTime) / 1000000;

         startTime = System.nanoTime();
         Sorts.mergeSort(ms.get(i), N[i]);
         endTime = System.nanoTime();
         T_ms[i] = (endTime - startTime) / 1000000;

         startTime = System.nanoTime();
         Sorts.quickSort(qs.get(i), N[i]);
         endTime = System.nanoTime();
         T_qs[i] = (endTime - startTime) / 1000000;

         System.out.println("N=" + N[i] + ", T_ss=" + T_ss[i] + ", T_bs="
               + T_bs[i] + ", T_is=" + T_is[i] + ", T_ms=" + T_ms[i]
               + ", T_qs=" + T_qs[i]);
      }
      System.out.println("END TEST2");
   }
}
