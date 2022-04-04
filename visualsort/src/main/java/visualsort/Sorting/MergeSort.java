package visualsort.Sorting;

import java.util.ArrayList;
import java.util.Iterator;

public class MergeSort {

    private String[] iterations;
    private int[][] currItr;
    private int steps = 0;

    public String[] getSteps() {
        return iterations;
    }

    public void sort(ArrayList<Integer> array) {


        iterations = new String[50];
        currItr = new int[50][50];

        mergesort(array, 0, array.size() - 1);

    }

    private void mergesort(ArrayList < Integer > array, int low, int high) {

        if (high <= low) return;

        int mid = (low + high) / 2;
        mergesort(array, low, mid);
        mergesort(array, mid + 1, high);
        merge(array, low, mid, high);

    }

    private void merge(ArrayList < Integer > array, int low, int mid, int high) {

        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array.get(low + i);

        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array.get(mid + i + 1);

        int left = 0;
        int right = 0;


        for (int i = low; i < high + 1; i++) {

            iterations[steps] = array.toString();
            updateRectangleArray(array, steps);
            steps++;

            if (left < leftArray.length && right < rightArray.length) {

                if (leftArray[left] < rightArray[right]) {

                    array.set(i, leftArray[left]);
                    left++;

                } else {

                    array.set(i, rightArray[right]);
                    right++;

                }
            } else if (left < leftArray.length) {
   
                array.set(i, leftArray[left]);
                left++;

            } else if (right < rightArray.length) {
  
                array.set(i, rightArray[right]);
                right++;

            }
        }
    }

    private void updateRectangleArray(ArrayList < Integer > arr, int row) {

        int swapRow = 0;
        Iterator<Integer> itr = arr.iterator();

        while (itr.hasNext()) {

            currItr[row][swapRow] = itr.next();
            swapRow++;

        }
    }
    
}
