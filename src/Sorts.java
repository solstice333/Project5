/*
 * Casey Wu and Kevin Navaro
 * Project 5
 * CPE 103 section 04
 */

import java.util.Arrays;
import java.lang.reflect.Array;

/*
 * Description: Sorts class contains the 5 public sorting methods as well as associated private
 * methods needed for the methods. 
 */
public class Sorts {

   // O(N^2) routines:
   /*
    * Description: Sorts the list of size elements contained in arr using the
    * selection sort algorithm
    * Parameters: array of Type. as well as the size of the array to be used for indexing
    * Preconditions: Array is a valid array, does not matter if sorted or unsorted and size is the array length not the index of last element
    * Postconditions: Array will be sorted into ascending order.
    * Return value: void
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
    * Parameters: array of Type. as well as the size of the array to be used for indexing
    * Preconditions: Array is a valid array, does not matter if sorted or unsorted and size is the array length not the index of last element
    * Postconditions: Array will be sorted into ascending order.
    * Return value: void
    */

   // Known bug: last value in list is not getting sorted
   public static <Type extends Comparable<? super Type>> void bubbleSort(
         Type[] arr, int size) {
      boolean done = false;
      while (!done) {
         done = true;
         for (int i = 0; i < size - 1; i++) {
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
    * Parameters: array of Type. as well as the size of the array to be used for indexing
    * Preconditions: Array is a valid array, does not matter if sorted or unsorted and size is the array length not the index of last element
    * Postconditions: Array will be sorted into ascending order.
    * Return value: void
    */
   public static <Type extends Comparable<? super Type>> void insertionSort(
         Type[] arr, int size) {
      for (int i = 1; i < size ; i++) {
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
    * mergeSort sort algorithm
    * Parameters: array of Type. as well as the size of the array to be used for indexing
    * Preconditions: Array is a valid array, does not matter if sorted or unsorted and size is the array length not the index of last element
    * Postconditions: Array will be sorted into ascending order.
    * Return value: void
    */
   public static <Type extends Comparable<? super Type>> void mergeSort(
         Type[] arr, int size) {
      mergeSort(arr, 0, size - 1);
   }
   /*
    * Description: Private recursive method of the mergeSort method.
    * Parameters: array of Type. The first index of the array and the last index.
    * Preconditions: Array is a valid array, does not matter if sorted or unsorted 
    * Postconditions: Array will be sorted into ascending order.
    * Return value: void
    */
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
    * Parameters: Array of Type. The leftmost, middle, and rightmost index of the array
    * Preconditions: Array of each half is sorted correctly.
    * Exceptions: Should not throw any exceptions
    * Postconditions: Completely Sorted Array
    */
   private static <Type extends Comparable<? super Type>> void mergeSortedHalves(
         Type[] arr, int left, int middle, int right) {
      
      @SuppressWarnings("unchecked")
      Type[] temp = (Type[])new Comparable[right - left + 1];
      int index1 = left;
      int index2 = middle + 1;
      int index = 0;
      
      while (index1 < middle + 1 && index2 < right + 1) {
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
      
      if (index1 < middle + 1) {
         while(index1 < middle + 1) {
            temp[index] = arr[index1];
            index1++;
            index++;
         }
      }
      
      else {
         while(index2 < right + 1) {
            temp[index] = arr[index2];
            index2++;
            index++;
         }
      }

      int j = left;
      for(int i = 0; i < temp.length; i++) {
         arr[j] = temp[i];
         j++;
      }
   }

   /*
    * Description: Sorts the list of size elements contained in arr using the
    * quick sort algorithm with median-of-three pivot and rearrangement of the
    * three elements (as done in class)
    * Parameters: Array of Type. The leftmost, middle, and rightmost index of the array
    * Preconditions: None.
    * Exceptions: Should not throw any exceptions
    * Postconditions: Completely Sorted Array
    */
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

   /*
    * Description: Method chooses the pivot value and sets it to the last element of the list
    * Parameters: Array of Type. The leftmost and rightmost index of the array
    * Preconditions: Array of each half is sorted correctly.
    * Exceptions: Should not throw any exceptions
    * Postconditions: The right end of the array is the pivot
    */
    
   private static <Type extends Comparable<? super Type>> void setPivotToEnd(
         Type[] arr, int left, int right) {
      int center = (left + right) / 2;
      if(arr[center].compareTo(arr[left]) < 0) {
         Type temp = arr[center];
         arr[center] = arr[left];
         arr[left] = temp;
      }
      if(arr[right].compareTo(arr[left]) < 0) {
         Type temp = arr[right];
         arr[right] = arr[left];
         arr[left] = temp;
      }
      if(arr[center].compareTo(arr[right]) < 0) {
         Type temp = arr[center];
         arr[center] = arr[right];
         arr[right] = temp;
      }
   }
   
   /*
    * Description: splitlist arranges the elements so the pivot value is preceded by smaller
    * values and followed by greater values
    * Parameters: Array of Type. The leftmost, middle, and rightmost index of the array
    * Preconditions: arr[right] contains the pivot
    * Return value: int of the new pivot place. 
    * Exceptions: Should not throw any exceptions
    * Postconditions: The right end of the array is the pivot
    */
    
   private static <Type extends Comparable<? super Type>> int splitList(
         Type[] arr, int left, int right) {
      int indexL = left;
      int indexR = right - 1;
      Type pivot = arr[right];
      
      while(indexL <= indexR) {
         while(arr[indexL].compareTo(pivot) < 0) {
            indexL++;
         }
         while(indexL <= indexR && arr[indexR].compareTo(pivot) > 0) {
            indexR--;
         }
         if(indexL <= indexR) {
            Type temp = arr[indexL];
            arr[indexL] = arr[indexR];
            arr[indexR] = temp;
            indexL++;
            indexR--;
         }
      }
      
      Type temp = arr[indexL];
      arr[indexL] = arr[right];
      arr[right] = temp;
      return indexL;
   }

   private static <Type extends Comparable<? super Type>> void printArray(
         Type[] arr, int size) {
      for (int i = 0; i < size; i++) {
         System.out.println(arr[i]);
      }
   }

}
