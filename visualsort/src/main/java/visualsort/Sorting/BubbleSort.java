package visualsort.Sorting;

import java.util.ArrayList;
import java.util.Iterator;

import visualsort.MainController;

public class BubbleSort {

    private String[] iterations;
    private int[][] iteration_values;

    public BubbleSort(){

        iterations = new String[10];
        iteration_values = new int[10][10];

    }

    public void sort(ArrayList < Integer > array) {

        bubbleSort(array);
        sendToController();

    }


    private void bubbleSort(ArrayList < Integer > array) {

        int size = array.size();

        for (int i = 0; i < size; i++) { 

            iterations(array, i);

            for(int j = 0; j < size - i - 1; j++){
                if(array.get(j) > array.get(j+1)){
                    swap(array, j, j+1);
                }
            }
        }
    }

    private void swap(ArrayList<Integer> array, int a, int b){

        int temp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, temp);

    }

    private void iterations(ArrayList<Integer> array, int index){

        iterations[index] = array.toString();
        updateRectangleArray(array, index);

    }

    private void updateRectangleArray(ArrayList<Integer> arr, int row) {

        int col = 0;
        Iterator <Integer> itr = arr.iterator();

        while (itr.hasNext()) {
            iteration_values[row][col] = itr.next();
            col++;
        }

    }
    
    private void sendToController(){
        MainController.setIntIterations(iteration_values);
        MainController.setStringIterations(iterations);
    }
}
