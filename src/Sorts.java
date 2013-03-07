import java.util.Arrays;

public class Sorts {

   // O(N^2) routines:
   /*
    * Description: Sorts the list of size elements contained in arr using the
    * selection sort algorithm
    */
   public static <Type extends Comparable<? super Type>> void selectionSort(
         Type[] arr, int size) {
      int j = 0;
      int minIndex = 0;
      Type temp;

      for (int i = 0; i <= size - 2; i++) {
         minIndex = i;
         for (j = i + 1; j <= size - 1; j++) {
            if (arr[j].compareTo(arr[minIndex]) < 0)
               minIndex = j;
         }

         temp = arr[i];
         arr[i] = arr[minIndex];
         arr[minIndex] = temp;
      }
   }

   /*
    * Description: Sorts the list of size elements contained in arr using the
    * bubble sort algorithm
    */
   
   //Known bug: last value in list is not getting sorted
   public static <Type extends Comparable<? super Type>> void bubbleSort(
         Type[] arr, int size) {
      boolean done = false;
      while (!done) {
         done = true;
         for (int i = 0; i < size - 2; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
               Type temp;
               temp = arr[i];
               arr[i] = arr[i + 1];
               arr[i + 1] = temp;
               done = false;
            }
         }
      }
   }

   /*
    * Description: Sorts the list of size elements contained in arr using the
    * insertion sort algorithm
    */
   public static <Type extends Comparable<? super Type>> void insertionSort(
         Type[] arr, int size) {
      for (int i = 1; i < size - 1; i++) {
         Type temp = arr[i];
         int j = i;
         while (j != 0 && arr[j - 1].compareTo(temp) > 0) {
            arr[j] = arr[j - 1];
            j--;
         }
         arr[j] = temp;
      }
   }

   // O(NlogN) routines:
   /*
    * Description: Sorts the list of size elements contained in arr using the
    * merge sort algorithm
    */
   public static <Type extends Comparable<? super Type>> void mergeSort(
         Type[] arr, int size) {
      mergeSort(arr, 0, size - 1);
   }

   private static <Type extends Comparable<? super Type>> void mergeSort(
         Type[] arr, int first, int last) {
      if (first < last) {
         int middle = (first + last) / 2;
         mergeSort(arr, first, middle);
         mergeSort(arr, middle + 1, last);
         mergeSortedHalves(arr, first, middle, last);
      }
   }

   /*
    * Description: Sorts the list of size elements contained in arr using the
    * merge sort algorithm Preconditions: arr[left - middle] is sorted and
    * arr[middle+1 - right] is sorted Postcondition: arr[left - right] is sorted
    * completely.
    */
   private static <Type extends Comparable<? super Type>> void mergeSortedHalves(
         Type[] arr, int left, int middle, int right) {
      Type[] temp = (Type[]) new Object[right - left + 1];
      int index1 = left;
      int index2 = middle + 1;
      int index = 0;
      while (arr[index1] != null && arr[index2] != null) {
         if (arr[index1].compareTo(arr[index2]) < 0) {
            temp[index] = arr[index1];
            index1++;
         }
         else {
            temp[index] = arr[index2];
            index2++;
         }
         index++;
      }
      while (arr[index1] != null) {
         temp[index] = arr[index1];
         index1++;
         index++;
      }
      while (arr[index2] != null) {
         temp[index] = arr[index2];
         index2++;
         index++;
      }
      for (int i = 0; i < right; i++) {
         arr[i] = temp[i];
      }
   }

   /*
    * Description: Sorts the list of size elements contained in arr using the
    * quick sort algorithm with median-of-three pivot and rearrangement of the
    * three elements (as done in class)
    */
   public static <Type extends Comparable<? super Type>> void quickSort(
         Type[] arr, int size) {
      quickSort(arr, 0, size - 1);
   }

   private static <Type extends Comparable<? super Type>> void quickSort(
         Type[] arr, int first, int last) {
      if (first < last) {
         setPivotToEnd(arr, first, last);
         int pivotIndex = splitList(arr, first, last);
         quickSort(arr, first, pivotIndex - 1);
         quickSort(arr, pivotIndex + 1, last);
      }
   }

   private static <Type extends Comparable<? super Type>> int splitList(
         Type[] arr, int first, int last) {
      // TODO Auto-generated method stub
      return 0;
   }

   /*
    * Description: Preconditions: None Postcondition: arr[right] is the pivot.
    */
   private static <Type extends Comparable<? super Type>> void setPivotToEnd(
         Type[] arr, int left, int right) {
      int center = (left + right) / 2;
      /*
       * if(arr[center] < arr[left]) {
       * 
       * }
       */
   }
   
   private static <Type extends Comparable<? super Type>> void printArray(Type[] arr) {
      for(int i = 0; i < arr.length; i++) {
         System.out.println(arr[i]);
      }
   }

}
