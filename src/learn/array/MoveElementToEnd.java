package learn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,4,5,6};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println(moveElementToEnd(list, 3));
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = 0;
        while( j < array.size()) {
            if(array.get(j) != toMove) {
                array.set(i, array.get(j));
                i++;
            }
            j++;
        }
        while(i<array.size()) {
            array.set(i, toMove);
            i++;
        }
        return array;
    }

}
