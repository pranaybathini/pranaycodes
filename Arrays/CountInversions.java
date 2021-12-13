package BFS;

import java.util.Arrays;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int[] temp = new int[arr.length];
        System.out.println(countInversions(arr, temp, 0 , arr.length-1));
    }

    private static int countInversions(int[] arr, int[] temp, int low, int high) {
        int inversions = 0;
        if(low < high){
            int mid = (low+high)/2;
            inversions += countInversions(arr, temp, low, mid);
            inversions += countInversions(arr, temp, mid+1, high);
            inversions += merge(arr, temp, low, mid+1, high);

        }
        System.out.println(Arrays.toString(temp));
        return inversions;
    }

    private static int merge(int[] arr, int[] temp, int low, int mid, int high) {

        int i = low;
        int j = mid;
        int k = low;
        int inversions = 0;

        while (i <= mid-1 && j <= high){
            if(arr[j] >= arr[i]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                inversions += mid-i;
            }
        }

        while (i <= mid-1) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        for(int in = low; in <= high; in++){
            arr[in] = temp[in];
        }
        return inversions;
    }
}
