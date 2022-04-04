package visualsort.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomArray {

    private ArrayList<Integer> toSort;
    private Set<Integer> uniqueArray;
    private final Random random;
    private final int SIZE = 10;

    public RandomArray(int min, int max) {
        random = new Random();
        toSort = new ArrayList<>();
        randomArray(min, max);
    }

    private void randomArray(int min, int max) {

        uniqueArray = new HashSet<>();

        while (uniqueArray.size() < SIZE) {
            uniqueArray.add(random.nextInt(max) + min);
        }

        final Iterator < Integer > itr = uniqueArray.iterator();

        while (itr.hasNext()) {
            toSort.add(itr.next());
        }
    }

    public ArrayList <Integer> getArray() {
        Collections.shuffle(toSort); // Used collections shuffle to exaggerate the sort
        return toSort;
    }
    
}
