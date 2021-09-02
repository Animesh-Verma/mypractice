package SortingTechniques;

public class QuickSort {

    public static void main(String[] args) {

    }

    public void sort(int arr[], int low, int high){
        if(low < high){
            int pivot = partition(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }

    private int partition(int arr[] , int low , int high){
        int pivot = arr[high];
        int i = (low -1);
        return 1;
    }
}
