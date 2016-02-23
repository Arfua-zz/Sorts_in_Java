package _1_sort_labs;

import java.util.Arrays;

/**
 * Created by Raid on 06.05.2015.
 */
public class QuickSort {
    public static int[] quickSort(int[] arr, int start, int end){
        if (start==end) return arr;
        if (start==end-1){
            if (arr[start]>arr[end]) {
                swap(arr, start, end);
                return arr;
            }
            else return arr;
            }

        double index = findAverageOfMinMax(arr,start,end);
        int l=start;
        int r=end;
        while (l<r){
            while (l<=end && arr[l]<index) l++;
            while (r>=start && arr[r]>=index) r--;
            if (l<r) swap(arr,l,r);
        }
        if (r<start) return arr;

        // find last element in 1st group and first element in 2nd group
        int end1 = r;
        int start2 = l;

        quickSort(arr, start, end1);
        quickSort(arr,start2,end);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9,0,1,8,3,9,9,9,9,9,0,0,0,0,-3};
        System.out.println("before : "+Arrays.toString(arr));
        System.out.println("after : "+Arrays.toString(quickSort(arr, 0, arr.length - 1)));
    }
    public static double findAverageOfMinMax(int[] arr, int start, int end){
        double min=arr[start];
        double max=arr[start];
        for (int i=start; i<=end; i++){
            if (min>arr[i]) min=arr[i];
            if (max<arr[i]) max=arr[i];
        }
        return (max+min)/2;
    }

    public static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}
