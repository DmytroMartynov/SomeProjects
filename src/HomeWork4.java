import java.util.Arrays;

public class HomeWork4 {


    public static void main(String[] args) {
        int[] arr = {3,10,20,43,1,2,4,5,6,8,};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int x = 13;
        int i = binarySearch(arr, x);
        if(i == -1){
            System.out.println("Dont have this int number :( ");
        } else
            System.out.println("Find number index " + i);

    }
    static int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}
