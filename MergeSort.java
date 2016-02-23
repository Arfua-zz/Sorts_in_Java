package _1_sort_labs;

import java.util.Arrays;

/**
 * Merged sorting created by Raid 08.05.2015
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr, int start, int end){
        // base of recursion
        if (start==end || (start==end-1 && arr[start]<=arr[end])) return arr;
        if (start==end-1 && arr[start]>arr[end]){
            swap(arr,start,end);
            return arr;
        }
        // recursion
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        // merge two sorted parts
        merge(arr,start,mid,end);
        return arr;
    }
    public static int[] merge(int[] arr, int start, int mid, int end){
        int[] arrtomerge = new int[arr.length];
        System.arraycopy(arr,0,arrtomerge,0,arr.length);
        int index=start;
        int k1 = start;
        int k2 = mid+1;
        while (index<arr.length){
            if (k1>mid && k2>end) break;
            else if (k1<=mid &&(k2>end || arrtomerge[k1]<=arrtomerge[k2])) {
                arr[index]=arrtomerge[k1];
                k1++;
            }
            else if (k2<=end && (k1>mid || arrtomerge[k1]>arrtomerge[k2])) {
                arr[index]=arrtomerge[k2];
                k2++;
            }
            index++;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {8,0,1,0,9,7,1,1,1,5};
        System.out.println("before : "+ Arrays.toString(arr));
        System.out.println("after : "+Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
        int[] arr2 = {9,0,7,0,5,0,3,0,0};
        System.out.println("before : "+ Arrays.toString(arr2));
        System.out.println("after : "+Arrays.toString(mergeSort(arr2, 0, arr2.length - 1)));
        int[] arr3 = {1,-9};
        System.out.println("before : "+ Arrays.toString(arr3));
        System.out.println("after : "+Arrays.toString(mergeSort(arr3, 0, arr3.length - 1)));
    }
    public static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}
