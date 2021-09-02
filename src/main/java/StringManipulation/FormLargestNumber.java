package StringManipulation;

import java.util.*;

class FormLargestNumber {

    public static void printLargest(List<String> arr) {
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x = o1 + o2;
                String y = o2 + o1;
                return x.compareTo(y) > 0 ? -1 : 1;
            }
        });
        Iterator<String> it = arr.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

    public static void main(String[] args) {
        List<String> arr= new ArrayList<>();
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }
}
