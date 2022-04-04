package visualsort.Utility;

public class ComboValues {

    private int[] min;
    private int[] max;
    private int maxSize = 100;
    private int minSize = 90;
    
    public int[] getMinValues(){

        min = new int[maxSize];
        for(int i = 0; i < maxSize; i++){
            min[i] = i;
        }
        return min;
    }

    public int[] getMaxValues(int min){

        min += 11;
        max = new int[minSize];
        
        for(int i = 0; i < minSize; i++){
            max[i] = min + i;
        }
        return max;
    }
    
}
