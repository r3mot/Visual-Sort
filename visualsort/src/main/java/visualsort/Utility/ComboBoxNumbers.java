package visualsort.Utility;

public class ComboBoxNumbers {

    private static int[] min;
    private static int[] max;
    private static int maxSize = 100;
    private static int minSize = 90;
    
    public static int[] getMinValues(){

        min = new int[maxSize];
        for(int i = 0; i < maxSize; i++){
            min[i] = i;
        }
        return min;

    }

    public static int[] getMaxValues(int min){

        min += 11;
        max = new int[minSize];
        
        for(int i = 0; i < minSize; i++){
            max[i] = min + i;
        }
        return max;
    }
    
}
