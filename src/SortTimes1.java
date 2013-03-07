import java.util.ArrayList;

public class SortTimes1 {

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

      System.out.println("TEST1: presorted list");

      // create reference arrays
      for (int i = 0; i < N[0]; i++) {
         arr.get(0)[i] = i;
      }

      for (int i = 1; i < 5; i++) {

         for (int j = 0; j < N[i]; j++) {
            if (j < N[i - 1])
               arr.get(i)[j] = arr.get(i - 1)[j];
            else
               arr.get(i)[j] = j;
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
      
      // time the operations
      startTime = System.nanoTime();
      Sorts.selectionSort(ss.get(0), N[0]);
      endTime = System.nanoTime();
      T_ss[0] = (endTime - startTime) / 1000000;

      startTime = System.nanoTime();
      Sorts.selectionSort(ss.get(1), N[1]);
      endTime = System.nanoTime();
      T_ss[1] = (endTime - startTime) / 1000000;

      startTime = System.nanoTime();
      Sorts.selectionSort(ss.get(2), N[2]);
      endTime = System.nanoTime();
      T_ss[2] = (endTime - startTime) / 1000000;

      startTime = System.nanoTime();
      Sorts.selectionSort(ss.get(3), N[3]);
      endTime = System.nanoTime();
      T_ss[3] = (endTime - startTime) / 1000000;

      startTime = System.nanoTime();
      Sorts.selectionSort(ss.get(4), N[4]);
      endTime = System.nanoTime();
      T_ss[4] = (endTime - startTime) / 1000000;

      System.out.println("N=" + N[0] + ", T_ss=" + T_ss[0]);
      System.out.println("N=" + N[1] + ", T_ss=" + T_ss[1]);
      System.out.println("N=" + N[2] + ", T_ss=" + T_ss[2]);
      System.out.println("N=" + N[3] + ", T_ss=" + T_ss[3]);
      System.out.println("N=" + N[4] + ", T_ss=" + T_ss[4]);
   }
}
